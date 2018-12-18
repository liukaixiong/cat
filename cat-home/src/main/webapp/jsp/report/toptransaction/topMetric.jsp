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

    function selectByName(date, domain, ip, type) {
        var queryname = $("#queryname").val();
        window.location.href = "?domain=" + domain + "&type=" + type + "&date="
            + date + "&queryname=" + queryname + "&ip=" + ip;
    }
</script>

<%--<c:if test="${not empty model.message}">--%>
<%--<h3 class="text-center text-danger">出问题CAT的服务端222333:${model.message}</h3>--%>
<%--</c:if>--%>
<%--<c:if test="${ empty model.message}">--%>
<%--<h3 class="text-center text-success">CAT服务端正常</h3>--%>
<%--</c:if>--%>
<h3 class="text-center text-danger">小时事务汇总大盘 : 将指定小时指定类型的数据汇总之后按照项目划分。</h3>

<table class='table table-striped table-condensed table-hover ' style="width:100%;">
    <form action="" method="get">
        <input type="hidden" name="date" value="${model.date}"/>
        <input type="hidden" name="sort" value="${model.sort}"/>
        <input type="hidden" name="op" value="${model.action.name}">
        <tr>
            <th class="left" colspan="2">消息类型 : <input type="text" name="type" id="type" size="40"
                                                       value="${model.type}">
            </th>
            <th class="left" colspan="2">
                项目 : <input type="text" name="queryname" id="queryname" size="40"
                            value="${model.queryName}">
                <input class="btn btn-primary  btn-sm" value="Filter"
                <%--onclick="selectByName('${model.date}','${model.domain}','${model.ipAddress}','${payload.type}')"--%>
                       type="submit">
                支持前缀匹配
            </th>
        </tr>
    </form>
    <tr>
        <th class="left"><a href="?type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=type">项目名</a>
        </th>
        <th class="center">Type</th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=totalCount">请求总数</a></th>
        <th class="center"><a href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=failCount">失败个数</a>
        </th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=failPercent">失败率 </a>
        </th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=min">最小值</a></th>
        <th class="center"><a href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=max">请求响应时间最大值</a>
        </th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=avg">平均响应时间</a></th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=line95Value">95Line</a>
        </th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=line99Value">99.9Line</a>
        </th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=std">Std</a></th>
        <th class="center"><a
                href="?op=${model.action.name}&type=${model.type}&queryname=${model.queryName}&date=${model.date}&sort=tps">QPS</a></th>

    </tr>
    <c:forEach var="item" items="${model.transactionInfo}">
        <tr class="center">
            <td class="left"><a
                    href="/cat/r/t?domain=${item.domain}&date=${model.date}&reportType=day"> ${item.domain}</a></td>
            <td>${w:format(item.transactionType.id,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.totalCount,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.failCount,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.failPercent,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.min,'#,###,###,###,##0')}</td>
            <td>
                <a href="/cat/r/m/${item.transactionType.longestMessageUrl}">${w:format(item.transactionType.max,'#,###,###,###,##0')}</a>
            </td>
            <td>${w:format(item.transactionType.avg,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.line95Value,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.line99Value,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.std,'#,###,###,###,##0')}</td>
            <td>${w:format(item.transactionType.tps,'#,###,###,###,##0')}</td>

        </tr>
    </c:forEach>
</table>