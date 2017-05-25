/**
 * 月份同比
 */
$(function () {
    $('#container_fourth').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '产品较去年同比分析'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        //去除右下角水印
        credits: {
			enabled:false
		},
        xAxis: {
            categories: ['鱼肉罐头','猪肉罐头','鸡肉罐头'],
            crosshair: true,
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            },
            title: {
                text: '产品',
                align: 'high',
            },
        },
        yAxis: {
            min: 0,
            title: {
                text: '税额/万元',
                align: 'high',
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} 万元</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '去年五月',
            data: [49.9, 71.5, 106.4],
        },{
        	name: '今年五月',
            data: [83.6, 78.8, 98.5]
        }]
    });
});
