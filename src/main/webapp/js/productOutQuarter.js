/**
 *  每个产品的季度销售量
 */
 var chart1;
 var productName;
 var productValue;
 var options;
 $(function () {
   options = {
	credits: {
		enabled:false
	},	   
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
       //修改y轴值字体的大小
       labels: {
           style: {
               fontSize:'14px',
               fontFamily:'微软雅黑'
           }
       }
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