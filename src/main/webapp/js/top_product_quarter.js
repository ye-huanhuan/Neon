/**
 * 季度top3
 */
var productName_top;
//var productValue_top;
var productValue = [];
var productMonths;
var productValue_month_1;
var productValue_month_2;
var productValue_month_3;
var chart3;
$(function () {
    chart3 = new Highcharts.Chart('container_third_2', {
        chart: {
            type: 'bar'
        },
        title: {
            text: '第一季度产品税额排名图'
        },
        subtitle: {
            text: null
        },
        xAxis: {
            categories: ['鱼肉罐头', '猪肉罐头', '鸡肉罐头'],
            title: {
                text: null
            },
            labels: {
                style: {
                    fontSize: '14px',
                    fontFamily: '微软雅黑'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '税额额/万元',
                align: 'high'
            },
            labels: {
                overflow: 'justify',
                style: {
                    fontSize: '14px',
                    fontFamily: '微软雅黑'
                }
            }
        },
        tooltip: {
        	headerFormat: '<span style="font-size:14px">{point.key}</span><br>',
            pointFormat: '<span style="color:{series.color};font-size: 14px">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
            shared: true,
		    style: {                      // 文字内容相关样式
		        color: "#F0F8FF",
		        fontSize: "14px",
		        fontWeight: "blod",
		        fontFamily: "微软雅黑"
		    }
        },

        plotOptions: {
            series: {
                stacking: 'normal'
            }
        },

        credits: {
            enabled: false
        },
        legend: {
            enabled: false  //关闭图例
        },
        series: [{
            },
            {
            },
            {
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
            productMonths = obj["data_output_month_3_months"];
            productValue_month_1 = obj["data_output_month_3_1"];
            productValue_month_2 = obj["data_output_month_3_2"];
            productValue_month_3 = obj["data_output_month_3_3"];
            productValue[0] = productValue_month_1;
            productValue[1] = productValue_month_2;
            productValue[2] = productValue_month_3;
            chart3.xAxis[0].update({
            	categories: productName_top,
            });
        	chart3.series[0].update({
            	name: productMonths[0],
        		data: productValue[0],
            });
        	chart3.series[1].update({
            	name: productMonths[1],
        		data: productValue[1],
            });
        	chart3.series[2].update({
            	name: productMonths[2],
        		data: productValue[2],
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
                productMonths = obj["data_output_month_3_months"];
                productValue_month_1 = obj["data_output_month_3_1"];
                productValue_month_2 = obj["data_output_month_3_2"];
                productValue_month_3 = obj["data_output_month_3_3"];
                productValue[0] = productValue_month_1;
                productValue[1] = productValue_month_2;
                productValue[2] = productValue_month_3;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productMonths[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productMonths[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productMonths[2],
            		data: productValue[2],
                });
            	chart3.title.update({
                	text: "第一季度产品税额排名图",
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
                productMonths = obj["data_output_month_3_months"];
                productValue_month_1 = obj["data_output_month_3_1"];
                productValue_month_2 = obj["data_output_month_3_2"];
                productValue_month_3 = obj["data_output_month_3_3"];
                productValue[0] = productValue_month_1;
                productValue[1] = productValue_month_2;
                productValue[2] = productValue_month_3;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productMonths[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productMonths[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productMonths[2],
            		data: productValue[2],
                });
                chart3.title.update({
                	text: "第二季度产品税额排名图",
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
                productMonths = obj["data_output_month_3_months"];
                productValue_month_1 = obj["data_output_month_3_1"];
                productValue_month_2 = obj["data_output_month_3_2"];
                productValue_month_3 = obj["data_output_month_3_3"];
                productValue[0] = productValue_month_1;
                productValue[1] = productValue_month_2;
                productValue[2] = productValue_month_3;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productMonths[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productMonths[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productMonths[2],
            		data: productValue[2],
                });
                chart3.title.update({
                	text: "第三季度产品税额排名图",
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
                productMonths = obj["data_output_month_3_months"];
                productValue_month_1 = obj["data_output_month_3_1"];
                productValue_month_2 = obj["data_output_month_3_2"];
                productValue_month_3 = obj["data_output_month_3_3"];
                productValue[0] = productValue_month_1;
                productValue[1] = productValue_month_2;
                productValue[2] = productValue_month_3;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productMonths[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productMonths[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productMonths[2],
            		data: productValue[2],
                });
                chart3.title.update({
                	text: "第四季度产品税额排名图",
                });
            }
        });
    });
});
