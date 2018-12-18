package com.dianping.cat.report.page.toptransaction.model;

import com.dianping.cat.consumer.transaction.model.entity.TransactionType;

/**
 * @author : liukx
 * @create : 2018/12/4 10:10
 * @email : liukx@elab-plus.com
 */
public class TransactionInfo {

    private String domain;

    private TransactionType transactionType;

    public TransactionInfo(String domain, TransactionType transactionType) {
        this.domain = domain;
        this.transactionType = transactionType;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

}
