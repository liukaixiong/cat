package com.dianping.cat.report.page.tophour.model;

import java.util.Map;

/**
 * 异常错误汇总
 *
 * @author : liukx
 * @create : 2018/11/28 16:47
 * @email : liukx@elab-plus.com
 */
public class ErrorDomainModel {
    private String domain;
    private Map<String, Integer> errorText;
    private int count;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Map<String, Integer> getErrorText() {
        return errorText;
    }

    public void setErrorText(Map<String, Integer> errorText) {
        this.errorText = errorText;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
