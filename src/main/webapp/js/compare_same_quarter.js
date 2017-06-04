///**
// * 产品较去年同比-季度
// */
//var items;
//var thisYearValue;
//var lastYearValue;
//var chart4;
//$(function () {
//	chart4 = new Highcharts.Chart('container_fourth',{
//        chart: {
//            type: 'column'
//        },
//        title: {
//            text: '产品较去年同比分析'
//        },
//        subtitle: {
//            text: '数据来源: 财务部'
//        },
//        //去除右下角水印
//        credits: {
//			enabled:false
//		},
//        xAxis: {
//            categories: [
//                '鱼肉罐头',
//                '猪肉罐头',
//                '鸡肉罐头',
//            ],
//            crosshair: true,
//            labels: {
//                style: {
//                    fontSize:'14px',
//                    fontFamily:'微软雅黑'
//                }
//            },
//            title: {
//                text: '产品',
//                align: 'high',
//            },
//        },
//        yAxis: {
//            min: 0,
//            title: {
//                text: '税额/万元',
//                align: 'high',
//            },
//            labels: {
//                style: {
//                    fontSize:'14px',
//                    fontFamily:'微软雅黑'
//                }
//            }
//        },
//        tooltip: {
//            headerFormat: '<span style="font-size:14px">{point.key}</span><table>',
//            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
//            '<td style="padding:0"><b>{point.y:.1f} 万元</b></td></tr>',
//            footerFormat: '</table>',
//            shared: true,
//            useHTML: true,
//            style: {                      // 文字内容相关样式
//                color: "#F0F8FF",
//                fontSize: "14px",
//                fontWeight: "blod",
//                fontFamily: "微软雅黑"
//            }
//        },
//        plotOptions: {
//            column: {
//                pointPadding: 0.2,
//                borderWidth: 0
//            }
//        },
//        series: [{
//            name: '去年第二季度',
//            data: [49.9, 71.5, 106.4],
//        },{
//        	name: '今年第二季度',
//            data: [83.6, 78.8, 98.5]
//        }]
//    });
//	$.ajax({
//        async: true,
//        type: "post",        //type：(string)请求方式，POST或GET
//        dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//        url: "analyze_quarter_4.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
//        success: function (msg) {
//            var obj = eval(msg);
//            items = obj["items_quarter_4"];
//            thisYearValue = obj["thisYear_Quarter_quarter_4"];
//            lastYearValue = obj["lastYear_Quarter_quarter_4"];
//            chart4.series[0].update({
//        		data: lastYearValue,
//            });
//            chart4.series[1].update({
//            	data: thisYearValue,
//            });
//            chart4.xAxis[0].update({
//            	categories: items,
//            });
//        }
//    });
//});
var chart1;
var test1 = [];
var drilldown = {};
var items = ["鸡肉罐头","鱼肉罐头","猪肉罐头"];
var data_last = [1,5,9];
var data_now = [2,7,10];
var month = ["一月","二月","三月"];
var data_last_month = [[0.5,0.2,0.3],[1,2,2],[4,2,3]];
var data_now_month = [[1,0.5,0.5],[1,2,4],[5,2,3]];
$("#out").attr("checked","checked");
//初始化
$(function () {
$.ajax({
    async: false,
    type: "post",        //type：(string)请求方式，POST或GET
    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    url: "analyze_quarter_4.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    success: function (msg) {
        var obj = eval(msg);
        items = obj["items_quarter_4"];
        data_last = obj["lastYear_Quarter_quarter_4"];
        data_now = obj["thisYear_Quarter_quarter_4"];
        month = obj["months_quarter_4"];
        data_last_month = obj["lastYear_Month_quarter_4"];
        data_now_month = obj["thisYear_Month_quarter_4"];
        reduce();
    }
});
});
//异步请求销项
$("#out").click(function () {
	$.ajax({
	    async: false,
	    type: "post",        //type：(string)请求方式，POST或GET
	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	    url: "analyze_quarter_4.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	    success: function (msg) {
	        var obj = eval(msg);
	        items = obj["items_quarter_4"];
	        data_last = obj["lastYear_Quarter_quarter_4"];
	        data_now = obj["thisYear_Quarter_quarter_4"];
	        month = obj["months_quarter_4"];
	        data_last_month = obj["lastYear_Month_quarter_4"];
	        data_now_month = obj["thisYear_Month_quarter_4"];
	        reduce();
	    }
	});
});
//异步请求进项
$("#in").click(function () {
	$.ajax({
	    async: false,
	    type: "post",        //type：(string)请求方式，POST或GET
	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	    url: "analyze_quarter_4.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	    success: function (msg) {
	        var obj = eval(msg);
	        items = obj["items_quarter_4"];
	        data_last = obj["lastYear_Quarter_quarter_4"];
	        data_now = obj["thisYear_Quarter_quarter_4"];
	        month = obj["months_quarter_4"];
	        data_last_month = obj["lastYear_Month_quarter_4"];
	        data_now_month = obj["thisYear_Month_quarter_4"];
	        reduce();
	    }
	});
});
    //series
function reduce(){
	for(var i=0;i<2;i++){
        test1[i] = {};
        if(i===0){
            test1[i].name = "去年";
            test1[i].color = Highcharts.getOptions().colors[1];
//            test1[i].colorByPoint = true;
            test1[i].data = new Array(items.length);
            for(var j=0;j<test1[i].data.length;j++){
                test1[i].data[j] = {};
                test1[i].data[j].name = items[j];
                test1[i].data[j].y = data_last[j];
                test1[i].data[j].drilldown = true;
//                alert(test1[i].data[j].y);
            }
        }
        if(i===1){
            test1[i].name = "今年";
            test1[i].color = Highcharts.getOptions().colors[8];
//            test1[i].colorByPoint = true;
            test1[i].data = new Array(items.length);
            for(var m=0;m<test1[i].data.length;m++){
                test1[i].data[m] = {};
                test1[i].data[m].name = items[m];
                test1[i].data[m].y = data_now[m];
                test1[i].data[m].drilldown = true;
            }
        }

    }
    for(var n=0;n<items.length;n++){
        var item = items[n];
        var item_2 = item+"2";
        drilldown[item] = {};
        drilldown[item_2] = {};
        drilldown[item].name = "去年";
        drilldown[item].color = Highcharts.getOptions().colors[1];
        drilldown[item].data = [];
        for(var k=0;k<3;k++){
            drilldown[item].data[k] = [];
            drilldown[item].data[k][0] = month[k];
//            alert(drilldown[item].data[k][0]);
            drilldown[item].data[k][1] = data_last_month[n][k];
//            alert(drilldown[item].data[k][1]);
        }
        drilldown[item_2].name = "今年";
        drilldown[item_2].color = Highcharts.getOptions().colors[8];
        drilldown[item_2].data = [];
        for(var t=0;t<3;t++){
            drilldown[item_2].data[t] = [];
            drilldown[item_2].data[t][0] = month[t];
            drilldown[item_2].data[t][1] = data_now_month[n][t];

        }
    }
    alert(JSON.stringify(drilldown));
}
    

    $(function() {
    	//配置返回按钮
    	Highcharts.setOptions({
            lang: {
                drillUpText: '<< 返回季度'
            }
        });
        // Create the chart
        chart1 = new Highcharts.Chart('container_fourth',{
        	credits: {
                enabled: false
            },
        	chart: {
                type: 'column',
                
                events: {
                    drilldown: function(e) {
                        if (!e.seriesOptions) {
                            var chart = this,
                                drilldowns = drilldown,
                                series,
                                points = [];
                            //single point drilldown
                            if (e.points === false) {
                                points.push(e.point)
                            } else { //or category drilldown
                                points = e.points;
                            }
                            Highcharts.each(points, function(point) {
                                series = [drilldowns[point.name], drilldowns[point.name + '2']];
                                chart.addSingleSeriesAsDrilldown(e.point, series[0]);
                                chart.addSingleSeriesAsDrilldown(e.point, series[1]);
                            });
                            chart.applyDrilldown();
                        }
                    }
                }
            },
            title: {
                text: '产品同比图'
            },
            xAxis: {
                type: 'category',
                labels: {
                    style: {
                        textDecoration: 'none',
                        fontSize:'14px',
                        fontFamily:'微软雅黑'
                    }
                }
            },
            legend: {
                enabled: false
            },
            
            tooltip: {
                headerFormat: '<span style="font-size:14px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 万元</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true,
                style: {                      // 文字内容相关样式
                    color: "#F0F8FF",
                    fontSize: "14px",
                    fontWeight: "blod",
                    fontFamily: "微软雅黑"
                }
            },
            series: test1,
            drilldown: {
                series: [],
                activeAxisLabelStyle: {
                    textDecoration: 'none',
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                },
                activeDataLabelStyle: {
                    textDecoration: 'none',
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        });

    });
