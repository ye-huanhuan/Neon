<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="js\calendar/bootstrap_calendar.css" type="text/css" cache="false" />

  <link rel="icon" href="https://static.jianshukeji.com/hcode/images/favicon.ico">
  <script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
  <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
  <script src="https://img.hcharts.cn/highcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
  <script src="https://img.hcharts.cn/highcharts/themes/dark-unica.js"></script>
<title>Insert title here</title>
</head>
<body>
<ul class="nav">
                  <%-- 
                  <li > <a href="layout-c.html" > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>分析</span> </a>
                    <ul class="nav lt">
                      <li > <a href="analyze_analyze.action" > <i class="fa fa-angle-right"></i> <span>分析</span> </a> </li>
                      <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>Right nav</span> </a> </li>
                      <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>H-Layout</span> </a> </li>
                    </ul>
                  </li>
                  <li > <a href="#" > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>发票</span> </a>
                    <ul class="nav lt">
                      <li > <a href="invoice_invoice.action" > <i class="fa fa-angle-right"></i> <span>录入</span> </a> </li>
                      <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>Right nav</span> </a> </li>
                      <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>H-Layout</span> </a> </li>
                    </ul>
                  </li> --%>
                  <li><!-- class="active" --> <a href="home_index.action" class="active"> <i class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i> <span>首页</span> </a> </li>
                  <s:iterator value="#session.tops">
                  	<li > <a href=${actionName } > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>${limiteName }</span> </a>
	                    <ul class="nav lt">
	                    	<s:iterator value="children">
	                      		<li > <a href=${actionName } > <i class="fa fa-angle-right"></i> <span>${limiteName }</span> </a> </li>
	                    	</s:iterator>
	                    </ul>
                    </li>
                  </s:iterator>
       </ul>
</body>
</html>