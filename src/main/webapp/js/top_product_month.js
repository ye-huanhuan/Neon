/**
 * 月份top3
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
            text: '五月产品销售情况'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        xAxis: {
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
            data: [100,80,60]
        }]
    });
    $.ajax({
        async: true,
        data: {m:$("#month5").val()},
        type: "post",        //type：(string)请求方式，POST或GET
        dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
        url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
        success: function (msg) {
            var obj = eval(msg);
            productName_top = obj["data_output_month_3_key"];
            productValue_top = obj["data_output_month_3_value"];
            alert(productValue_top);
            chart3.series[0].update({
            	name: '五月',
        		data: productValue_top,
            });
            chart3.xAxis[0].update({
            	categories: productName_top,
            });
        }
    });
});
//发送异步请求五月数据
$(function () {
    $("#month5").click(function () {
    	$.ajax({
            async: true,
            data: {m:$("#month5").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '五月',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "五月产品销售情况",
                });
            }
        });
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
            url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '四月',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "四月产品销售情况",
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
            url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '三月',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "三月产品销售情况",
                });
            }
        });
    });
});
//发送异步请求四月数据
$(function () {
    $("#month2").click(function () {
    	$.ajax({
            async: true,
            data: {m:$("#month2").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '二月',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "二月产品销售情况",
                });
            }
        });
    });
});
//发送异步请求一月数据
$(function () {
    $("#month1").click(function () {
    	$.ajax({
            async: true,
            data: {m:$("#month1").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '一月',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "一月产品销售情况",
                });
            }
        });
    });
});
//发送异步请求十二月月数据
$(function () {
    $("#month12").click(function () {
    	$.ajax({
            async: true,
            data: {m:$("#month12").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                productName_top = obj["data_output_month_3_key"];
                productValue_top = obj["data_output_month_3_value"];
                chart3.series[0].update({
                	name: '十二月',
            		data: productValue_top,
                });
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
                chart3.title.update({
                	text: "十二月产品销售情况",
                });
            }
        });
    });
});


