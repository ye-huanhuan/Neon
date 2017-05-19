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
       text: '每天的分布情况',
       x: -20 //center
     },
     xAxis: {
       categories: ['2012', '2013', '2014', '2015','2016','2017']
     },
     yAxis: {
       title: {
         text: 'Y轴'
       },
       plotLines: [{
         value: 0,
         width: 1,
         color: '#808080'
       }]
     },
     tooltip: {
       formatter: function() {
         return '<b>'+ this.series.name +'</b><br/>' + this.x +': '+ this.y ;
       }
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
  	    	alert(productName.length);
  	    	for(var i=0;i<productName.length;i++){
	        options.series[i] = new Object();
	        options.series[i].name = productName[i];
	        options.series[i].data = productValue[i];
  	    	}
	        chart1 = new Highcharts.Chart(options);
  	    }
   });
   
});
 