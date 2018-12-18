package com.dianping.cat.report.page.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.util.Comparator;

/**
 * @author : liukx
 * @create : 2018/11/30 11:19
 * @email : liukx@elab-plus.com
 */
public class ReflexObjectComparator implements Comparator<Object> {
    /**
     * 需要比较的字段名称
     */
    private String field;

    private int errorCode = 3;

    public ReflexObjectComparator(String field) {
        this.field = field;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == null || o2 == null) {
            System.out.println(" 值无法比较 ...");
            return 0;
        }
        try {
            String f1 = BeanUtils.getProperty(o1, this.field);
            String f2 = BeanUtils.getProperty(o2, this.field);


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
        } catch (Exception e) {
            System.out.println(" 转换异常 ... ");
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
