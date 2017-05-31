/*
 *  同一年不同产品的销量
 */
 var chart2;
 $(function () {
 chart2 = new Highcharts.Chart('container_third',{
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        credits: {
			enabled:false
		},
        title: {
            text: '产品销售情况',
            x: -20,
        },
        subtitle: {
            text: '数据来源: 财务部',
            x: -20,
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>',
            style: {                      // 文字内容相关样式
                color: "#F0F8FF",
                fontSize: "14px",
                fontWeight: "blod",
                fontFamily: "微软雅黑"
            }
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
                ['猪肉罐头',   40.2],
                ['鸡肉罐头',   10.8],
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
$("#year2017").attr("checked","checked");
$.ajax({
    async: true,
    data: {year_year_3:$("#year2017").val()},
    type: "post",        //type：(string)请求方式，POST或GET
    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    url: "analyze_year_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    success: function (msg) {
        var obj = eval(msg);
        var a = obj["data_output_year_3"];
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
    }
});
 });
//发送异步请求2016年数据

 $("#year2016").click(function () {
     $.ajax({
         async: true,
         data: {year_year_3:$("#year2016").val()},
         type: "post",        //type：(string)请求方式，POST或GET
         dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
         url: "analyze_year_3.action",
         success: function (msg) {
             var obj = eval(msg);
             var a = obj["data_output_year_3"];
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
         }
     });
 });
 
//发送异步请求2017年数据

 $("#year2017").click(function () {
     $.ajax({
         async: true,
         data: {year_year_3:$("#year2017").val()},
         type: "post",        //type：(string)请求方式，POST或GET
         dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
         url: "analyze_year_3.action",
         success: function (msg) {
             var obj = eval(msg);
             var a = obj["data_output_year_3"];
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
         }
     });
 });
//发送异步请求2015年数据

 $("#year2015").click(function () {
     $.ajax({
         async: true,
         data: {year_year_3:$("#year2015").val()},
         type: "post",        //type：(string)请求方式，POST或GET
         dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
         url: "analyze_year_3.action",
         success: function (msg) {
             var obj = eval(msg);
             var a = obj["data_output_year_3"];
             for(var i=0;i<a.length;i++)
             {
                 for(var j=0;j<a[i].length;j++)
                 {
                     //alert("第"+i+"行 第"+j+"列 的值为:"+a[i][j]);
                     if(j==1){
                  	   a[i][j] = Number(a[i][j]);
                     }
                     }
                 }
              chart2.series[0].setData(a);
         }
     });
 });