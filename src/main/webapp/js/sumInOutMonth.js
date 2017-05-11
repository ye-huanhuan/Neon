/**
 * 进销项总和对比
 */
	//运用构造函数式
     var chart = new Highcharts.Chart('container_top', {
    	
        title: {
            text: '季度分析表',
            x: -20
        },

        subtitle: {

            text: '数据来源: 财务部',

            x: -20
        },
        xAxis: {
            categories: ['第一月', '第二月', '第三月', '第四月', '第五月', '第六月', '第七月', '第八月', '第九月', '第十月', '第十一月', '第十二月'],
            title: {
                text: '月份/月',
                align: 'high',
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
            }]
        },
        tooltip: {
        	//数据后缀
            valueSuffix: '万'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [
			{
   		 		type: 'column',
    			name: '进销差值',
    			data: [-3, 1, 2, -4, 2, 4, 2, 0, -3, 2, 1, 5],
				
				},
             {
			type: 'spline',
            name: '进项金额',
            data: [16, 15, 16, 15, 11, 13, 17, 13, 13, 16, 14, 12]
        }, {
        	type: 'spline',
        	name: '销项金额',
            data: [13, 16, 18, 11, 13, 17, 19, 13, 16, 18, 15, 17]
        }
        ]
   });