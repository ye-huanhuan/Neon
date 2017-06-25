/**
 * 月份进销项总和对比
 */

var data_difference;
var data_input;
var data_output;
var chart;
var aver_input = 0,aver_output = 0;
//设置虚线的范围
var zone;
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
    variance_input = variance_input.toFixed(4);
    variance_output = variance_output.toFixed(4);
    $("#aver_input").text(aver_input);
    $("#aver_output").text(aver_output);
    $("#variance_input").text(variance_input);
    $("#variance_output").text(variance_output);
}

var columnColor = ['#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7', '#058DC7','#058DC7','#058DC7','#058DC7'];
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
            text: null,
            x: -20
        },
        xAxis: {
            title: {
                text: '月份/月',
                align: 'high',
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            },
            
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
        	zoneAxis: 'x',
            zones: zone
        }
        ]
   });
//初始化highchart
     $("#year-12month").attr("checked","checked");
     $.ajax({
 	    async: true,
 	    type: "post",        
 	    dataType: "json",    
 	    url: "analyze_month_1_other.action",
 	    success: function (msg) {
 	        var obj = eval(msg);
 	        data_difference = obj["data_difference"];
 	        data_input = obj["data_input"];
 	        data_output = obj["data_output"];
 	        var data_month = obj["data_month"];
 	        calculate();
 	        var rangeValue = obj["dvalue_double"];
 	        var initValue = ""+rangeValue[1]+","+rangeValue[0];
 	        $('#rangeValue').jRange('setValue', initValue);
 	        change();
 	        change_aver_color();
 	        chart.series[0].setData(data_difference);
 	        chart.xAxis[0].setCategories(data_month);
 	        //设置虚线的范围
 	        zone = data_output.length - 2;
	 	    var obj = [{
				    value: zone,
			 }, {
			     dashStyle: 'dot'
			 }];
            chart.series[2].update({
           	zones: obj,
            });
 	    }
 	});
});

//发送异步请求近十二个月的数据
$(function () {
    $("#year-12month").click(function () {
        $.ajax({
            async: true,
            type: "post",        
            dataType: "json",    
            url: "analyze_month_1_other.action",
            success: function (msg) {
            	var obj = eval(msg);
     	        data_difference = obj["data_difference"];
     	        data_input = obj["data_input"];
     	        data_output = obj["data_output"];
     	        var data_month = obj["data_month"];
     	        calculate();
     	        change_aver_color();
    	        chart.series[0].setData(data_difference);
     	        chart.xAxis[0].setCategories(data_month);
     	        change();
     	        //设置虚线的范围
     	        zone = data_output.length - 2;
     	        var obj = [{
				    value: zone,
			    }, {
			        dashStyle: 'dot'
			    }];
                chart.series[2].update({
               	zones: obj,
                });
            }
        });
    });
});
//发送异步请求2016年数据
$(function () {
    $("#year-2016").click(
    		function  () {
    		    $.ajax({
    		        async: true,
    		        data: {y:$("#year-2016").val()},
    		        type: "post",        
    		        dataType: "json",    
    		        url: "analyze_month_1.action",
    		        success: function (msg) {
    		            var obj = eval(msg);
    		            data_difference = obj["data_difference"];
    		            data_input = obj["data_input"];
    		            data_output = obj["data_output"];
    		            calculate();
    		            change_aver_color();
    		 	        chart.series[0].setData(data_difference);
    		            chart.xAxis[0].setCategories(['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月']);
    		            change();
    		            zone = data_output.length-1;
    		            var obj = [{
    					    value: zone,
    				    }, {
    				        dashStyle: 'dot'
    				    }];
    	                chart.series[2].update({
    	                	zones: obj,
    	                });
    		        }
    		    });
    		}
    );
});
//发送异步请求2017年数据
$(function () {
    $("#year-2017").click(function () {
    	
        $.ajax({
            async: true,
            data: {y:$("#year-2017").val()},
            type: "post",        
            dataType: "json",    
            url: "analyze_month_1.action",
            success: function (msg) {
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
                calculate();
                change_aver_color();
     	        chart.series[0].setData(data_difference);
     	        chart.xAxis[0].setCategories(['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月']);
                change();
                zone = data_output.length-2;
                var obj = [{
				    value: zone,
			    }, {
			        dashStyle: 'dot'
			    }];
                chart.series[2].update({
                	zones: obj,
                });
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
            type: "post",        
            dataType: "json",    
            url: "analyze_month_1.action",
            success: function (msg) {
                var obj = eval(msg);
                data_difference = obj["data_difference"];
                data_input = obj["data_input"];
                data_output = obj["data_output"];
                calculate();
                change_aver_color();
     	        chart.series[0].setData(data_difference);
                chart.xAxis[0].setCategories(['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月']);
                change();
                zone = data_output.length-1;
                var obj = [{
				    value: zone,
			    }, {
			        dashStyle: 'dot'
			    }];
                chart.series[2].update({
                	zones: obj,
                });
                
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
	for(var j=0;j<data_output.length;j++){
		if(data_output[j]<aver_output){
			var obj1 = {};
			obj1.y=data_output[j];
			obj1.color = '#BF0B23';
			newData_output[j] = obj1;
		}else{
			var obj2 = {};
			obj2.y=data_output[j];
			obj2.color = '#90EE7E';
			newData_output[j] = obj2;
			
		}
	}
	 
	 chart.series[1].update({
 		data: newData_input,
 });
 	chart.series[2].update({
 		data: newData_output,
 });
 	
}

//使用jrange
$('#rangeValue').jRange({
    from: -20,
    to: 60,
    step: 5,
    scale: [-20,0,20,40,60],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    ondragend : change
});
