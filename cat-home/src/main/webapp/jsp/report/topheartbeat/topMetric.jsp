<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .tooltip-inner {
        max-width: 36555px;
    }

    .smallTable {
        font-size: small;
    }
</style>
<script type="text/javascript">
    $('.hreftip').tooltip({container: 'body', html: true, delay: {show: 0, hide: 0}});
</script>

<%--<c:if test="${not empty model.message}">--%>
<%--<h3 class="text-center text-danger">出问题CAT的服务端222333:${model.message}</h3>--%>
<%--</c:if>--%>
<%--<c:if test="${ empty model.message}">--%>
<%--<h3 class="text-center text-success">CAT服务端正常</h3>--%>
<%--</c:if>--%>
<h3 class="text-center text-danger">小时心跳汇总大盘</h3>
<%--<c:set var="date" value="${w:format(model.topReport.startTime,'yyyyMMddHH')}"/>--%>
<%--<c:forEach var="item" items="${model.topMetric.error.result}" varStatus="itemStatus">--%>
<%--<table class="smallTable" style="float:left" border=1>--%>
<%--<tr>--%>
<%--<th colspan="2" class="text-danger" class="text-danger">${item.key}</th>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th>系统</th>--%>
<%--<th>错误数</th>--%>
<%--</tr>--%>
<%--<c:forEach var="detail" items="${item.value}" varStatus="status">--%>
<%--<tr class="">--%>
<%--<c:choose>--%>
<%--<c:when test="${detail.alert == 2}">--%>
<%--<td style="background-color:red;color:white;"><a class="hreftip" style="color:white;"--%>
<%--href="/cat/r/p?domain=${detail.domain}&date=${date}"--%>
<%--title="${detail.errorInfo}">${w:shorten(detail.domain, 18)}</a>--%>
<%--</td>--%>
<%--<td style="background-color:red;color:white;text-align:right">${w:format(detail.value,'0')}</td>--%>
<%--</c:when>--%>
<%--<c:when test="${detail.alert == 1}">--%>
<%--<td style="background-color:#bfa22f;color:white;"><a class="hreftip" style="color:white;"--%>
<%--href="/cat/r/p?domain=${detail.domain}&date=${date}"--%>
<%--title="${detail.errorInfo}">${w:shorten(detail.domain, 18)}</a>--%>
<%--</td>--%>
<%--<td style="background-color:#bfa22f;color:white;text-align:right">${w:format(detail.value,'0')}</td>--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<td><a class="hreftip" href="/cat/r/p?domain=${detail.domain}&date=${date}"--%>
<%--title="${detail.errorInfo}">${w:shorten(detail.domain, 18)}</a></td>--%>
<%--<td style="text-align:right">${w:format(detail.value,'0')}</td>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</c:forEach>--%>

<%--<c:forEach var="item" items="${model.topMetric.error.result}" varStatus="itemStatus">--%>
<%--<table class="smallTable" style="float:left" border=1>--%>
<%--<tr>--%>
<%--<th colspan="2" class="text-danger" class="text-danger">${item.key}</th>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th>系统</th>--%>
<%--<th>错误数</th>--%>
<%--</tr>--%>
<%--<c:forEach var="detail" items="${item.value}" varStatus="status">--%>
<%--<tr class="">--%>
<%--<c:choose>--%>
<%--<c:when test="${detail.alert == 2}">--%>
<%--<td style="background-color:red;color:white;"><a class="hreftip" style="color:white;"--%>
<%--href="/cat/r/p?domain=${detail.domain}&date=${date}"--%>
<%--title="${detail.errorInfo}">${w:shorten(detail.domain, 18)}</a>--%>
<%--</td>--%>
<%--<td style="background-color:red;color:white;text-align:right">${w:format(detail.value,'0')}</td>--%>
<%--</c:when>--%>
<%--<c:when test="${detail.alert == 1}">--%>
<%--<td style="background-color:#bfa22f;color:white;"><a class="hreftip" style="color:white;"--%>
<%--href="/cat/r/p?domain=${detail.domain}&date=${date}"--%>
<%--title="${detail.errorInfo}">${w:shorten(detail.domain, 18)}</a>--%>
<%--</td>--%>
<%--<td style="background-color:#bfa22f;color:white;text-align:right">${w:format(detail.value,'0')}</td>--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<td><a class="hreftip" href="/cat/r/p?domain=${detail.domain}&date=${date}"--%>
<%--title="${detail.errorInfo}">${w:shorten(detail.domain, 18)}</a></td>--%>
<%--<td style="text-align:right">${w:format(detail.value,'0')}</td>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</c:forEach>--%>
<table class='table table-striped table-condensed table-hover ' style="width:100%;">
    <tr><th class="left"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=type">项目名</a></th>
        <th  class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=scavengeCount">新生代最大次数</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=scavengeTime">新生代GC时间(ms)</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=avgScavengeTime">新生代平均GC时长(ms)</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=markSweepCount">老年代最大GC次数 </a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=markSweepTime">老年代GC时间(ms)</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=avgMarkSweepTime">老年代平均GC时间(ms)</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=loadAverage">系统负载最高值</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=freePhysicalMemory">内存可用最小值(MB)</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=activeThread">最大存活线程数</a></th>
        <th class="right"><a href="?date=${model.date}&ip=${model.ipAddress}&sort=findTime">本次查询耗时时长</a></th>
    </tr>
    <c:forEach var="item" items="${model.heartbeatModelList}">
        <tr class="center">
            <td class="left"><a href="/cat/r/h?domain=${item.domain}&date=${model.date}&reportType=day"> ${item.domain}</a></td>
            <td><div title="挑选的IP : ${item.scavengeIp}">${w:format(item.scavengeCount,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.scavengeIp}">${w:format(item.scavengeTime,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.scavengeIp}"> ${w:format(item.avgScavengeTime,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.markSweepIp}">${w:format(item.markSweepCount,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.markSweepIp}">${w:format(item.markSweepTime,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.markSweepIp}">${w:format(item.avgMarkSweepTime,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.loadAverageIp}">${w:format(item.loadAverage,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.freePhysicalMemoryIp}">${w:format(item.freePhysicalMemory,'#,###,###,###,##0')}</div></td>
            <td><div title="挑选的IP : ${item.activeThreadIp}">${w:format(item.activeThread,'#,###,###,###,##0')}</div></td>
            <td>${w:format(item.findTime,'#,###,###,###,##0')}</td>
            <%--<td><a href="/cat/r/m/${empty e.failMessageUrl ? e.successMessageUrl : e.failMessageUrl}?domain=${model.domain}">Log View</a></td>--%>
            <%--<td>${w:format(item.min,'###,##0.#')}</td>--%>
            <%--<td><a href="/cat/r/m/${e.longestMessageUrl}">${w:format(e.max,'###,##0.#')}</a></td>--%>
            <%--<td>${w:format(item.avg,'###,##0.0')}</td>--%>
            <%--<td>${w:format(item.line95Value,'###,##0.0')}</td>--%>
            <%--<td>${w:format(item.line99Value,'###,##0.0')}</td>--%>
            <%--<td>${w:format(item.std,'###,##0.0')}</td>--%>
            <%--<td>${w:format(item.tps,'###,##0.0')}</td>--%>
        </tr>
    </c:forEach>
</table>