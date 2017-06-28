// 当月目标 

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
        var subtitle = {
       	 text: "仪表右侧为目标，中间为当前税额进度",
            floating: true,
            align: 'left',
            x: 108,
            y: 180,
            useHTML: true
       };
        var yAxis = {
            stops: [
                [0.3, '#DF5353'], // red
                [0.6, '#DDDF0D'], // yellow
                [0.9, '#55BF3B'] // green
            ],
            lineWidth: 0,
            tickPixelInterval: 50,
            max: 11,
            min: 0,
            title: {
                text: '当月目标',
                y: -70,
                style: {
                    fontSize:'16px',
                    fontFamily:'微软雅黑'
                },
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                },
                y: 16,
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
            name: '当月目标',
            data: [5],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                '<span style="font-size:12px;color:silver">万元</span></div>'
            },
            tooltip: {
                valueSuffix: ' 万元'
            }
        }];
        
        
        var chart1 = {
                type: 'solidgauge'
            };
            var title1 = null;

            var pane1 = {
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

            var tooltip1 = {
                enabled: false
            };
            var yAxis1 = {
                stops: [
                    [0.3, '#DF5353'], // red
                    [0.6, '#DDDF0D'], // yellow
                    [0.9, '#55BF3B'] // green
                ],
                lineWidth: 0,
                tickPixelInterval: 50,
                max: 40,
                min: 0,
                title: {
                    text: '当季目标',
                    y: -70,
                    style: {
                        fontSize:'16px',
                        fontFamily:'微软雅黑'
                    },
                },
                labels: {
                    style: {
                        fontSize:'14px',
                        fontFamily:'微软雅黑'
                    },
                    y: 16,
                }
            };

            var plotOptions1 = {
                solidgauge: {
                    dataLabels: {
                        y: 10,
                        borderWidth: 0,
                        useHTML: true
                    }
                }
            };

            var credits1 = {
                enabled: false
            };
            var exporting1 = {  
            	enabled:false //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示  
            };  
            var series1 = [{
                name: '当季目标',
                data: [28],
                dataLabels: {
                    format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                    ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                    '<span style="font-size:12px;color:silver">万元</span></div>'
                },
                tooltip: {
                    valueSuffix: ' 万元'
                }
            }];
            
            
            var chart2 = {
                    type: 'solidgauge'
                };
                var title2 = null;

                var pane2 = {
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

                var tooltip2 = {
                    enabled: false
                };

                // the value axis
                var yAxis2 = {
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

                var plotOptions2 = {
                    solidgauge: {
                        dataLabels: {
                            y: 5,
                            borderWidth: 0,
                            useHTML: true
                        }
                    }
                };

                var credits2 = {
                    enabled: false
                };

                var exporting2 = {  
                    enabled:false //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示  
                }; 
                var series2 = [{
                    name: '当年目标',
                    data: [60],
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
                        
                        //月份目标数据
                        var data_target = obj["data_target"];
                        yAxis["max"] = data_target[0];
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
                        json.subtitle = subtitle;
                        $('#container-month').highcharts(json);
                        //季度目标数据
                        var data_target1 = obj["data_target"];
                        yAxis1["max"] = data_target1[1];
                        var json1 = {};
                        json1.chart = chart1;
                        json1.title = title1;
                        json1.pane = pane1;
                        json1.tooltip = tooltip1;
                        json1.yAxis = yAxis1;
                        json1.credits = credits1;
                        json1.series = series1;
                        json1.plotOptions = plotOptions1;
                        json1.exporting = exporting1;
                        json1.subtitle = subtitle;
                        $('#container-quarter').highcharts(json1);
                        //年份目标数据
                        var data_target2 = obj["data_target"];
                        yAxis2["max"] = data_target2[2];
                        var json2 = {};
                        json2.chart = chart2;
                        json2.title = title2;
                        json2.pane = pane2;
                        json2.tooltip = tooltip2;
                        json2.yAxis = yAxis2;
                        json2.credits = credits2;
                        json2.series = series2;
                        json2.plotOptions = plotOptions2;
                        json2.exporting = exporting2;
                        json2.subtitle = subtitle;
                        $('#container-year').highcharts(json2);
                    }
                });
    });
