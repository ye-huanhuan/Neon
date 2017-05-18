/**
 * 月份进销项总和对比
 */
	//运用构造函数式

var data_difference;
var data_input;
var data_output;
var chart;

var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7','#058DC7','#058DC7','#058DC7'];
$(function () {
     chart = new Highcharts.Chart('container_top', {
        title: {
            text: '月份分析表',
            x: -20
        },
        subtitle: {
            text: '数据来源: 财务部',
            x: -20
        },
        xAxis: {
            categories: ['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月'],
            title: {
                text: '月份/月',
                align: 'high',
            }
        },
        yAxis: {
            title: {
                text: '金额/万元',
                align: 'high',
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
        	//数据后缀
            valueSuffix: '万'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        
        series: [
			{
				colorByPoint: true,	
   		 		type: 'column',
    			name: '进销差值',
    			colors: columnColor,
				},
             {
			type: 'spline',
            name: '进项金额',
             
        }, {
        	type: 'spline',
        	name: '销项金额',
             
        }
        ]
   });
   //初始化highchart
     $("#year-2017").attr("checked","checked");
     $.ajax({
    	    async: true,
    	    data: {y:$("#year-2017").val()},
    	    type: "post",        //type：(string)请求方式，POST或GET
    	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    	    url: "analyze_month_1.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    	    success: function (msg) {
    	    	
    	        var obj = eval(msg);
    	        data_difference = obj["data_difference"];
    	        data_input = obj["data_input"];
    	        data_output = obj["data_output"];
    	        var rangeValue = obj["dvalue_double"];
    	        $("#rangeValue").val(rangeValue);
    	        change();
    	        chart.series[0].setData(data_difference);
    	        chart.series[1].setData(data_input);
    	        chart.series[2].setData(data_output);
    	    }
    	});
});
//发送异步请求2016年数据
$(function () {
    $("#year-2016").click(function () {
    	alert("hello");
        $.ajax({
            async: true,
            data: {y:$("#year-2016").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_1.action",
            success: function (msg) {
            	
            	alert(msg);
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
//                newdate = [obj["1"],obj["2"],obj["3"],obj["4"],obj["5"],obj["6"],obj["7"],obj["8"],obj["9"],obj["10"],obj["11"],obj["12"]];
                alert(data_difference);
                chart.series[0].setData(data_difference);
                chart.series[1].setData(data_input);
                chart.series[2].setData(data_output);
            }
        });
    });
});
//发送异步请求2017年数据
$(function () {
    $("#year-2017").click(function () {
    	
        $.ajax({
            async: true,
            data: {y:$("#year-2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_month_1.action",
            success: function (msg) {
            	
            	alert(msg);
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
//                newdate = [obj["1"],obj["2"],obj["3"],obj["4"],obj["5"],obj["6"],obj["7"],obj["8"],obj["9"],obj["10"],obj["11"],obj["12"]];
                alert(data_difference);
                chart.series[0].setData(data_difference);
                chart.series[1].setData(data_input);
                chart.series[2].setData(data_output);
            }
        });
    });
});
//发送异步请求2015年数据
$(function () {
    $("#year-2015").click(function () {
    	
        $.ajax({
            async: true,
            data: {y:$("#year-2015").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
//            url: "jsondate.json",  //url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            url: "analyze_month_1.action",
            success: function (msg) {
            	
            	alert(msg);
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
//                newdate = [obj["1"],obj["2"],obj["3"],obj["4"],obj["5"],obj["6"],obj["7"],obj["8"],obj["9"],obj["10"],obj["11"],obj["12"]];
                alert(data_difference);
                chart.series[0].setData(data_difference);
                chart.series[1].setData(data_input);
                chart.series[2].setData(data_output);
            }
        });
    });
});

//改变超出范围的颜色
function change(){
	var aa = $(".range-slider").val();
	var subaa = aa.split(",");
	var min = subaa[0];
	var max = subaa[1];
	for(var i=0;i<data_difference.length;i++){
		if(data_difference[i]>max || data_difference[i]<min){
			columnColor[i] = '#FF0000';
		}else{
			columnColor[i] = '#058DC7';
		}
	}
	chart.series[0].update({
		colors: columnColor,
	
});
}

//使用jrange
$('.range-slider').jRange({
    from: -20,
    to: 60,
    step: 2,
    scale: [-20,0,20,40,60],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change,
});


