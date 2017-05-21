/**
 *  同一个月不同产品的销量
 */
 var chart2;
$(function () {
chart2 = new Highcharts.Chart('container_third',{
		credits: {
			enabled:false
		},
		chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '五月销项产品',
            x: -20,
        },
        subtitle: {
            text: '数据来源: 财务部',
            x: -20,
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '产品销量',
            data: [
                ['猪肉罐头',   39.2],
                ['鸡肉罐头',   11.8],
                {
                    name: '鱼肉罐头',
                    y: 48.5,
                    sliced: true,
                    selected: true
                },
               
                ['其他',   0.5]
            ]
        }]
    });
$("#month5").attr("checked","checked");
$.ajax({
    async: true,
    data: {m:$("#month5").val()},
    type: "post",        //type：(string)请求方式，POST或GET
    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    url: "analyze_month_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    success: function (msg) {
        var obj = eval(msg);
        var a = obj["data_output_month_3"];
       for(var i=0;i<a.length;i++)
       {
           for(var j=0;j<a[i].length;j++)
           {
               if(j==1){
            	   a[i][j] = Number(a[i][j]);
               }
               
               }
           }
        chart2.series[0].setData(a);
        chart2.title.update({
     		text: '五月产品销售情况',
     });
    }
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
            url: "analyze_month_3.action",
            success: function (msg) {
                var obj = eval(msg);
                var a = obj["data_output_month_3"];
                for(var i=0;i<a.length;i++)
                {
                    for(var j=0;j<a[i].length;j++)
                    {
                        if(j==1){
                     	   a[i][j] = Number(a[i][j]);
                        }
                        }
                    }
                 chart2.series[0].setData(a);
                 chart2.title.update({
              		text: '四月产品销售情况',
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
            url: "analyze_month_3.action",
            success: function (msg) {
                var obj = eval(msg);
                var a = obj["data_output_month_3"];
                for(var i=0;i<a.length;i++)
                {
                    for(var j=0;j<a[i].length;j++)
                    {
                        if(j==1){
                     	   a[i][j] = Number(a[i][j]);
                        }
                        }
                    }
                 chart2.series[0].setData(a);
                 chart2.title.update({
             		text: '三月产品销售情况',
             	
             });
            }
        });
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
            url: "analyze_month_3.action",
            success: function (msg) {
                var obj = eval(msg);
                var a = obj["data_output_month_3"];
                for(var i=0;i<a.length;i++)
                {
                    for(var j=0;j<a[i].length;j++)
                    {
                        if(j==1){
                     	   a[i][j] = Number(a[i][j]);
                        }
                        }
                    }
                 chart2.series[0].setData(a);
                 chart2.title.update({
             		text: '五月产品销售情况',
             	
             });
            }
        });
    });
});