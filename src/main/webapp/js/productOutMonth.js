
/**
 *  每个产品的月销售量
 */
 var productName = {};
var chart1;
$(function () {
chart1 = new Highcharts.Chart('container_second', {
    title: {
        text: '产品分析表',
        x: -20
    },
    subtitle: {
        text: '数据来源: Neon.com',
        x: -20
    },
    xAxis: {
        categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
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
        valueSuffix: '万元'
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle',
        borderWidth: 0
    },
    series: [{},{},{}],	
});
$("#second_year2017").attr("checked","checked");
  //初始化highchart
    $.ajax({
   	    async: true,
   	    data: {y2:$("#second_year2017").val()},
   	    type: "post",        //type：(string)请求方式，POST或GET
   	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
   	    url: "analyze_month_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
   	    success: function (msg) {
   	    	var obj = eval(msg);
   	    	productName = obj["productName"];
   	    	
   	    	for(var i=0;i<chart1.series.length;i++){
   	    		if(i>=productName.length){
   	    		 chart1.series[i].hide();
   	    		}
   	    		chart1.series[i].update({
   	    	 		name: productName[i],
   	    	 		data: obj["productVlaue"][i],
   	    	 }); 
   	    		
   	    	}
	        
   	    }
    });
});
//发送异步请求2017年数据
$(function () {
    $("#second_year2017").click(function () {
        $.ajax({
            async: true,
            data: {y2:$("#year-2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_2.action",
            success: function (msg) {
            	var obj = eval(msg);
       	    	for(var i=0;i<chart1.series.length;i++){
       	    		chart1.series[i].setData(obj["productVlaue"][i]);
       	    	}
            }
        });
    });
});
//发送异步请求2016年数据
$(function () {
    $("#second_year2016").click(function () {
        $.ajax({
            async: true,
            data: {y2:$("#year-2016").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_2.action",
            success: function (msg) {
            	var obj = eval(msg);
       	    	for(var i=0;i<chart1.series.length;i++){
       	    		chart1.series[i].setData(obj["productVlaue"][i]);
       	    	}
            }
        });
    });
});
//发送异步请求2015年数据
$(function () {
    $("#second_year2015").click(function () {
        $.ajax({
            async: true,
            data: {y2:$("#year-2015").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_2.action",
            success: function (msg) {
            	var obj = eval(msg);
       	    	for(var i=0;i<chart1.series.length;i++){
       	    		chart1.series[i].setData(obj["productVlaue"][i]);
       	    	}
            }
        });
    });
});
