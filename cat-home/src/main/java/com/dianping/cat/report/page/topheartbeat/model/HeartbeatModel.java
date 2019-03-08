package com.dianping.cat.report.page.topheartbeat.model;

/**
 * 心跳预览实体
 *
 * @author : liukx
 * @create : 2018/11/29 18:45
 * @email : liukx@elab-plus.com
 */
public class HeartbeatModel {

    /**
     * 项目名称
     */
    private String domain;

    /**
     * 当前新生代执行次数
     */
    private Double scavengeCount = 0d;
    /**
     * 新生代一共执行时间
     */
    private Double scavengeTime = 0d;
    /**
     * 新生代平均执行时间
     */
    private Double avgScavengeTime = 0d;
    /**
     * 新生代选举ip
     */
    private String scavengeIp;


    /**
     * 老年代执行次数
     */
    private Double markSweepCount = 0d;
    /**
     * 老年代执行时间
     */
    private Double markSweepTime = 0d;
    /**
     * 老年代平均执行时长
     */
    private Double avgMarkSweepTime = 0d;

    /**
     * 老年代选举ip
     */
    private String markSweepIp;

    /**
     * 可用内存
     */
    private Double freePhysicalMemory = 0d;

    /**
     * 内存最少的服务器
     */
    private String freePhysicalMemoryIp;

    /**
     * 系统负载
     */
    private Double loadAverage = 0d;

    /**
     * 负载最高的IP地址
     */
    private String loadAverageIp;


    /**
     * 当前存活的线程数
     */
    private Double activeThread = 0d;

    /**
     * 存活线程最多的Ip
     */
    private String activeThreadIp;

    /**
     * 本次查询耗时
     */
    private Long findTime;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Double getScavengeCount() {
        return scavengeCount;
    }

    public void setScavengeCount(Double scavengeCount) {
        this.scavengeCount = scavengeCount;
    }

    public Double getScavengeTime() {
        return scavengeTime;
    }

    public void setScavengeTime(Double scavengeTime) {
        this.scavengeTime = scavengeTime;
    }

    public Double getAvgScavengeTime() {
        return avgScavengeTime;
    }

    public void setAvgScavengeTime(Double avgScavengeTime) {
        this.avgScavengeTime = avgScavengeTime;
    }

    public Double getMarkSweepCount() {
        return markSweepCount;
    }

    public void setMarkSweepCount(Double markSweepCount) {
        this.markSweepCount = markSweepCount;
    }

    public Double getMarkSweepTime() {
        return markSweepTime;
    }

    public void setMarkSweepTime(Double markSweepTime) {
        this.markSweepTime = markSweepTime;
    }

    public Double getAvgMarkSweepTime() {
        return avgMarkSweepTime;
    }

    public void setAvgMarkSweepTime(Double avgMarkSweepTime) {
        this.avgMarkSweepTime = avgMarkSweepTime;
    }

    public Double getFreePhysicalMemory() {
        return freePhysicalMemory;
    }

    public void setFreePhysicalMemory(Double freePhysicalMemory) {
        this.freePhysicalMemory = freePhysicalMemory;
    }

    public Double getLoadAverage() {
        return loadAverage;
    }

    public void setLoadAverage(Double loadAverage) {
        this.loadAverage = loadAverage;
    }

    public Double getActiveThread() {
        return activeThread;
    }

    public void setActiveThread(Double activeThread) {
        this.activeThread = activeThread;
    }

    public Long getFindTime() {
        return findTime;
    }

    public void setFindTime(Long findTime) {
        this.findTime = findTime;
    }

    public String getScavengeIp() {
        return scavengeIp;
    }

    public void setScavengeIp(String scavengeIp) {
        this.scavengeIp = scavengeIp;
    }

    public String getMarkSweepIp() {
        return markSweepIp;
    }

    public void setMarkSweepIp(String markSweepIp) {
        this.markSweepIp = markSweepIp;
    }

    public String getFreePhysicalMemoryIp() {
        return freePhysicalMemoryIp;
    }

    public void setFreePhysicalMemoryIp(String freePhysicalMemoryIp) {
        this.freePhysicalMemoryIp = freePhysicalMemoryIp;
    }

    public String getLoadAverageIp() {
        return loadAverageIp;
    }

    public void setLoadAverageIp(String loadAverageIp) {
        this.loadAverageIp = loadAverageIp;
    }

    public String getActiveThreadIp() {
        return activeThreadIp;
    }

    public void setActiveThreadIp(String activeThreadIp) {
        this.activeThreadIp = activeThreadIp;
    }
}
