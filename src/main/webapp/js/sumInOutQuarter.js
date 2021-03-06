/**
 * 季度进销项总和对比
 */
	//运用构造函数式

var data_difference_quarter;
var data_input_quatter;
var data_output_quarter;
var chart;
var aver_input = 0,aver_output = 0;
var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7'];
function calculate(){
	var num_effe_input = 0,num_effe_output = 0;
    var sum_effe_input = 0,sum_effe_output = 0;
    var variance_input = 0;variance_output = 0;
    for(d in data_input_quarter){
    	if(data_input_quarter[d] >= 0 && data_input_quarter[d] != null){
    		num_effe_input ++;
    		sum_effe_input += data_input_quarter[d];
    	}
    }
    if(num_effe_input != 0){
    	aver_input = (sum_effe_input/num_effe_input).toFixed(2);
    }
    
    for(d in data_output_quarter){
    	if(data_output_quarter[d] >= 0 && data_output_quarter[d] != null){
    		num_effe_output ++;
    		sum_effe_output += data_output_quarter[d];
    	}
    }
    if(num_effe_output != 0){
    	aver_output = (sum_effe_output/num_effe_output).toFixed(2);
    }
    for(d in data_input_quarter){
    	if(data_input_quarter[d] >= 0 && data_input_quarter[d] != null){
    		variance_input += Math.pow((data_input_quarter[d]-aver_input),2);
    	}
    }
    for(d in data_output_quarter){
    	if(data_output_quarter[d] >= 0 && data_output_quarter[d] != null){
    		variance_output += (Math.pow((data_output_quarter[d]-aver_output),2));
    	}
    }
    variance_input = variance_input.toFixed(4);
    variance_output = variance_output.toFixed(4);
    $("#aver_input").text(aver_input);
    $("#aver_output").text(aver_output);
    $("#variance_input").text(variance_input);
    $("#variance_output").text(variance_output);
}
$(function () {
     chart = new Highcharts.Chart('container_top', {
    	 credits: {
             enabled:false
		},
        title: {
            text: null,
            x: -20
        },

        subtitle: {
        	 text: "红色数据点表示在税收额平均值之下的季度",
             floating: true,
             align: 'left',
             x: 530,
             y: 370,
             useHTML: true
        },
        xAxis: {
            
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
     $("#year4quarter").attr("checked","checked");
     $.ajax({
 	    async: true,
 	    type: "post",        
 	    dataType: "json",    
 	    url: "analyze_quarter_1_other.action",
 	    success: function (msg) {
 	        var obj = eval(msg);
 	        data_difference_quarter = obj["data_difference_quarter"];
 	        data_input_quarter = obj["data_input_quarter"];
 	        data_output_quarter = obj["data_output_quarter"];
 	        var data_quarters = obj["data_quarters"];
 	        calculate();
 	        var rangeValue = obj["dvalue_double"];
 	        var initValue = ""+rangeValue[1]+","+rangeValue[0];
 	        $('#rangeValue').jRange('setValue', initValue);
 	        change();
 	        chart.series[0].setData(data_difference_quarter);
 	        change_aver_color();
 	        chart.xAxis[0].setCategories(data_quarters);
 	    }
 	});
 
   
});

//发送异步请求近四季度的数据
$(function () {
    $("#year4quarter").click(function () {
        $.ajax({
            async: true,
            type: "post",        
            dataType: "json",    
            url: "analyze_quarter_1_other.action",
            success: function (msg) {
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        var data_quarters = obj["data_quarters"];
     	        calculate();
     	        chart.series[0].setData(data_difference_quarter);
     	        change_aver_color();
     	        chart.xAxis[0].setCategories(data_quarters);
     	        change();
            }
        });
    });
});
//发送异步请2017年数据
$(function () {
    $("#year2017").click(function () {
        $.ajax({
            async: true,
            data: {y_quarter_1:$("#year2017").val()},
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "analyze_quarter_1.action",
            success: function (msg) {
            	var obj = eval(msg);
     	        data_difference_quarter = obj["data_difference_quarter"];
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        calculate();
     	        chart.series[0].setData(data_difference_quarter);
     	        change_aver_color();
     	        chart.xAxis[0].setCategories(['第一季度', '第二季度', '第三季度', '第四季度']);
     	        change();
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
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        calculate();
     	        chart.series[0].setData(data_difference_quarter);
     	        change_aver_color();
     	        chart.xAxis[0].setCategories(['第一季度', '第二季度', '第三季度', '第四季度']);
     	        change();
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
     	        data_input_quarter = obj["data_input_quarter"];
     	        data_output_quarter = obj["data_output_quarter"];
     	        calculate();
     	        chart.series[0].setData(data_difference_quarter);
     	        change_aver_color();
     	        chart.xAxis[0].setCategories(['第一季度', '第二季度', '第三季度', '第四季度']);
     	        change();
            }
        });
    });
});


//改变超出范围的颜色
function change(){
	var aa = $("#rangeValue").val();
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

//改变进项和销项低于平均值的颜色
function change_aver_color(){
	var newData_input_quarter = [];
	var newData_output_quarter = [];
	for(var i=0;i<data_input_quarter.length;i++){
		if(data_input_quarter[i]<aver_input){
			var o = {};
			o.y = data_input_quarter[i];
			o.color = '#BF0B23';
			newData_input_quarter[i] = o;
		}else{
			var o1 = {};
			o1.y = data_input_quarter[i];
			o1.color = '#2B908F';
			newData_input_quarter[i] = o1;
		}
	}
	for(var i=0;i<data_output_quarter.length;i++){
		if(data_output_quarter[i]<aver_output){
			var obj = new Object();
			obj.y=data_output_quarter[i];
			obj.color = '#BF0B23';
			newData_output_quarter[i] = obj;
		}else{
			var obj1 = new Object();
			obj1.y=data_output_quarter[i];
			obj1.color = '#90EE7E';
			newData_output_quarter[i] = obj1;
		}
	}
	chart.series[1].update({
		data: newData_input_quarter,
});
	chart.series[2].update({
		data: newData_output_quarter,
});
	
}

//使用jrange
$('#rangeValue').jRange({
    from: -20,
    to: 250,
    step: 20,
    scale: [-20,20,60,100,140,180,220,250],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change,
});


