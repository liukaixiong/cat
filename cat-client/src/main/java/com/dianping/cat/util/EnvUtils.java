package com.dianping.cat.util;

import org.unidal.lookup.util.StringUtils;

import java.util.Properties;

/**
 * 获取环境变量参数
 *
 * @author Liukx
 * @create 2019-01-15 11:48
 * @email liukx@elab-plus.com
 **/
public class EnvUtils {
    /**
     * 默认的文件名
     */
    private static final String APPLICATION_FILE = "application";

    private static final String APPLICATION_NAME = "spring.application.name";
    /**
     * 环境变量配置
     */
    private static final String PROFILES = "spring.profiles.active";

    /**
     * 获取类似SpringBoot的配置文件
     *
     * @return
     */
    public static String getSystemPropertyFile() {
        String fileName = null;
        String profiles = getSystemEnvProperty(PROFILES);
        if (StringUtils.isNotEmpty(profiles)) {
            fileName = APPLICATION_FILE + "-" + profiles + ".yml";
        }
        return fileName;
    }

    /**
     * 从环境变量中获取应用名称
     *
     * @return
     */
    public static String getDomainEnv() {
        String applicationName = getSystemEnvProperty(APPLICATION_NAME);
        if (StringUtils.isNotEmpty(applicationName)) {
            applicationName = getEnvApplication(applicationName);
        }
        return applicationName;
    }

    public static String getEnvApplication(String applicationName) {
        String profiles = getSystemEnvProperty(PROFILES);
        if (StringUtils.isNotEmpty(profiles)) {
            applicationName = profiles + "-" + applicationName;
        }
        return applicationName;
    }

    /**
     * 从属性对象中找寻应用名称
     *
     * @param prop
     * @return
     */
    public static String getDomain(Properties prop) {
        String applicationName = prop.getProperty(APPLICATION_NAME);
        if (StringUtils.isNotEmpty(applicationName)) {
            return getEnvApplication(applicationName);
        }
        return applicationName;
    }

    /**
     * 从系统变量和环境变量中获取
     *
     * @param key
     * @return
     */
    private static String getSystemEnvProperty(String key) {
        String val = System.getenv(key);

        if (StringUtils.isEmpty(val)) {
            Properties properties = System.getProperties();
            val = properties.getProperty(key);
        }
        return val;
    }


}
