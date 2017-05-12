/**
 *  同一个月不同产品的销量
 */
var chart = new Highcharts.Chart('monthOutProduct',{
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '五月产品销量'
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '产品销量',
            data: [
                ['猪肉罐头',   40.2],
                ['鸡肉罐头',       10.8],
                {
                    name: '鱼肉罐头',
                    y: 48.5,
                    sliced: true,
                    selected: true
                },
               
                ['其他',   0.5]
            ]
        }]
    });