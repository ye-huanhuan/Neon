/**
 * 季度进销项总和对比
 */
	//运用构造函数式

var data_difference_quarter;
var data_input_quatter;
var data_output_quarter;
var chart;
var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7'];
$(function () {
     chart = new Highcharts.Chart('container_top', {
    	 credits: {
             enabled:false
		},
        title: {
            text: '季度分析表',
            x: -20
        },

        subtitle: {

            text: '数据来源: 财务部',

            x: -20
        },
        xAxis: {
            categories: ['第一季度', '第二季度', '第三季度', '第四季度'],
            title: {
                text: '季度/季度',
                align: 'high',
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
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
            }],
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
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
    			data: [-3, 1, 2, -4],
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
     $("#year2017").attr("checked","checked");
     $.ajax({
    	    async: true,
    	    data: {y_quarter_1:$("#year2017").val()},
    	    type: "post",        //type：(string)请求方式，POST或GET
    	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    	    url: "analyze_quarter_1.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    	    success: function (msg) {
    	    	
    	        var obj = eval(msg);
    	        data_difference_quarter = obj["data_difference_quarter"];
    	        alert(data_difference_quarter);
    	        data_input_quarter = obj["data_input_quarter"];
    	        data_output_quarter = obj["data_output_quarter"];
    	        alert(data_difference_quarter);
    	        var rangeValue = obj["dvalue_double"];
    	        var initValue = ""+rangeValue[0]+","+rangeValue[1];
    	        $('#rangeValue').jRange('setValue', initValue);
    	        change();
    	        chart.series[0].setData(data_difference_quarter);
    	        chart.series[1].setData(data_input_quarter);
    	        chart.series[2].setData(data_output_quarter);
    	    }
    	});
});
//发送异步请2017年数据
$(function () {
    $("#year2017").click(function () {
    	alert("hello");
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        alert(data_difference_quarter);
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        alert(data_difference_quarter);
     	        chart.series[0].setData(data_difference_quarter);
     	        chart.series[1].setData(data_input_quarter);
     	        chart.series[2].setData(data_output_quarter);
            }
        });
    });
});
//发送异步请求2016年数据
$(function () {
    $("#year2016").click(function () {
    	
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2016").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        alert(data_difference_quarter);
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        alert(data_difference_quarter);
     	        chart.series[0].setData(data_difference_quarter);
     	        chart.series[1].setData(data_input_quarter);
     	        chart.series[2].setData(data_output_quarter);
            }
        });
    });
});
//发送异步请求2015数据
$(function () {
    $("#year2015").click(function () {
    	
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2015").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        alert(data_difference_quarter);
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        alert(data_difference_quarter);
     	        chart.series[0].setData(data_difference_quarter);
     	        chart.series[1].setData(data_input_quarter);
     	        chart.series[2].setData(data_output_quarter);
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
	for(var i=0;i<data_difference_quarter.length;i++){
		if(data_difference_quarter[i]>max || data_difference_quarter[i]<min){
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
    to: 120,
    step: 5,
    scale: [-20,0,20,40,60,80,100,120],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change,
});

