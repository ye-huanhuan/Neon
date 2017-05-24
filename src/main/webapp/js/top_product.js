/**
 * top3
 */
$(function () {
    $('#container_third_2').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: '2017产品销售情况'
        },
        subtitle: {
            text: '数据来源: 财务部'
        },
        xAxis: {
            categories: ['鱼肉罐头', '猪肉罐头', '鸡肉罐头'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '税收额/万元',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' 万元'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true,
                    allowOverlap: true
                }
            }
        },
        credits: {
            enabled: false
        },
        series: [{
            data: [100,80,60]
        }]
    });
});
