/**
 * 年度进销项总和对比
 */

var data_difference;
var data_input;
var data_output;
var chart;
var aver_input = 0,aver_output = 0;
var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7','#058DC7','#058DC7'];

//使用jrange
$('#rangeValue').jRange({
    from: 0,
    to: 800,
    step: 50,
    scale: [0,100,200,300,400,500,600,700,800],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change,
});

function calculate(){
	var num_effe_input = 0,num_effe_output = 0;
    var sum_effe_input = 0,sum_effe_output = 0;
    var variance_input = 0;variance_output = 0;
    for(d in data_input){
    	if(data_input[d] >= 0 && data_input[d] != null){
    		num_effe_input ++;
    		sum_effe_input += data_input[d];
    	}
    }
    if(num_effe_input != 0){
    	aver_input = (sum_effe_input/num_effe_input).toFixed(2);
    }
    
    for(d in data_output){
    	if(data_output[d] >= 0 && data_output[d] != null){
    		num_effe_output ++;
    		sum_effe_output += data_output[d];
    	}
    }
    if(num_effe_output != 0){
    	aver_output = (sum_effe_output/num_effe_output).toFixed(2);
    }
    for(d in data_input){
    	if(data_input[d] >= 0 && data_input[d] != null){
    		variance_input += Math.pow((data_input[d]-aver_input),2);
    	}
    }
    
    for(d in data_output){
    	if(data_output[d] >= 0 && data_output[d] != null){
    		variance_output += (Math.pow((data_output[d]-aver_output),2));
    	}
    }
    variance_input=variance_input.toFixed(4);
    variance_output = variance_output.toFixed(4);
    $("#aver_input").text(aver_input);
    $("#aver_output").text(aver_output);
    $("#variance_input").text(variance_input);
    $("#variance_output").text(variance_output);
}
function transfer(data){
	for(i in data){
    	if(data[i] == 0){
    		data[i] = null;
    	}
    }
}
$(function () {
	//运用构造函数式
     chart = new Highcharts.Chart('container_top', {
    	 credits: {
 			enabled:false
 		},
        title: {
            text: null,
            x: -20
        },

        subtitle: {
        	 text: "红色数据点表示在税收额平均值之下的年份",
             floating: true,
             align: 'left',
             x: 530,
             y: 370,
             useHTML: true
        },
        xAxis: {
            categories: ['2012', '2013', '2014', '2015', '2016', '2017'],
            title: {
                text: '年度/年',
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
            },
        },
        tooltip: {
        	//数据后缀
            valueSuffix: '万',
            headerFormat: '<span style="font-size:14px">{point.key}</span><br>',
            style: {                      // 文字内容相关样式
                color: "#F0F8FF",
                fontSize: "14px",
                fontWeight: "blod",
                fontFamily: "微软雅黑"
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0,
            title: {
                text: '<span style="font-size: 14px; color: #666; color:white">点击隐藏</span>',
            },
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
     $.ajax({
    	    async: true,
    	    type: "post",        //type：(string)请求方式，POST或GET
    	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
    	    url: "analyze_year_1.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
    	    success: function (msg) {
    	        var obj = eval(msg);
    	        data_difference = obj["data_difference_year"];
    	        data_input = obj["data_input_year"];
    	        data_output = obj["data_output_year"];
    	        transfer(data_difference);
    	        transfer(data_input);
    	        transfer(data_output);
    	        calculate();  //统计
    	        var rangeValue = obj["dvalue_double_year"];
    	        var initValue = rangeValue[1].toString()+","+rangeValue[0].toString();
    	        $('#rangeValue').jRange('setValue', initValue);
    	        change();
    	        chart.series[0].setData(data_difference);
    	        change_aver_color();
    	    }
    	});
});

//改变进项和销项低于平均值的颜色
function change_aver_color(){
	var newData_input = [];
	var newData_output = [];
	for(var i=0;i<data_input.length;i++){
		if(data_input[i]<aver_input){
			var o = {};
			o.y = data_input[i];
			o.color = '#BF0B23';
			newData_input[i] = o;
		}else{
			var o1 = {};
			o1.y = data_input[i];
			o1.color = '#2B908F';
			newData_input[i] = o1;
		}
	}
	for(var i=0;i<data_output.length;i++){
		if(data_output[i]<aver_output){
			var obj = new Object();
			obj.y=data_output[i];
			obj.color = '#BF0B23';
			newData_output[i] = obj;
		}else{
			var obj1 = new Object();
			obj1.y=data_output[i];
			obj1.color = '#90EE7E';
			newData_output[i] = obj1;
		}
	}
	chart.series[1].update({
		data: newData_input,
});
	chart.series[2].update({
		data: newData_output,
});
	
}

//改变超出范围的颜色
function change(){
	var aa = $("#rangeValue").val();
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


