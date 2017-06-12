/**
 * 销项税分布情况
 */
var sum_out = 21;
$(function () {
    $('#container_second_1').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: '产品销项税额分布情况'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        xAxis: {
            categories: ['0-4','4-8', '8-12' , '12-16', '16+'],
            title: {
                text: '销项税范围/万元',
                align: 'high'
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
                }
            }
        },
        tooltip: {
            formatter: function() {
                var percent = 0;
                var point = this.point;
                percent = (point.y/sum_out)*100;
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
            name: '销项税个数',
            data: [3, 4, 10, 2, 2]
        }]
    });
});
