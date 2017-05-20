/**
 *  每个产品的年售出量
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
       categories: ['2012', '2013', '2014', '2015','2016','2017'],
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
   
   $.ajax({
  	    async: true,
  	    type: "post",        //type：(string)请求方式，POST或GET
  	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
  	    url: "analyze_year_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
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