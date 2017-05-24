<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	#wrap-range{
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
	#quarter{
		display: inline-block;
		margin-left: 15px;
	}
	
	.quarter{
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
<script type="text/javascript">
	
</script>

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
                  <header class="panel-heading font-bold" style="font-size: 16px">进销总和分析表</header>
                  <!-- 滑动条 -->
				  <div id="wrap-range">
				  <font>进销项差值合理的范围:<font id="demo"></font></font>
				  <div id="range">
				  <input id="rangeValue" type="hidden" class="range-slider"  value=""/>
				  </div>
				  
				  <div id="quarter">
				  <font>年度:</font>
				  <input id="year2015" class="quarter" type="radio" name="first_quarter" value="2015">2015
				  <input id="year2016" class="quarter" type="radio" name="first_quarter" value="2016">2016
				  <input id="year2017" class="quarter" type="radio" name="first_quarter" value="2017">2017
				  <input id="year4quarter" class="quarter" type="radio" name="first_quarter" value="">近四个季度
				  </div>
				  </div>
                  <div class="panel-body">
                    <div id="container_top" style="min-width:400px;height:400px"></div>
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
                  <header class="panel-heading font-bold" style="font-size: 16px">销项产品分析表</header>
                  <div id="wrap-product">
				  <div id="quarter">
				  <!-- range2 -->
                  <font>查看的范围:</font>
				  <div id="second_range">
				  <input id="second_rangeValue" type="hidden" class="range-slider"  value="0,120"/>
				  </div>
				 <font>年份:</font>
				  <input id="second_year_2015" class="quarter" type="radio" name="second_quarter" value="2015">2015
				  <input id="second_year_2016" class="quarter" type="radio" name="second_quarter" value="2016">2016
				  <input id="second_year_2017" class="quarter" type="radio" name="second_quarter" value="2017">2017
				  <input id="second_year_4quarter" class="quarter" type="radio" name="second_quarter" value="">近四个季度
				  <input id="second_button" class="" type="button" value="重置">
				  </div>
				  </div>
                  <div class="panel-body">
                    <div id="container_second" style="min-width:400px;height:400px"></div>
                  </div>
                  <footer class="panel-footer bg-white no-padder">
                   <div class="row text-center no-gutter">
                      <div style="height: 40px;line-height: 40px;font-size: 18px;text-align:center;">
                        	这是产品分析表
                      </div>
                    </div>
                  </footer>
                   
                </section>
              </div>
              <!-- 同一时间产品销项 -->
              <div class="col-md-8" style="width: 100%">
                <section class="panel panel-default">
                  <header class="panel-heading font-bold" style="font-size: 16px">销项产品分析表</header>
                  
				  <div id="wrap_month">
				  
				  <div id="quarter">
				  
				 <font>季度:</font>
				  <input id="third_quarter_1" class="quarter" type="radio" name="third_quarter" value="1">第一季度
				  <input id="third_quarter_2" class="quarter" type="radio" name="third_quarter" value="2">第二季度
				  <input id="third_quarter_3" class="quarter" type="radio" name="third_quarter" value="3">第三季度
				  <input id="third_quarter_4" class="quarter" type="radio" name="third_quarter" value="4">第四季度
				  </div>
				  </div>
                  <div class="panel-body">
                    <div id=container_third style="min-width:400px;height:400px"></div>
                  </div>
                  <footer class="panel-footer bg-white no-padder">
                    <div class="row text-center no-gutter">
                      <div style="height: 40px;line-height: 40px;font-size: 18px;text-align:center;">
                        	这是本月的产品销量图
                      </div>
                    </div>
                  </footer>
                </section>
              </div>
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
 
      

<script src="js/highcharts.js"></script>
<script src="js/sumInOutQuarter.js"></script>
<script src="js/productOutQuarter.js"></script>
<script src="js/quarterOutProduct.js"></script>
<!--  
<script>
/**
 * 季度进销项总和对比
 */
	//运用构造函数式

var data_difference_quarter;
var data_input_quatter;
var data_output_quarter;
var chart;
var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7'];
function calculate(){
	var num_effe_input = 0,num_effe_output = 0;
    var sum_effe_input = 0,sum_effe_output = 0;
    var aver_input = 0,aver_output = 0;
    var variance_input = 0;variance_output = 0;
    for(d in data_input_quarter){
    	if(data_input_quarter[d] > 0){
    		num_effe_input ++;
    		sum_effe_input += data_input_quarter[d];
    	}
    }
    if(num_effe_input != 0){
    	aver_input = (sum_effe_input/num_effe_input).toFixed(2);
    }
    
    for(d in data_output_quarter){
    	if(data_output_quarter[d] > 0){
    		num_effe_output ++;
    		sum_effe_output += data_output_quarter[d];
    	}
    }
    if(num_effe_output != 0){
    	aver_output = (sum_effe_output/num_effe_output).toFixed(2);
    }
    for(d in data_input_quarter){
    	if(data_input_quarter[d] > 0){
    		variance_input += Math.pow((data_input_quarter[d]-aver_input),2);
    	}
    }
    for(d in data_output_quarter){
    	if(data_output_quarter[d] > 0){
    		variance_output += (Math.pow((data_output_quarter[d]-aver_output),2));
    	}
    }
    variance_output = variance_output.toFixed(2);
    $("#aver_input").text(aver_input);
    $("#aver_output").text(aver_output);
    $("#variance_input").text(variance_input);
    $("#variance_output").text(variance_output);
}
$(function () {
     chart = new Highcharts.Chart('container_top', {
    	 credits: {
             enabled:false
		},
        title: {
            text: '季度分析表',
            x: -20
        },

        subtitle: {

            text: '数据来源: 财务部',

            x: -20
        },
        xAxis: {
            categories: ['第一季度', '第二季度', '第三季度', '第四季度'],
            title: {
                text: '季度/季度',
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
    			data: [-3, 1, 2, -4],
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
     $("#year2017").attr("checked","checked");
     $.ajax({
    	    async: true,
    	    data: {y_quarter_1:$("#year2017").val()},
    	    type: "post",        //type：(string)请求方式，POST或GET
    	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    	    url: "analyze_quarter_1.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    	    success: function (msg) {
    	    	
    	        var obj = eval(msg);
    	        data_difference_quarter = obj["data_difference_quarter"];
    	        data_input_quarter = obj["data_input_quarter"];
    	        data_output_quarter = obj["data_output_quarter"];
    	        calculate();
    	        var rangeValue = obj["dvalue_double"];
    	        var initValue = ""+rangeValue[0]+","+rangeValue[1];
    	        $('#rangeValue').jRange('setValue', initValue);
    	        change();
    	        chart.series[0].setData(data_difference_quarter);
    	        chart.series[1].setData(data_input_quarter);
    	        chart.series[2].setData(data_output_quarter);
    	    }
    	});
});
//发送异步请2017年数据
$(function () {
    $("#year2017").click(function () {
    	alert("hello");
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        calculate();
     	        alert(data_difference_quarter);
     	        chart.series[0].setData(data_difference_quarter);
     	        chart.series[1].setData(data_input_quarter);
     	        chart.series[2].setData(data_output_quarter);
            }
        });
    });
});
//发送异步请求2016年数据
$(function () {
    $("#year2016").click(function () {
    	
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2016").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        calculate();
     	        chart.series[0].setData(data_difference_quarter);
     	        chart.series[1].setData(data_input_quarter);
     	        chart.series[2].setData(data_output_quarter);
            }
        });
    });
});
//发送异步请求2015数据
$(function () {
    $("#year2015").click(function () {
    	
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2015").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        calculate();
     	        chart.series[0].setData(data_difference_quarter);
     	        chart.series[1].setData(data_input_quarter);
     	        chart.series[2].setData(data_output_quarter);
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
	for(var i=0;i<data_difference_quarter.length;i++){
		if(data_difference_quarter[i]>max || data_difference_quarter[i]<min){
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
    to: 120,
    step: 5,
    scale: [-20,0,20,40,60,80,100,120],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change,
});




</script>
-->
<!--  
<script>
/**
 * 同一个季度不同商品的出售情况
 */
 var chart2;
 $(function () {
	 chart2= new Highcharts.Chart('container_third',{
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        //去除右下角水印
        credits: {
			enabled:false
		},
        title: {
            text: '第一季度产品销售情况',
            x: -20,
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        subtitle: {
            text: '数据来源: 财务部',
            x: -20,
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
                ['猪肉罐头',   50.2],
                ['鸡肉罐头',   10.8],
                {
                    name: '鱼肉罐头',
                    y: 38.5,
                    sliced: true,
                    selected: true
                },
               
                ['其他',   0.5]
            ]
        }]
    });
$("#third_quarter_1").attr("checked","checked");
$.ajax({
    async: true,
    data: {quarter_quarter_3:$("#third_quarter_1").val()},
    type: "post",        //type：(string)请求方式，POST或GET
    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    success: function (msg) {
        var obj = eval(msg);
        var a = obj["data_out_quarter_3"];
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
     		text: '第一季度产品销售情况',
     });
    }
});
 });    
//发送异步请求第一季度数据
 $(function () {
     $("#third_quarter_1").click(function () {
     	alert("m4");
         $.ajax({
             async: true,
             data: {quarter_quarter_3:$("#third_quarter_1").val()},
             type: "post",        //type：(string)请求方式，POST或GET
             dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第一季度产品销售情况',
               });
             }
         });
     });
 });
//发送异步请求第二季度数据
 $(function () {
     $("#third_quarter_2").click(function () {
     	alert("m4");
         $.ajax({
             async: true,
             data: {quarter_quarter_3:$("#third_quarter_2").val()},
             type: "post",        //type：(string)请求方式，POST或GET
             dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第二季度产品销售情况',
               });
             }
         });
     });
 });
//发送异步请求第三季度数据
 $(function () {
     $("#third_quarter_3").click(function () {
     	alert("m4");
         $.ajax({
             async: true,
             data: {quarter_quarter_3:$("#third_quarter_3").val()},
             type: "post",        //type：(string)请求方式，POST或GET
             dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第三季度产品销售情况',
               });
             }
         });
     });
 });
//发送异步请求第四季度数据
 $(function () {
     $("#third_quarter_4").click(function () {
         $.ajax({
             async: true,
             data: {quarter_quarter_3:$("#third_quarter_4").val()},
             type: "post",        //type：(string)请求方式，POST或GET
             dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第四季度产品销售情况',
               });
             }
         });
     });
 });
</script>
<!-- 
<script>

/**
 *  每个产品的季度销售量
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
       categories: ['第一季度', '第二季度', '第三季度', '第四季度'],
       title: {
           text: '年份/年',
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
   	$("#second_year_2017").attr("checked","checked");
   $.ajax({
  	    async: true,
  	  	data: {y_quarter_2:$("#second_year_2017").val()},
  	    type: "post",        //type：(string)请求方式，POST或GET
  	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
  	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
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
	    $("#second_year_2017").click(function () {
	    	alert("hello");
	    	$.ajax({
	      	    async: true,
	      	  	data: {y_quarter_2:$("#second_year_2017").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
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
	    $("#second_year_2016").click(function () {
	    	alert("hello");
	    	$.ajax({
	      	    async: true,
	      	  	data: {y_quarter_2:$("#second_year_2017").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
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
	    $("#second_year_2015").click(function () {
	    	alert("hello");
	    	$.ajax({
	      	    async: true,
	      	  	data: {y_quarter_2:$("#second_year_2015").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
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
</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  