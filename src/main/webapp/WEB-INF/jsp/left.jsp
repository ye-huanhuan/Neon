<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.neon.domain.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="js\calendar/bootstrap_calendar.css" type="text/css" cache="false" />

<!-- highchart所需要的库 -->  
 
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
<script src="https://img.hcharts.cn/highcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
<script src="https://img.hcharts.cn/highcharts/themes/dark-unica.js"></script>
<script src="//cdn.hcharts.cn/libs/highcharts-export-csv/export-csv.js"> </script>  
<!--<script src="http://img.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>-->

<link rel="icon" href="https://static.jianshukeji.com/hcode/images/favicon.ico">
<title>Neon</title>
</head>
<body>
<ul class="nav">
                 
                  <li > <a href="home_index.action"> <i class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i> <span>首页</span> </a> </li>
                  <s:iterator value="#application.topPrivileges" status="s">
                   <s:if test="#session.user.hasPrivilegeByName(LimiteName)" >
	                    	<li id="test<s:property value="#s.index"/>"> <a href=${actionName } > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>${limiteName }</span> </a>
	                    	<ul class="nav lt">
	                    	
	                    	<s:if test="#session.user.isPrivilege(LimiteName)"> 
	                    	<s:iterator value="#application.topPrivilege_2">
	                    	<li > <a href=${actionName } > <i class="fa fa-angle-right"></i> <span>${limiteName }</span> </a> </li>
	                    	</s:iterator>
	                    	
	                    	</s:if>  
        					<s:elseif test="#session.user.isNotPrivilege(LimiteName)"> 
	                    	<s:iterator value="children">
	                    	<li > <a href=${actionName } > <i class="fa fa-angle-right"></i> <span>${limiteName }</span> </a> </li>
	                    	</s:iterator>
	                    	
	                    	</s:elseif>
	                    	
	                    	<s:if test="#session.user.isPrivilege_2(LimiteName)"> 
	                    	<s:iterator value="#application.topPrivilege_3">
	                    	<li > <a href=${actionName } > <i class="fa fa-angle-right"></i> <span>${limiteName }</span> </a> </li>
	                    	</s:iterator>
	                    	
	                    	</s:if>  
	                      		
	                    	</ul>
                    		</li>
                   </s:if>
                  </s:iterator>
       </ul>
       
</body>
</html>