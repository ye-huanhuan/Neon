/**
 * 进项税分布情况
 */
var sum_in = 0;
var chart1;
$(function () {
	chart1 = new Highcharts.Chart('container_second_2', {
        chart: {
            type: 'bar'
        },
        title: {
            text: '产品进项税额分布情况'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        xAxis: {
            categories: ['0-4','4-8', '8-12' , '12-16', '16+'],
            title: {
                text: '进项税范围/万元',
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
            min: 0,
            title: {
                text: '月份数/个',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        tooltip: {
            valueSuffix: ' 个'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true,
                    allowOverlap: true,
                    style: {
                    	fontSize: '14px',
                    	fontFamily:'微软雅黑'
                    }
                },
            },
            
        },
        tooltip: {
            formatter: function() {
                var percent = 0;
                var point = this.point;
                percent = (point.y/sum_in)*100;
                percent = percent.toFixed(2);
                return this.x + '<br>' + this.series.name + '占比' + ':' + percent + '%';
            },
            style: {                      // 文字内容相关样式
                color: "#F0F8FF",
                fontSize: "14px",
                fontWeight: "blod",
                fontFamily: "微软雅黑"
            }
        },
        legend: {
            enabled: false
        },
        credits: {
            enabled: false
        },
        series: [{
            name: '进项税个数',
            data: [3, 4, 10, 4, 2]
        }]
    });
    $.ajax({
 	    async: true,
 	    type: "post",        
 	    dataType: "json",    
 	    url: "analyze_distribution.action",
 	    success: function (msg) {
 	        var obj = eval(msg);
 	        var group_in = obj["group_in"];
 	        var times_in = obj["times_in"];
 	        for(var j=0;j<times_in.length;j++){
 	        	sum_in+=times_in[j];
 	        }
 	       chart1.series[0].update({
 	    	   data: times_in,
 	       });
 	      chart1.xAxis[0].update({
 	    	 categories: group_in,
 	 	  });
 	    }
 	});
});
