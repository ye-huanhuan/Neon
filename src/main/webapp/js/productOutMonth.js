/**
 *  每个产品的月销售量
 */
//var data1 = [2.5, 8, 0.8, 0.4, 0.3, 10.0, 5.0, 7.8, 5.1, 3.1, 2.0, 8.6];
//var data2 = [8, 0.8, 0.4, 0.3, 10.0, 5.0, 7.8, 5.1, 3.1, 2.0, 8.6, 2.5];
//var data3 =[27.0, 25.0, 33.0, 30.0, 38.0, 17.0, 18.0, 17.0, 14.3, 9.0, 18.0, 29.0];
$(function () {
var chart = new Highcharts.Chart('container_second', {
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
    series: [{
        name: '猪肉罐头',
       
    }, {
        name: '鸡肉罐头',
        //data: [8, 0.8, 0.4, 0.3, 10.0, 5.0, 7.8, 5.1, 3.1, 2.0, 8.6, 2.5],
    }, {
        name: '鱼肉罐头',
       // data: [8, 0.8, 0.4, 0.3, 10.0, 5.0, 7.8, 5.1, 3.1, 2.0, 8.6, 2.5],
    }, ]
});
  //初始化highchart
    $.ajax({
   	    async: true,
   	    data: {y:$("#second_year2017").val()},
   	    type: "post",        //type：(string)请求方式，POST或GET
   	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
   	    url: "test_testJson.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
   	    success: function (msg) {
   	    	alert("hello w");
   	        var obj = eval(msg);
   	        var data_productDmonth = obj["data_output"];
   	        alert(data_productDmonth);
   	        
   	        
//   	        chart.series[0].setData(data_difference);
//   	        chart.series[1].setData(data_input);
//   	        chart.series[2].setData(data_output);
   	    }
    });
});