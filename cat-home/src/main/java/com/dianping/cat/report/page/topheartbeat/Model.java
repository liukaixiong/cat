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
package com.dianping.cat.report.page.topheartbeat;

import com.dianping.cat.consumer.heartbeat.HeartbeatAnalyzer;
import com.dianping.cat.consumer.heartbeat.model.entity.HeartbeatReport;
import com.dianping.cat.helper.SortHelper;
import com.dianping.cat.mvc.AbstractReportModel;
import com.dianping.cat.report.ReportPage;
import com.dianping.cat.report.page.topheartbeat.model.HeartbeatModel;
import org.unidal.web.mvc.view.annotation.EntityMeta;
import org.unidal.web.mvc.view.annotation.ModelMeta;

import java.util.*;

@ModelMeta(HeartbeatAnalyzer.ID)
public class Model extends AbstractReportModel<Action, ReportPage, Context> {

    private int m_hour;

    private String m_ipAddress;

    @EntityMeta
    private HeartbeatReport m_report;

    private transient HeartbeatSvgGraph m_result;

    private List<String> m_extensionGroups = new ArrayList<String>();

    private int m_extensionCount;

    private String m_extensionHistoryGraphs;

    private Date reportStart;

    private Date reportEnd;

    private List<HeartbeatModel> heartbeatModelList;

    private Map<String, HeartbeatSvgGraph.ExtensionGroup> m_extensionGraph = new HashMap<String, HeartbeatSvgGraph.ExtensionGroup>();

    public Model(Context ctx) {
        super(ctx);
    }


    public Date getReportStart() {
        return reportStart;
    }

    public void setReportStart(Date reportStart) {
        this.reportStart = reportStart;
    }

    public Date getReportEnd() {
        return reportEnd;
    }

    public void setReportEnd(Date reportEnd) {
        this.reportEnd = reportEnd;
    }

    @Override
    public Action getDefaultAction() {
        return Action.VIEW;
    }

    @Override
    public String getDomain() {
        if (m_report == null) {
            return getDisplayDomain();
        } else {
            return m_report.getDomain();
        }
    }

    public int getExtensionCount() {
        return m_extensionCount;
    }

    public void setExtensionCount(int extensionCount) {
        m_extensionCount = extensionCount;
    }

    public Map<String, HeartbeatSvgGraph.ExtensionGroup> getExtensionGraph() {
        return m_extensionGraph;
    }

    public void setExtensionGraph(Map<String, HeartbeatSvgGraph.ExtensionGroup> extensionGraph) {
        m_extensionGraph = extensionGraph;
    }

    public List<String> getExtensionGroups() {
        return m_extensionGroups;
    }

    public void setExtensionGroups(List<String> extensionGroups) {
        m_extensionGroups = extensionGroups;
    }

    public String getExtensionHistoryGraphs() {
        return m_extensionHistoryGraphs;
    }

    public void setExtensionHistoryGraphs(String extensionHistoryGraphs) {
        m_extensionHistoryGraphs = extensionHistoryGraphs;
    }

    public int getHour() {
        return m_hour;
    }

    public void setHour(int hour) {
        m_hour = hour;
    }

    @Override
    public String getIpAddress() {
        return m_ipAddress;
    }

    @Override
    public void setIpAddress(String ipAddress) {
        m_ipAddress = ipAddress;
    }

    public List<String> getIps() {
        if (m_report == null) {
            return new ArrayList<String>();
        } else {
            return SortHelper.sortIpAddress(m_report.getIps());
        }
    }

    public HeartbeatReport getReport() {
        return m_report;
    }

    public void setReport(HeartbeatReport report) {
        m_report = report;
    }

    public HeartbeatSvgGraph getResult() {
        return m_result;
    }

    public void setResult(HeartbeatSvgGraph result) {
        m_result = result;
    }

    public List<HeartbeatModel> getHeartbeatModelList() {
        return heartbeatModelList;
    }

    public void setHeartbeatModelList(List<HeartbeatModel> heartbeatModelList) {
        this.heartbeatModelList = heartbeatModelList;
    }
}
