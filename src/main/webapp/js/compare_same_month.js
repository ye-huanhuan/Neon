/**
 * 月份同比
 */
var items;
var thisYearValue;
var lastYearValue;
var chart4;
var date = new Date();
var month = date.getMonth();
$(function () {
	chart4 = new Highcharts.Chart('container_fourth',{
        chart: {
            type: 'column'
        },
        title: {
            text: '产品较去年同比分析'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        //去除右下角水印
        credits: {
			enabled:false
		},
        xAxis: {
            categories: ['鱼肉罐头','猪肉罐头','鸡肉罐头'],
            crosshair: true,
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            },
            title: {
                text: '产品',
                align: 'high',
            },
        },
        yAxis: {
            min: 0,
            title: {
                text: '税额/万元',
                align: 'high',
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        tooltip: {
//            headerFormat: '<span style="font-size:14px">{point.key}</span><table>',
//            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
//            '<td style="padding:0"><b>{point.y:.1f} 万元</b></td></tr>',
//            footerFormat:  '</table>',
        	 formatter: function() {
                 var points = this.points,
                     str = '';
                 var i = 0;
                 var a = [];
                 var itemsName;
                 Highcharts.each(points, function(p) {
                	 itemsName = p.x;
                     str += p.series.name + ':' + '\t' + p.y + '<br>';
                     a[i] = p.y;
                     i++;
                 });
                var percent = ((a[1]/a[0])*100).toFixed(2) + "%";
                 return itemsName + '<br>' + str + "同比增长:" + percent;
             },
            shared: true,
            useHTML: true,
            style: {                      // 文字内容相关样式
                color: "#F0F8FF",
                fontSize: "14px",
                fontWeight: "blod",
                fontFamily: "微软雅黑"
            }
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            },
        },
        series: [{
        },{
        }]
    });
	$("#out").attr("checked","checked");
    $.ajax({
        async: true,
        type: "post",        //type：(string)请求方式，POST或GET
        dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
        url: "analyze_month_4.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
        success: function (msg) {
            var obj = eval(msg);
            items = obj["items_month_4"];
            thisYearValue = obj["thisYear_moeny_month_4"];
            lastYearValue = obj["lastYear_money_month_4"];
            chart4.series[0].update({
        		data: lastYearValue,
        		name: "去年"+month+"月"
            });
            chart4.series[1].update({
            	data: thisYearValue,
            	name: "今年"+month+"月"
            });
            chart4.xAxis[0].update({
            	categories: items,
            });
        }
    });
    //异步请求销项数据
    $("#out").click(function () {
    	$.ajax({
            async: true,
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_4.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                items = obj["items_month_4"];
                thisYearValue = obj["thisYear_moeny_month_4"];
                lastYearValue = obj["lastYear_money_month_4"];
                chart4.series[0].update({
            		data: lastYearValue,
            		name: "去年"+month+"月"
                });
                chart4.series[1].update({
                	data: thisYearValue,
                	name: "今年"+month+"月"
                });
                chart4.xAxis[0].update({
                	categories: items,
                });
            }
        });
    	
    });
    //异步请求进项数据
    $("#in").click(function () {
    	$.ajax({
            async: true,
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_5.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                items = obj["input_items_month_4"];
                thisYearValue = obj["input_thisYear_moeny_month_4"];
                lastYearValue = obj["input_lastYear_money_month_4"];
                chart4.series[0].update({
            		data: lastYearValue,
            		name: "去年"+month+"月"
                });
                chart4.series[1].update({
                	data: thisYearValue,
                	name: "今年"+month+"月"
                });
                chart4.xAxis[0].update({
                	categories: items,
                });
            }
        });
    	
    });
});
