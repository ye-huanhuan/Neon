/**
 * 同一个季度不同商品的出售情况
 */
 var chart2;
 $(function () {
	 chart2= new Highcharts.Chart('container_third',{
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        //去除右下角水印
        credits: {
			enabled:false
		},
        title: {
            text: '第一季度产品税额占比图',
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
        subtitle: {
        	text: '<span style="font-size: 14px; color: #666; color:white">点击隐藏产品</span>',
            x: 0,
            y: 382
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
                ['猪肉罐头',   50.2],
                ['鸡肉罐头',   10.8],
                {
                    name: '鱼肉罐头',
                    y: 38.5,
                    sliced: true,
                    selected: true
                },
               
                ['其他',   0.5]
            ]
        }]
    });
$("#third_quarter_1").attr("checked","checked");
$.ajax({
    async: true,
    data: {quarter_quarter_3:$("#third_quarter_1").val()},
    type: "post",        //type：(string)请求方式，POST或GET
    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    url: "analyze_quarter_3.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    success: function (msg) {
        var obj = eval(msg);
        var a = obj["data_out_quarter_3"];
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
     		text: '第一季度产品税额占比图',
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
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第一季度产品税额占比图',
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
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第二季度产品税额占比图',
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
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
               		text: '第三季度产品税额占比图',
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
             url: "analyze_quarter_3.action",
             success: function (msg) {
                 var obj = eval(msg);
                 var a = obj["data_out_quarter_3"];
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
                  chart2.title.update({
               		text: '第四季度产品税额占比图',
               });
             }
         });
     });
 });