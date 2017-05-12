/**
 *  每个产品的月销售量
 */
var chart = new Highcharts.Chart('container_product', {
    title: {
        text: '产品分析表',
        x: -20
    },
    subtitle: {
        text: '数据来源: Neon.com',
        x: -20
    },
    xAxis: {
        categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
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
        }]
    },
    tooltip: {
        valueSuffix: '万元'
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle',
        borderWidth: 0
    },
    series: [{
        name: '猪肉罐头',
        data: [12.0, 10.0, 15.0, 17.0, 22.0, 19.0, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
    }, {
        name: '鸡肉罐头',
        data: [8, 0.8, 0.4, 0.3, 10.0, 5.0, 7.8, 5.1, 3.1, 2.0, 8.6, 2.5]
    }, {
        name: '鱼肉罐头',
        data: [27.0, 25.0, 33.0, 30.0, 38.0, 17.0, 18.0, 17.0, 14.3, 9.0, 18.0, 29.0]
    }, ]
});