/**
 * top3-year
 */
var productName_top;
var productValue_top;
var chart3;
$(function () {
	chart3 = new Highcharts.Chart('container_third_2',{
        chart: {
            type: 'bar'
        },
        title: {
            text: '2017年产品销售情况'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        xAxis: {
            categories: ['鱼肉罐头', '猪肉罐头', '鸡肉罐头'],
            title: {
                text: null
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '税收额/万元',
                align: 'high'
            },
            labels: {
                overflow: 'justify',
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        tooltip: {
            valueSuffix: ' 万元'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true,
                    allowOverlap: true
                }
            }
        },
        credits: {
            enabled: false
        },
        legend: {
            enabled: false  //关闭图例
        },
        series: [{
        	name: '2017',
            data: [100,80,60]
        }]
    });
    $.ajax({
        async: true,
        data: {year_year_3:$("#year2017").val()},
        type: "post",        //type：(string)请求方式，POST或GET
        dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
        url: "analyze_year_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
        success: function (msg) {
            var obj = eval(msg);
            productName_top = obj["data_output_month_3_key"];
            productValue_top = obj["data_output_month_3_value"];
            alert(productName_top);
            alert(productValue_top);
            chart3.series[0].update({
            	name: '2017年',
        		data: productValue_top,
            });
            chart3.xAxis[0].update({
            	categories: productName_top,
            });
        }
    });
});
//发送异步请求2017年数据
$(function () {
    $("#year2017").click(function () {
    	$.ajax({
            async: true,
            data: {year_year_3:$("#year2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_year_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '2017年',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "2017年产品销售情况",
                });
            }
        });
    });
});
//发送异步请求2016年数据
$(function () {
    $("#year2016").click(function () {
    	$.ajax({
            async: true,
            data: {year_year_3:$("#year2016").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_year_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '2016年',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "2016年产品销售情况",
                });
            }
        });
    });
});
//发送异步请求2015年数据
$(function () {
    $("#year2015").click(function () {
    	$.ajax({
            async: true,
            data: {year_year_3:$("#year2015").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_year_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '2015年',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "2015年产品销售情况",
                });
            }
        });
    });
});

