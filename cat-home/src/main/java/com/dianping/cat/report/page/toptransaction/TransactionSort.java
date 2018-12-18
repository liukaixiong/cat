package com.dianping.cat.report.page.toptransaction;

import com.dianping.cat.consumer.transaction.model.entity.TransactionType;
import com.dianping.cat.report.page.toptransaction.model.TransactionInfo;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

/**
 * @author : liukx
 * @create : 2018/12/4 17:51
 * @email : liukx@elab-plus.com
 */
public class TransactionSort implements Comparator<TransactionInfo> {

    private String sortField;
    private int errorCode = 3;

    private boolean nullsAreHigh = true;


    public TransactionSort(String sortFiled) {
        this.sortField = sortFiled;
    }

    @Override
    public int compare(TransactionInfo o1, TransactionInfo o2) {
        TransactionType t1 = o1.getTransactionType();
        TransactionType t2 = o2.getTransactionType();
        if (t1 == null) {
            return (this.nullsAreHigh ? 1 : -1);
        }
        if (t2 == null) {
            return (this.nullsAreHigh ? -1 : 1);
        }
        try {
            String f1 = BeanUtils.getProperty(t1, this.sortField);
            String f2 = BeanUtils.getProperty(t2, this.sortField);

            int result = isInt(f1, f2);
            if (result != errorCode) {
                return result;
            }
            result = isDouble(f1, f2);
            if (result != errorCode) {
                return result;
            }
            result = isLong(f1, f2);
            if (result != errorCode) {
                return result;
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public int isInt(String f1, String f2) {
        try {
            Integer left = Integer.valueOf(f1);
            Integer right = Integer.valueOf(f2);
            if (left > right) {
                return -1;
            }
            return 1;
        } catch (Exception e) {
            return errorCode;
        }
    }

    public int isDouble(String f1, String f2) {
        try {
            Double left = Double.valueOf(f1);
            Double right = Double.valueOf(f2);
            if (left > right) {
                return -1;
            }
            return 1;
        } catch (Exception e) {
            return errorCode;
        }
    }

    public int isLong(String f1, String f2) {
        try {
            Long left = Long.valueOf(f1);
            Double right = Double.valueOf(f2);
            if (left > right) {
                return -1;
            }
            return 1;
        } catch (Exception e) {
            return errorCode;
        }
    }
}
