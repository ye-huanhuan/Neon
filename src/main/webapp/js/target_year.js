/**
 * 年度目标
 */
$(function () {
        var chart = {
            type: 'solidgauge'
        };
        var title = null;

        var pane = {
            center: ['50%', '85%'],
            size: '140%',
            startAngle: -90,
            endAngle: 90,
            background: {
                backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
                innerRadius: '60%',
                outerRadius: '100%',
                shape: 'arc'
            }
        };

        var tooltip = {
            enabled: false
        };

        // the value axis
        var yAxis = {
            stops: [
                [0.3, '#DF5353'], // red
                [0.6, '#DDDF0D'], // yellow
                [0.9, '#55BF3B'] // green
            ],
            lineWidth: 0,
            tickPixelInterval: 50,
            labels: {
                y: 16,
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                },
            },
            min: 0,
            max: 2000,
            title: {
                text: '当年目标',
                y: -70,
                style: {
                    fontSize:'16px',
                    fontFamily:'微软雅黑'
                },
            }
        };

        var plotOptions = {
            solidgauge: {
                dataLabels: {
                    y: 5,
                    borderWidth: 0,
                    useHTML: true
                }
            }
        };

        var credits = {
            enabled: false
        };

        var exporting = {  
            enabled:false //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示  
        }; 
        var series = [{
            name: '当年目标',
            data: [40],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                '<span style="font-size:12px;color:silver">万元</span></div>'
            },
            tooltip: {
                valueSuffix: ' 万元'
            }
        }];

        $.ajax({
            async: true,
            type: "post",        //type：(string)请求方式，POST或GET
            dataType: "json",    //dataType：(string)预期返回的数据类型。xml,html,json,text等
            url: "home_detail.action",//url：(string)发送请求的地址，可以是服务器页面也可以是WebService动作。
            success: function (msg) {
                var obj = eval(msg);
                alert("year");
                var data_target = obj["data_target"];
                yAxis["max"] = data_target[2];
                var json = {};
                json.chart = chart;
                json.title = title;
                json.pane = pane;
                json.tooltip = tooltip;
                json.yAxis = yAxis;
                json.credits = credits;
                json.series = series;
                json.plotOptions = plotOptions;
                json.exporting = exporting;
                $('#container-year').highcharts(json);
            }
        });
 });