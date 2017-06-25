/**
 *  每个产品的季度销售量
 */
 var chart1;
 var productName;
 var productValue;
 var options;
 var data_quarter;
 $(function () {
   options = {
	credits: {
		enabled:false
	},	   
     chart: {
       renderTo: 'container_second',
       type: 'line',
       marginRight: 130,
     },
     title: {
       text: null,
       x: -20 //center
     },
     subtitle: {
         text: null,
         x: -20
     },
     xAxis: {
       categories: ['第一季度', '第二季度', '第三季度', '第四季度'],
       title: {
           text: '年份/年',
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
       //修改y轴值字体的大小
       labels: {
           style: {
               fontSize:'14px',
               fontFamily:'微软雅黑'
           }
       }
     },
     tooltip: {
       valueSuffix: '万元',
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
       verticalAlign: 'top',
       x: -10,
       y: 100,
       borderWidth: 0
     },
     series: []
   }
   options.series = new Array();
   
   	//初始化chart1
   $("#second_year_4quarter").attr("checked","checked");
    $.ajax({
  	    async: true,
  	    type: "post",        //type：(string)请求方式，POST或GET
  	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
  	    url: "analyze_quarter_2_other.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
  	    success: function (msg) {
  	    	var obj = eval(msg);
  	    	productName = obj["productName"];
  	    	productValue = obj["productVlaue"];
  	    	data_quarter = obj["data_quarters"];
	        reset();
  	    }
   });
   
});
//异步请求近四个季度数据
 $(function () {
	    $("#second_year_4quarter").click(function () {
	    	$.ajax({
	      	    async: true,
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2_other.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	      	    	data_quarter = obj["data_quarters"];
	    	        reset();
	      	    }
	       });
	    });
	});
 //异步请求2017年数据
 $(function () {
	    $("#second_year_2017").click(function () {
	    	$.ajax({
	      	    async: true,
	      	  	data: {y_quarter_2:$("#second_year_2017").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	    	        data_quarter = ['第一季度', '第二季度', '第三季度', '第四季度'];
	    	        reset();
	      	    }
	       });
	    });
	});
//异步请求2016年数据
 $(function () {
	    $("#second_year_2016").click(function () {
	    	$.ajax({
	      	    async: true,
	      	  	data: {y_quarter_2:$("#second_year_2016").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	    	        data_quarter = ['第一季度', '第二季度', '第三季度', '第四季度'];
	    	        reset();
	      	    }
	       });
	    });
	});
//异步请求2015年数据
 $(function () {
	    $("#second_year_2015").click(function () {
	    	$.ajax({
	      	    async: true,
	      	  	data: {y_quarter_2:$("#second_year_2015").val()},
	      	    type: "post",        //type：(string)请求方式，POST或GET
	      	    dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
	      	    url: "analyze_quarter_2.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
	      	    success: function (msg) {
	      	    	var obj = eval(msg);
	      	    	productName = obj["productName"];
	      	    	productValue = obj["productVlaue"];
	    	        data_quarter = ['第一季度', '第二季度', '第三季度', '第四季度'];
	      	    	reset();
	    	        
	      	    }
	       });
	    });
	});
 
//使用jrange
 $('#second_rangeValue').jRange({
     from: 0,
     to: 120,
     step: 1,
     scale: [0,20,40,60,80,100,120],
     format: '%s',
     width: 300,
     showLabels: true,
     isRange : true,
     ondragend : disappear
 });
 
//使rangevalue之下的值消失
 function disappear(){
		var aa = $("#second_rangeValue").val();
		var subaa = aa.split(",");
		var min = subaa[0];
		var max = subaa[1];
		var newProductValue = new Array();  //为了不覆盖掉原本的值
		for(var n=0;n<productName.length;n++){      
			newProductValue[n] = new Array();
		}
		for(var i=0;i<productName.length;i++){
	        options.series[i] = new Object();
	        for(var j=0;j<productValue[i].length;j++){
	        	if(productValue[i][j]<min || productValue[i][j]>max){
	        		newProductValue[i][j] = null;
	        	}else{
	        		newProductValue[i][j] = productValue[i][j];
	        	}
	        }
	        options.series[i].name = productName[i];
        	options.series[i].data = newProductValue[i];
  	    	}
		options.xAxis.categories = data_quarter;
        chart1 = new Highcharts.Chart(options);
	}
 
 //重置
 function reset(){
	 for(var i=0;i<productName.length;i++){
		 options.series[i] = new Object();
		 options.series[i].data = productValue[i];
		 options.series[i].name = productName[i];
		 
	 }
	options.series.length = productName.length;
	options.xAxis.categories = data_quarter;
    chart1 = new Highcharts.Chart(options);
 }
 
 
 $(function () {
	    $("#second_button").click(function () {
	    	reset();
	    });
	});	    	
	    
