<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="a" uri="/WEB-INF/app.tld" %>
<%@ taglib prefix="w" uri="http://www.unidal.org/web/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="res" uri="http://www.unidal.org/webres" %>
<jsp:useBean id="ctx" type="com.dianping.cat.report.page.topheartbeat.Context" scope="request"/>
<jsp:useBean id="payload" type="com.dianping.cat.report.page.topheartbeat.Payload" scope="request"/>
<jsp:useBean id="model" type="com.dianping.cat.report.page.topheartbeat.Model" scope="request"/>

<c:choose>
    <c:when test="${payload.fullScreen}">
        <res:bean id="res"/>
        <script src='${model.webapp}/assets/js/jquery.min.js'></script>
        <link rel="stylesheet" href="${model.webapp}/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="${model.webapp}/assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="${model.webapp}/assets/css/jquery-ui.min.css">
        <link rel="stylesheet" href="${model.webapp}/assets/css/ace-fonts.css">
        <link rel="stylesheet" href="${model.webapp}/assets/css/ace.min.css" id="main-ace-style">
        <link rel="stylesheet" href="${model.webapp}/assets/css/ace-skins.min.css">
        <link rel="stylesheet" href="${model.webapp}/assets/css/ace-rtl.min.css">
        <script src="${model.webapp}/assets/js/ace-extra.min.js"></script>
        <script src="${model.webapp}/assets/js/bootstrap.min.js"></script>
        <res:useJs value="${res.js.local['highcharts.js']}" target="head-js"/>
        <res:useCss value='${res.css.local.body_css}' target="head-css"/>
        <script src="${model.webapp}/assets/js/jquery-ui.min.js"></script>
        <script src="${model.webapp}/assets/js/jquery.ui.touch-punch.min.js"></script>
        <script src="${model.webapp}/assets/js/ace-elements.min.js"></script>
        <script src="${model.webapp}/assets/js/ace.min.js"></script>
        <div class="report">
            <div id="fullScreenData">
                <style>
                    .ui-tooltip {
                        max-width: 36555px;
                    }

                    .tab-content table {
                        max-width: 100%;
                        background-color: transparent;
                        border-collapse: collapse;
                        border-spacing: 0;
                    }
                </style>
                <div class="row-fluid">
                    <div class="span12">
                        <%@ include file="topMetric.jsp" %>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                var id = '${payload.action.name}';
                var frequency = ${payload.frequency};
                var refresh = ${payload.refresh};

                if (refresh) {
                    $('#refresh${payload.frequency}').addClass('btn-danger');
                    setInterval(function () {
                        location.reload();
                    }, frequency * 1000);
                }
                ;
            });
        </script>
    </c:when>
    <c:otherwise>
        <a:hourly_report title="topheartbeat Report" navUrlPrefix="domain=${model.domain}&op=view">
            <jsp:attribute
                    name="subtitle">${w:format(model.reportStart,'yyyy-MM-dd HH:mm:ss')} to ${w:format(model.reportEnd,'yyyy-MM-dd HH:mm:ss')}</jsp:attribute>
            <jsp:body>
                <div class="report">
                <div class="">
                    <%@ include file="../topheartbeat/topMetric.jsp" %>
                </div>
                <style>
                    .ui-tooltip {
                        max-width: 36555px;
                    }

                    .tab-content table {
                        max-width: 100%;
                        background-color: transparent;
                        border-collapse: collapse;
                        border-spacing: 0;
                    }
                </style>
            </jsp:body>
        </a:hourly_report>
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    $(document).ready(function () {
        $("#warp_search_group").hide();
        <%--$('#minute' +${model.minute}).addClass('disabled');--%>
        $(".hreftip").tooltip({
            show: true,
            delay: {show: 10000, hide: 100000},
            position: {
                my: "left top",
                at: "left bottom"
            },
            content: function () {
                return $(this).attr("title");
            },
            open: function (event, ui) {
                ui.tooltip.animate({top: ui.tooltip.position().top + 10}, "fast");
            }
        });

        $('.position').hide();
        $('.switch').hide();
        $('#my_report').addClass("open active");
        $('#dashbord_hour_heartbeat_report').addClass("active");
        // $('#Dependency_report').removeClass("open active");
    });

</script>

