﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<title>Neon</title>
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="js\calendar/bootstrap_calendar.css" type="text/css" cache="false" />

<link rel="icon" href="https://static.jianshukeji.com/hcode/images/favicon.ico">
<script src="js/app.v2.js"></script>

<style type="text/css">
	#wrap-range,#wrap-product,#wrap-month{
		margin-left: 15px;
		margin-top: 5px;
		
	}
	#range,#second_range{
		width : 350px;
		margin-left: 30px;
		margin-top: 5px;
		display: inline-block;
	}
	#second_button{
		margin-left: 30px;
		border-top-left-radius:0.5em;
     	border-top-right-radius:0.5em;     
     	border-bottom-left-radius:0.5em;
     	border-bottom-right-radius:0.5em;
	}
	#month,#inOut{
		display: inline-block;
		margin-left: 15px;
	}
	#year,#second_year{
		display: inline-block;
	}
	.year,.product,.month,.second_year{
		width: 25px;
		text-align: left;
	}
	
</style>
<!-- 导入jRange -->
<link rel="stylesheet" href="css/jquery.range.css">
<script src="http://www.youhutong.com/static/js/jquery.js"></script>
<script src="js/jquery.range.js"></script>
</head>
<body>

<section class="vbox">
  <%@include file="header.jsp" %>
  <section>
    <section class="hbox stretch">
      <aside class="bg-dark lter aside-md hidden-print" id="nav">
        <section class="vbox">
          <section class="w-f scrollable">
            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333">
              <nav class="nav-primary hidden-xs">
              <%@ include file="left.jsp" %>
              </nav>
            </div>
          </section>
          
        </section>
      </aside>
      <section id="content">
        <section class="vbox">
          <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
              <li><a href="home_index.action"><i class="fa fa-home"></i> Home</a></li>
              <li class="active">分析</li>
            </ul>
            <div class="row">
            	<!-- 按月进销总和统计 -->
              <div class="col-md-8" style="width: 100%">
                <section class="panel panel-default">
                  <header class="panel-heading font-bold" style="font-size: 20px;text-align:center">税收总额分析图</header>
                  <!-- 滑动条 -->
				  <div id="wrap-range">
				  <font>进销项差值合理的范围:<font id="demo"></font></font>
				  <div id="range">
				  <input id="rangeValue" type="hidden" class="range-slider"  value=""/>
				  </div>
				  
				  <div id="year">
				  <font>年份:</font>
				  <!-- <input id="year-2015" class="year" type="radio" name="year" value="2015">2015
				  <input id="year-2016" class="year" type="radio" name="year" value="2016">2016
				  <input id="year-2017" class="year" type="radio" name="year" value="2017">2017 -->
				  <input id="year-12month" class="year" type="radio" name="year" value="">近十二个月
				  </div>
				  </div>
                  <div class="panel-body">
                    <div id="container_top" style="width:100%;height:400px"></div>
                  </div>
                 
                  <footer class="panel-footer bg-white no-padder">
                    <div class="row text-center no-gutter">
                      <div class="col-xs-3 b-r b-light"> <span id="aver_input" class="h4 font-bold m-t block">5,860</span><small class="text-muted m-b block">进项数据平均值</small></div>
                      <div class="col-xs-3 b-r b-light"> <span id="aver_output" class="h4 font-bold m-t block">10,450</span><small class="text-muted m-b block">销项数据平均值</small> </div>
                      <div class="col-xs-3 b-r b-light"> <span id="variance_input" class="h4 font-bold m-t block">21,230</span> <small class="text-muted m-b block">进项数据方差</small> </div>
                      <div class="col-xs-3"> <span id="variance_output" class="h4 font-bold m-t block">7,230</span> <small class="text-muted m-b block">销项数据方差</small></div>
                    </div>
                  </footer>
                </section>
              </div>
              <!-- 按月同一产品统计 -->
              <div class="col-md-8" style="width: 100%">
                <section class="panel panel-default">
                  <header class="panel-heading font-bold" style="font-size: 20px;text-align:center">产品税额分析图</header>
                  <div id="wrap-product">
                  <!-- range2 -->
                  <font>查看的范围:</font>
				  <div id="second_range">
				  <input id="second_rangeValue" type="hidden" class="range-slider"  value="0,50"/>
				  </div>
				  <div id="second_year">
				  <font>年份:</font>
				  <!-- <input id="second_year2015" class="second_year" type="radio" name="second_year" value="2015"><font class="yearFont">2015</font>
				  <input id="second_year2016" class="second_year" type="radio" name="second_year" value="2016"><font class="yearFont">2016</font>
				  <input id="second_year2017" class="second_year" type="radio" name="second_year" value="2017"><font class="yearFont">2017</font> -->
				  <span><input id="second_year4month" class="second_year" type="radio" name="second_year" value=""><font class="yearFont">近十二个月</font></span>
				  <input id="second_button" class="sevond_year" type="button" value="重置">
				  </div>
				  
				  </div>
                  <div class="panel-body">
                    <div id="container_second" style="min-width:400px;height:400px"></div>
                  </div>
                   
                </section>
              </div>
              <!-- 同比图 -->
              <div class="col-md-8" style="width: 100%">
                <section class="panel panel-default">
                  <header class="panel-heading font-bold" style="font-size: 20px;text-align:center">产品税额同比图</header>
                  <div id="wrap_inOut">
				  <div id="inOut">
				  <font>进销:</font>
				  <input id="in" class="month" type="radio" name="inOut" value="in">进项
				  <input id="out" class="month" type="radio" name="inOut" value="out">销项
				  </div>
				  </div>
                  <div class="panel-body">
                    <div id="container_fourth" style="min-width:400px;height:400px"></div>
                  </div>
                </section>
              </div>
              <!-- 同一时间产品销项 -->
              <div class="col-md-8" style="width: 100%">
                <section class="panel panel-default">
                  <header class="panel-heading font-bold" style="font-size: 20px;text-align:center">产品税额联动图</header>
				  <div id="wrap_month">
				  <div id="month">
				  <font>月份:</font>
				  <!-- <input id="month12" class="month" type="radio" name="month" value="12">十二月
				  <input id="month1" class="month" type="radio" name="month" value="1">一月
				  <input id="month2" class="month" type="radio" name="month" value="2">二月
				  <input id="month3" class="month" type="radio" name="month" value="3">三月
				  <input id="month4" class="month" type="radio" name="month" value="4">四月
				  <input id="month5" class="month" type="radio" name="month" value="5">五月 -->
				  <span></span>
				  </div>
				  </div>
                  <div class="panel-body">
                    <div id="container_third" style="width:49%;height:400px;display: inline-block;"></div>
                    <div id="container_third_2" style="width:49%;height:400px;display: inline-block;"></div>
                  </div>
                </section>
              </div>
              
            </div>
          </section>
        </section>
        <a href="" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a> </section>
      <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
      </aside>
    </section>
  </section>
</section>
 <script>
		document.getElementById("test0").setAttribute("class","active");
</script>

<script src="js/dynamic_month.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/sumInOutMonth.js"></script>
<script src="js/productOutMonth.js"></script>
<script src="js/monthOutProduct.js"></script>
<script src="js/top_product_month.js"></script>
<script src="js/compare_same_month.js"></script>





<!--  
<script type="text/javascript">
/**
 *  每个产品的月销售量
 */
 var chart1;
 var productName;
 var productValue;
 var options;
 $(function () {
   options = {
     chart: {
       renderTo: 'container_second',
       type: 'line',
       marginRight: 130,
       marginBottom: 25
     },
     title: {
       text: '产品分析表',
       x: -20 //center
     },
     subtitle: {
         text: '数据来源: 财务部',
         x: -20
     },
     xAxis: {
       categories: ['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月'],
       title: {
           text: '月份/月',
           align: 'high',
       },
     },
     yAxis: {
       title: {
         text: '金额/万元',
       	 align: 'high',
       },
       plotLines: [{
         value: 0,
         width: 1,
         color: '#808080'
       }]
     },
     tooltip: {
       valueSuffix: '万元',
     },
     legend: {
       layout: 'vertical',
       align: 'right',
       verticalAlign: 'top',
       x: -10,
       y: 100,
       borderWidth: 0
     },
     series: []
   }
   options.series = new Array();
   
   	//初始化chart1
   	$("#second_year2017").attr("checked","checked");
   $.ajax({
  	    async: true,
  	  	data: {y2:$("#second_year2017").val()},
  	    type: "post",        //type：(string)请求方式，POST或GET
  	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
  	    url: "analyze_month_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
  	    success: function (msg) {
  	    	var obj = eval(msg);
  	    	productName = obj["productName"];
  	    	productValue = obj["productVlaue"];
  	    	for(var i=0;i<productName.length;i++){
	        options.series[i] = new Object();
	        options.series[i].name = productName[i];
	        options.series[i].data = productValue[i];
  	    	}
	        chart1 = new Highcharts.Chart(options);
  	    }
   });
   
});
 //异步请求2017年数据
 $(function () {
	    $("#second_year2017").click(function () {
	    	alert("hello");
	    	$.ajax({
	      	    async: true,
	      	  	data: {y2:$("#second_year2017").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_month_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	      	    	for(var i=0;i<productName.length;i++){
	    	        options.series[i] = new Object();
	    	        options.series[i].name = productName[i];
	    	        options.series[i].data = productValue[i];
	      	    	}
	    	        chart1 = new Highcharts.Chart(options);
	      	    }
	       });
	    });
	});
//异步请求2016年数据
 $(function () {
	    $("#second_year2016").click(function () {
	    	alert("hello");
	    	$.ajax({
	      	    async: true,
	      	  	data: {y2:$("#second_year2016").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_month_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	      	    	for(var i=0;i<productName.length;i++){
	    	        options.series[i] = new Object();
	    	        options.series[i].name = productName[i];
	    	        options.series[i].data = productValue[i];
	      	    	}
	    	        chart1 = new Highcharts.Chart(options);
	      	    }
	       });
	    });
	});
//异步请求2015年数据
 $(function () {
	    $("#second_year2015").click(function () {
	    	alert("hello");
	    	$.ajax({
	      	    async: true,
	      	  	data: {y2:$("#second_year2015").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_month_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	      	    	for(var i=0;i<productName.length;i++){
	    	        options.series[i] = new Object();
	    	        options.series[i].name = productName[i];
	    	        options.series[i].data = productValue[i];
	      	    	}
	    	        chart1 = new Highcharts.Chart(options);
	      	    }
	       });
	    });
	});
</script>
-->
<!-- 
<script>

/**
 * 月份进销项总和对比
 */
	//运用构造函数式

var data_difference;
var data_input;
var data_output;
var chart;
function calculate(){
	var num_effe_input = 0,num_effe_output = 0;
    var sum_effe_input = 0,sum_effe_output = 0;
    var aver_input = 0,aver_output = 0;
    var variance_input = 0;variance_output = 0;
    for(d in data_input){
    	if(data_input[d] > 0){
    		num_effe_input ++;
    		sum_effe_input += data_input[d];
    	}
    }
    if(num_effe_input != 0){
    	aver_input = (sum_effe_input/num_effe_input).toFixed(2);
    }
    
    for(d in data_output){
    	if(data_output[d] > 0){
    		num_effe_output ++;
    		sum_effe_output += data_output[d];
    	}
    }
    if(num_effe_output != 0){
    	aver_output = (sum_effe_output/num_effe_output).toFixed(2);
    }
    for(d in data_input){
    	if(data_input[d] > 0){
    		variance_input += Math.pow((data_input[d]-aver_input),2);
    	}
    }
    for(d in data_output){
    	if(data_output[d] > 0){
    		variance_output += (Math.pow((data_output[d]-aver_output),2));
    	}
    }
    variance_output = variance_output.toFixed(2);
    $("#aver_input").text(aver_input);
    $("#aver_output").text(aver_output);
    $("#variance_input").text(variance_input);
    $("#variance_output").text(variance_output);
}

var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7','#058DC7','#058DC7','#058DC7'];
$(function () {
     chart = new Highcharts.Chart('container_top', {
    	 credits: {
             enabled:false
		},	 
        title: {
            text: '月份分析表',
            x: -20
        },
        subtitle: {
            text: '数据来源: 财务部',
            x: -20
        },
        xAxis: {
            categories: ['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月'],
            title: {
                text: '月份/月',
                align: 'high',
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        yAxis: {
            title: {
                text: '金额/万元',
                align: 'high',
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        tooltip: {
        	//数据后缀
            valueSuffix: '万'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        
        series: [
			{
				colorByPoint: true,	
   		 		type: 'column',
    			name: '进销差值',
    			colors: columnColor,
				},
             {
			type: 'spline',
            name: '进项金额',
             
        }, {
        	type: 'spline',
        	name: '销项金额',
             
        }
        ]
   });
   //初始化highchart
     $("#year-2017").attr("checked","checked");
     $.ajax({
    	    async: true,
    	    data: {y:$("#year-2017").val()},
    	    type: "post",        //type：(string)请求方式，POST或GET
    	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    	    url: "analyze_month_1.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    	    success: function (msg) {
    	    	alert("month_1");
    	        var obj = eval(msg);
    	        data_difference = obj["data_difference"];
    	        data_input = obj["data_input"];
    	        data_output = obj["data_output"];
    	        calculate();
    	        var rangeValue = obj["dvalue_double"];
    	        var initValue = ""+rangeValue[0]+","+rangeValue[1];
    	        $('#rangeValue').jRange('setValue', initValue);
    	        change();
    	        chart.series[0].setData(data_difference);
    	        chart.series[1].setData(data_input);
    	        chart.series[2].setData(data_output);
    	    }
    	});
});
//发送异步请求2016年数据
$(function () {
    $("#year-2016").click(function () {
    	alert("hello");
        $.ajax({
            async: true,
            data: {y:$("#year-2016").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_1.action",
            success: function (msg) {
            	
            	alert(msg);
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
                calculate();
                chart.series[0].setData(data_difference);
                chart.series[1].setData(data_input);
                chart.series[2].setData(data_output);
            }
        });
    });
});
//发送异步请求2017年数据
$(function () {
    $("#year-2017").click(function () {
    	
        $.ajax({
            async: true,
            data: {y:$("#year-2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_1.action",
            success: function (msg) {
            	
            	alert(msg);
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
                calculate();
                chart.series[0].setData(data_difference);
                chart.series[1].setData(data_input);
                chart.series[2].setData(data_output);
            }
        });
    });
});
//发送异步请求2015年数据
$(function () {
    $("#year-2015").click(function () {
    	
        $.ajax({
            async: true,
            data: {y:$("#year-2015").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_1.action",
            success: function (msg) {
            	
            	alert(msg);
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
                calculate();
                chart.series[0].setData(data_difference);
                chart.series[1].setData(data_input);
                chart.series[2].setData(data_output);
            }
        });
    });
});

//改变超出范围的颜色
function change(){
	var aa = $(".range-slider").val();
	var subaa = aa.split(",");
	var min = subaa[0];
	var max = subaa[1];
	for(var i=0;i<data_difference.length;i++){
		if(data_difference[i]>max || data_difference[i]<min){
			columnColor[i] = '#FF0000';
		}else{
			columnColor[i] = '#058DC7';
		}
	}
	chart.series[0].update({
		colors: columnColor,
	
});
}

//使用jrange
$('.range-slider').jRange({
    from: -20,
    to: 60,
    step: 2,
    scale: [-20,0,20,40,60],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change,
});




</script>

<!-- 
<script> 
/**
 *  同一个月不同产品的销量
 */
 var chart2;
$(function () {
chart2 = new Highcharts.Chart('container_third',{
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '五月销项产品',
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '产品销量',
            data: [
                ['猪肉罐头',   39.2],
                ['鸡肉罐头',   11.8],
                {
                    name: '鱼肉罐头',
                    y: 48.5,
                    sliced: true,
                    selected: true
                },
               
                ['其他',   0.5]
            ]
        }]
    });
$("#month5").attr("checked","checked");
$.ajax({
    async: true,
    data: {m:$("#month5").val()},
    type: "post",        //type：(string)请求方式，POST或GET
    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    success: function (msg) {
        var obj = eval(msg);
        var a = obj["data_output_month_3"];
       for(var i=0;i<a.length;i++)
       {
           for(var j=0;j<a[i].length;j++)
           {
               if(j==1){
            	   a[i][j] = Number(a[i][j]);
               }
               
               }
           }
        chart2.series[0].setData(a);
        chart2.title.update({
     		text: '五月产品销售情况',
     });
    }
});
});
//发送异步请求四月数据
$(function () {
    $("#month4").click(function () {
        $.ajax({
            async: true,
            data: {m:$("#month4").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_3.action",
            success: function (msg) {
                var obj = eval(msg);
                var a = obj["data_output_month_3"];
                for(var i=0;i<a.length;i++)
                {
                    for(var j=0;j<a[i].length;j++)
                    {
                        //alert("第"+i+"行 第"+j+"列 的值为:"+a[i][j]);
                        if(j==1){
                     	   a[i][j] = Number(a[i][j]);
                        }
                        }
                    }
                 chart2.series[0].setData(a);
                 chart2.title.update({
              		text: '四月产品销售情况',
              });
            }
        });
    });
});
//发送异步请求三月数据
$(function () {
    $("#month3").click(function () {
        $.ajax({
            async: true,
            data: {m:$("#month3").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_3.action",
            success: function (msg) {
                var obj = eval(msg);
                var a = obj["data_output_month_3"];
                for(var i=0;i<a.length;i++)
                {
                    for(var j=0;j<a[i].length;j++)
                    {
                        //alert("第"+i+"行 第"+j+"列 的值为:"+a[i][j]);
                        if(j==1){
                     	   a[i][j] = Number(a[i][j]);
                        }
                        }
                    }
                 chart2.series[0].setData(a);
                 chart2.title.update({
             		text: '三月产品销售情况',
             	
             });
            }
        });
    });
});
 </script>
 -->
</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  