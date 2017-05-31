/**
 * 季度top3
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
            text: '第一季度产品销售情况'
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
            valueSuffix: ' 万元',
            headerFormat: '<span style="font-size:14px">{point.key}</span><br>',
            style: {                      // 文字内容相关样式
                color: "#F0F8FF",
                fontSize: "14px",
                fontWeight: "blod",
                fontFamily: "微软雅黑"
            }
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
        	name: '第一季度',
            data: [100,80,60]
        }]
    });
	
	$.ajax({
        async: true,
        data: {quarter_quarter_3:$("#third_quarter_1").val()},
        type: "post",        //type：(string)请求方式，POST或GET
        dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
        url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
        success: function (msg) {
            var obj = eval(msg);
            productName_top = obj["data_output_month_3_key"];
            productValue_top = obj["data_output_month_3_value"];
            chart3.series[0].update({
            	name: '第一季度',
        		data: productValue_top,
            });
            chart3.xAxis[0].update({
            	categories: productName_top,
            });
        }
    });
});
//发送异步请求第一季度数据
$(function () {
    $("#third_quarter_1").click(function () {
    	$.ajax({
            async: true,
            data: {quarter_quarter_3:$("#third_quarter_1").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '第一季度',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "第一季度产品销售情况",
                });
            }
        });
    });
});
//发送异步请求第二季度数据
$(function () {
    $("#third_quarter_2").click(function () {
    	$.ajax({
            async: true,
            data: {quarter_quarter_3:$("#third_quarter_2").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '第二季度',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "第二季度产品销售情况",
                });
            }
        });
    });
});
//发送异步请求第三季度数据
$(function () {
    $("#third_quarter_3").click(function () {
    	$.ajax({
            async: true,
            data: {quarter_quarter_3:$("#third_quarter_3").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '第三季度',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "第三季度产品销售情况",
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
            url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '第四季度',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "第四季度产品销售情况",
                });
            }
        });
    });
});
