/**
 *  每个产品的月销售量
 */
var chart = new Highcharts.Chart('container_second', {
    title: {
        text: '产品分析表',
        x: -20
    },
    subtitle: {
        text: '数据来源: 财务部',
        x: -20
    },
    xAxis: {
        categories: ['第一季度', '第二季度', '第三季度', '第四季度']
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
        data: [12.0, 10.0, 15.0, 17.0]
    }, {
        name: '鸡肉罐头',
        data: [8, 0.8, 0.4, 0.3]
    }, {
        name: '鱼肉罐头',
        data: [27.0, 25.0, 33.0, 30.0]
    }, ]
});