/**
 * 季度进销项分析
 */
$(function () {
//	chart = new Highcharts.Chart('container_second', {
        var chart = {
            type: 'scatter',
            zoomType: 'xy'
        };
        var credits = {
     		enabled:false
     	};
        var title = {
            text: '今年进销项分布图'
        };
        var subtitle = {
            text: '数据来源: 财务部'
        };
        var xAxis =  {
            title: {
                enabled: true,
                text: '进项/万元',
                align: 'high',
                zIndex: 6
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true,
            
        };
       var yAxis = {
            title: {
                text: '销项/万元',
                align: 'high'
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                },
                zIndex: 6
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            
        };
//        var legend = {
//            layout: 'vertical',
//            align: 'left',
//            verticalAlign: 'top',
//            x: 100,
//            y: 70,
//            floating: true,
//            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
//            borderWidth: 1
//        };
       var legend = {
           layout: 'vertical',
           align: 'left',
           verticalAlign: 'top',
           y: 70,
           x: 100,
           borderWidth: 1,
           borderRadius: 0,
           title: {
               text: '::拖拽我',
               style: {
            	   fontSize:'14px',
                   fontFamily:'微软雅黑',
                   color: 'white'
               }
           },
           
           backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
           floating: true,
           draggable: true,
           zIndex: 20
       };
        var plotOptions = {
            scatter: {
                marker: {
                    radius: 5,
                    states: {
                        hover: {
                            enabled: true,
                            lineColor: 'rgb(100,100,100)'
                        }
                    }
                },
                states: {
                    hover: {
                        marker: {
                            enabled: false
                        }
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:14px">{series.name}</span><br>',
                    pointFormat: '<span style="font-size:14px">{point.x} 万元, {point.y} 万元</span>',
                }
            }
        };
       
//    });
    $.ajax({
 	    async: true,
 	    type: "post",        
 	    dataType: "json",    
 	    url: "analyze_tax_1.action",
 	    success: function (msg) {
 	        var obj = eval(msg);
 	        var data_items = obj["items"];
 	        var data_in_out = obj["data_in_out"];
 	        var serise = new Array(data_items.length);
 	        
 	        for(var i=0;i<data_items.length;i++){
 	        	serise[i] = {};
 	        	serise[i].name = data_items[i];
 	        	serise[i].data = data_in_out[i];
 	        }
 	        var setting = {};
 	        setting.chart = chart;
 	        setting.credits = credits;
 	        setting.title = title;
 	        setting.subtitle = subtitle;
 	        setting.xAxis = xAxis;
 	        setting.yAxis = yAxis;
 	        setting.legend = legend;
 	        setting.plotOptions = plotOptions;
 	        setting.series = serise;
 	        var chart1 = new Highcharts.Chart('container_second',setting);
 	    }
 	});
});
