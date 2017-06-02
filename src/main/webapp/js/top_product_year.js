/**
 * top3-year
 */
var productName_top;
//var productValue_top;
var productQuarters;
var productValue_quarter_1;
var productValue_quarter_2;
var productValue_quarter_3;
var productValue_quarter_4;
var productValue = [];
var chart3;
$(function () {
    chart3 = new Highcharts.Chart('container_third_2', {
        chart: {
            type: 'bar'
        },
        title: {
            text: '2017产品销售情况'
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
                    fontSize: '14px',
                    fontFamily: '微软雅黑'
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
            },
            {
            }]
    });
    $.ajax({
        async: true,
        data: {year_year_3:$("#year2016").val()},
        type: "post",        //type：(string)请求方式，POST或GET
        dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
        url: "analyze_year_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
        success: function (msg) {
        	var obj = eval(msg);
            productName_top = obj["data_output_year_3_key"];
            productQuarters = obj["data_output_year_3_quarters"];
            productValue_quarter_1 = obj["data_output_quarter_3_1"];
            productValue_quarter_2 = obj["data_output_quarter_3_2"];
            productValue_quarter_3 = obj["data_output_quarter_3_3"];
            productValue_quarter_4 = obj["data_output_quarter_3_4"];
            productValue[0] = productValue_quarter_1;
            productValue[1] = productValue_quarter_2;
            productValue[2] = productValue_quarter_3;
            productValue[3] = productValue_quarter_4;
            chart3.xAxis[0].update({
            	categories: productName_top,
            });
        	chart3.series[0].update({
            	name: productQuarters[0],
        		data: productValue[0],
            });
        	chart3.series[1].update({
            	name: productQuarters[1],
        		data: productValue[1],
            });
        	chart3.series[2].update({
            	name: productQuarters[2],
        		data: productValue[2],
            });
        	chart3.series[3].update({
            	name: productQuarters[3],
        		data: productValue[3],
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
                productName_top = obj["data_output_year_3_key"];
                productQuarters = obj["data_output_year_3_quarters"];
                productValue_quarter_1 = obj["data_output_quarter_3_1"];
                productValue_quarter_2 = obj["data_output_quarter_3_2"];
                productValue_quarter_3 = obj["data_output_quarter_3_3"];
                productValue_quarter_4 = obj["data_output_quarter_3_4"];
                productValue[0] = productValue_quarter_1;
                productValue[1] = productValue_quarter_2;
                productValue[2] = productValue_quarter_3;
                productValue[3] = productValue_quarter_4;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productQuarters[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productQuarters[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productQuarters[2],
            		data: productValue[2],
                });
            	chart3.series[3].update({
                	name: productQuarters[3],
            		data: productValue[3],
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
                productName_top = obj["data_output_year_3_key"];
                productQuarters = obj["data_output_year_3_quarters"];
                productValue_quarter_1 = obj["data_output_quarter_3_1"];
                productValue_quarter_2 = obj["data_output_quarter_3_2"];
                productValue_quarter_3 = obj["data_output_quarter_3_3"];
                productValue_quarter_4 = obj["data_output_quarter_3_4"];
                productValue[0] = productValue_quarter_1;
                productValue[1] = productValue_quarter_2;
                productValue[2] = productValue_quarter_3;
                productValue[3] = productValue_quarter_4;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productQuarters[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productQuarters[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productQuarters[2],
            		data: productValue[2],
                });
            	chart3.series[3].update({
                	name: productQuarters[3],
            		data: productValue[3],
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
                productName_top = obj["data_output_year_3_key"];
                productQuarters = obj["data_output_year_3_quarters"];
                productValue_quarter_1 = obj["data_output_quarter_3_1"];
                productValue_quarter_2 = obj["data_output_quarter_3_2"];
                productValue_quarter_3 = obj["data_output_quarter_3_3"];
                productValue_quarter_4 = obj["data_output_quarter_3_4"];
                productValue[0] = productValue_quarter_1;
                productValue[1] = productValue_quarter_2;
                productValue[2] = productValue_quarter_3;
                productValue[3] = productValue_quarter_4;
                chart3.xAxis[0].update({
                	categories: productName_top,
                });
            	chart3.series[0].update({
                	name: productQuarters[0],
            		data: productValue[0],
                });
            	chart3.series[1].update({
                	name: productQuarters[1],
            		data: productValue[1],
                });
            	chart3.series[2].update({
                	name: productQuarters[2],
            		data: productValue[2],
                });
            	chart3.series[3].update({
                	name: productQuarters[3],
            		data: productValue[3],
                });
                chart3.title.update({
                	text: "2015年产品销售情况",
                });
            }
        });
    });
});

