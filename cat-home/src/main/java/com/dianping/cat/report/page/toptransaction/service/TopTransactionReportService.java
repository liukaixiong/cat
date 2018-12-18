/*
 * Copyright (c) 2011-2018, Meituan Dianping. All Rights Reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dianping.cat.report.page.toptransaction.service;

import com.alibaba.fastjson.JSON;
import com.dianping.cat.Cat;
import com.dianping.cat.consumer.top.TopAnalyzer;
import com.dianping.cat.consumer.top.TopReportMerger;
import com.dianping.cat.consumer.top.model.entity.TopReport;
import com.dianping.cat.consumer.top.model.transform.DefaultNativeParser;
import com.dianping.cat.consumer.transaction.model.entity.TransactionType;
import com.dianping.cat.core.dal.*;
import com.dianping.cat.helper.TimeHelper;
import com.dianping.cat.report.service.AbstractReportService;
import org.unidal.dal.jdbc.DalException;
import org.unidal.dal.jdbc.DalNotFoundException;
import org.unidal.lookup.annotation.Inject;
import org.unidal.lookup.annotation.Named;

import java.util.Date;
import java.util.List;

@Named
public class TopTransactionReportService extends AbstractReportService<TopReport> {


    @Inject
    private TopDayDao topDayDao;

    @Override
    public TopReport makeReport(String domain, Date start, Date end) {
        TopReport report = new TopReport(domain);

        report.setStartTime(start);
        report.setEndTime(end);
        return report;
    }

    @Override
    public TopReport queryDailyReport(String domain, Date start, Date end) {
        throw new RuntimeException("Top report don't support daily report");
    }

    private TopReport queryFromHourlyBinary(int id, Date period, String domain) throws DalException {
        HourlyReportContent content = m_hourlyReportContentDao
                .findByPK(id, period, HourlyReportContentEntity.READSET_CONTENT);

        if (content != null) {
            return DefaultNativeParser.parse(content.getContent());
        } else {
            return new TopReport(domain);
        }
    }

    public List<TopDay> queryHourlyReport(String type, Date date, String indexData) {
        try {
            return topDayDao.findByList(type, date, indexData, TopDayEntity.READSET_FULL);
        } catch (DalException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insertTopDay(TransactionType transactionType, String domain, Date date, String indexData) {
        int insert = 0;
        if (transactionType != null) {
            transactionType.setGraphTrend(null);
            transactionType.getNames().clear();

            TopDay topDay = new TopDay();
            topDay.setDataJson(JSON.toJSONString(transactionType));
            topDay.setDataTime(date);
            topDay.setIndexData(indexData);
            topDay.setType("1");
            topDay.setCreateTime(new Date());
            topDay.setDomain(domain);
            try {
                insert = topDayDao.insert(topDay);
            } catch (DalException e) {
                e.printStackTrace();
            }
        }
        return insert;
    }


    @Override
    public TopReport queryHourlyReport(String domain, Date start, Date end) {
        TopReportMerger merger = new TopReportMerger(new TopReport(domain));
        long startTime = start.getTime();
        long endTime = end.getTime();
        String name = TopAnalyzer.ID;

        for (; startTime < endTime; startTime = startTime + TimeHelper.ONE_HOUR) {
            List<HourlyReport> reports = null;
            try {
                reports = m_hourlyReportDao
                        .findAllByDomainNamePeriod(new Date(startTime), domain, name, HourlyReportEntity.READSET_FULL);
            } catch (DalException e) {
                Cat.logError(e);
            }
            if (reports != null) {
                for (HourlyReport report : reports) {
                    try {
                        TopReport reportModel = queryFromHourlyBinary(report.getId(), report.getPeriod(), domain);
                        reportModel.accept(merger);
                    } catch (DalNotFoundException e) {
                        // ignore
                    } catch (Exception e) {
                        Cat.logError(e);
                    }
                }
            }
        }
        TopReport topReport = merger.getTopReport();

        topReport.setStartTime(start);
        topReport.setEndTime(new Date(end.getTime() - 1));
        return topReport;
    }

    @Override
    public TopReport queryMonthlyReport(String domain, Date start) {
        throw new RuntimeException("Top report don't support monthly report");
    }

    @Override
    public TopReport queryWeeklyReport(String domain, Date start) {
        throw new RuntimeException("Top report don't support weekly report");
    }

}
