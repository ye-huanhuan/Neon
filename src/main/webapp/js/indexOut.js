/*
 * 首页销项数据
 */
$(document).ready(function() {
        var chart = {
            zoomType: 'x'
        };
        var credits =  {
            enabled:false
    	};
        var title = {
            text: '2015年1月1日至今每日的销项总额'
        };
        var subtitle = {
            text: '拖动x轴能缩放图表'
        };
        var xAxis = {
        		title: {
                    text: '时间/天',
                    align: 'high',
                },
            type: 'datetime',
            minRange: 15 * 24 * 3600000, // 15 天
            dateTimeLabelFormats: {      //格式化时间
                millisecond: '%H:%M:%S.%L',
                second: '%H:%M:%S',
                minute: '%H:%M',
                hour: '%H:%M',
                day: '%m-%d',
                week: '%m-%d',
                month: '%Y-%m',
                year: '%Y'
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            },
        };
        var yAxis = {
            title: {
                text: '销项税',
                align: 'high',
            },
            labels: {
                style: {
                    fontSize:'14px',
                    fontFamily:'微软雅黑'
                }
            }
        };
        var legend = {
            enabled: false,
            
        };
        var tooltip = {
            dateTimeLabelFormats: {
                millisecond: '%H:%M:%S.%L',
                second: '%H:%M:%S',
                minute: '%H:%M',
                hour: '%H:%M',
                day: '%Y-%m-%d',
                week: '%m-%d',
                month: '%Y-%m',
                year: '%Y',
            },
        	valueSuffix: '万',
        	headerFormat: '<span style="font-size:14px">{point.key}</span><br>',
        	style: {                      // 文字内容相关样式
                color: "#F0F8FF",
                fontSize: "14px",
                fontWeight: "blod",
                fontFamily: "微软雅黑"
            }
        };
        var plotOptions = {
            area: {
                fillColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                    ]
                },
                marker: {
                    radius: 2
                },
                lineWidth: 1,
                states: {
                    hover: {
                        lineWidth: 1
                    }
                },
                threshold: null
            }
        };
        var series= [{
            type: 'area',
            name: '销项税',
            pointInterval: 24 * 3600 * 1000,
            pointStart: Date.UTC(2015, 0, 1),
            data: [
                   1.8446, 1.8445, 1.8444, 1.8451,    1.8418, 1.8264,    1.8258, 1.8232,    1.8233, 1.8258,
                   1.8283, 1.8278, 1.8256, 1.8292,    1.8239, 1.8239,    1.8245, 1.8265,    1.8261, 1.8269,
                   1.8273, 1.8244, 1.8244, 1.8172,    1.8139, 1.8146,    1.8164, 1.82,    1.8269, 1.8269,
                   1.8269, 1.8258, 1.8247, 1.8286,    1.8289, 1.8316,    1.832, 1.8333,    1.8352, 1.8357,
                   1.8355, 1.8354, 1.8413, 1.8413,    1.8416, 1.8413,    1.8396, 1.8418,    1.8419, 1.8384,
                   1.8386, 1.8372, 1.839, 1.84, 1.8389, 1.84, 1.8423, 1.8423, 1.8435, 1.8422,
                   1.838, 1.8373, 1.8316, 1.8313,    1.8313, 1.8312,    1.8369, 1.84, 1.8385, 1.84,
                   1.8411, 1.8412, 1.8381, 1.8351,    1.8314, 1.8273,    1.8213, 1.8217,    1.8217, 1.8215,
                   1.8242, 1.8273, 1.8311, 1.8346,    1.8312, 1.8312,    1.8312, 1.8316,    1.8327, 1.8282,
                   1.824, 1.8255, 1.8256, 1.8273, 1.8219, 1.8151, 1.8149, 1.8213, 1.8273, 1.8273,
                   1.8261, 1.8252, 1.824, 1.8262, 1.8258, 1.8261, 1.826, 1.8199, 1.8153, 1.8197,
                   1.8111, 1.8119, 1.8117, 1.8115,    1.8184, 1.8169,    1.8147, 1.8123,    1.7965, 1.7919,
                   1.7921, 1.7922, 1.7934, 1.7918,    1.7915, 1.787, 1.7861, 1.7861, 1.7853, 1.7867,
                   1.7827, 1.7834, 1.7766, 1.7751, 1.7739, 1.7767, 1.7812, 1.7788, 1.7828, 1.7816,
                   1.7829, 1.783, 1.7829, 1.7781, 1.7811, 1.7831, 1.7826, 1.7855, 1.7855, 1.7845,
                   1.7798, 1.7777, 1.7822, 1.7785, 1.7744, 1.7743, 1.7726, 1.7766, 1.7816, 1.785,
                   1.7917, 1.7912, 1.7913, 1.7931, 1.7952, 1.7951, 1.7928, 1.791, 1.7913, 1.7912,
                   1.7941, 1.7953, 1.7921, 1.7919, 1.7968, 1.7999, 1.7999, 1.7974, 1.7942, 1.796,
                   1.7969, 1.7862, 1.7821, 1.7821, 1.7821, 1.7811, 1.7833, 1.7849, 1.7819, 1.7819,
                   1.7819, 1.7827, 1.7848, 1.785, 1.7873, 1.7894, 1.7917, 1.7919, 1.7947, 1.7987,
                   1.799, 1.7927, 1.79, 1.7878, 1.7878, 1.7917, 1.7922, 1.7937, 1.786, 1.787,
                   1.7838, 1.7838, 1.7837, 1.7836, 1.7816, 1.7825, 1.7798, 1.777, 1.777, 1.7772,
                   1.7793, 1.7788, 1.7785, 1.7832, 1.7865, 1.7865, 1.7853, 1.7847, 1.7819, 1.778,
                   1.7799, 1.78, 1.7811, 1.7765, 1.7785, 1.7811, 1.782, 1.7835, 1.7845, 1.7844,
                   1.782, 1.7811, 1.7795, 1.7794, 1.7816, 1.7794, 1.7794, 1.7778, 1.7793, 1.7818,
                   1.7824, 1.787, 1.7894, 1.7893, 1.7882, 1.7871, 1.7882, 1.7871, 1.7878, 1.79,
                   1.7911, 1.7898, 1.7879, 1.7886, 1.7858, 1.7814, 1.7825, 1.7826, 1.7826, 1.786,
                   1.7878, 1.7868, 1.7883, 1.7893, 1.7892, 1.7876, 1.785, 1.787, 1.7873, 1.7911,
                   1.7936, 1.7939, 1.7938, 1.7956, 1.7975, 1.7978, 1.7972, 1.7995, 1.7995, 1.7994,
                   1.7976, 1.7977, 1.796, 1.7922, 1.7928, 1.7929, 1.7948, 1.797, 1.7953, 1.7917,
                   1.7872, 1.7852, 1.7852, 1.786, 1.7862, 1.7836, 1.7837, 1.784, 1.7867, 1.7867,
                   1.7869, 1.7837, 1.7827, 1.7825, 1.7779, 1.7791, 1.779, 1.7787, 1.78, 1.7817,
                   1.7813, 1.7817, 1.7799, 1.7799, 1.7795, 1.7811, 1.7765, 1.7725, 1.7683, 1.7641,
                   1.7639, 1.7616, 1.7618, 1.759, 1.7582, 1.7539, 1.75, 1.75, 1.7517, 1.7515,
                   1.7516, 1.7522, 1.7531, 1.7577, 1.7577, 1.7582, 1.755, 1.7542, 1.7576, 1.7616,
                   1.7648, 1.7648, 1.7641, 1.7614, 1.757, 1.7587, 1.7588, 1.762, 1.762, 1.7617,
                   1.7618, 1.7615, 1.7612, 1.7596, 1.758, 1.758, 1.758, 1.7547, 1.7549, 1.7613,
                   1.7655, 1.7693, 1.7694, 1.7688, 1.7678, 1.7718, 1.7727, 1.7749, 1.7741, 1.7741,
                   1.7732, 1.7727, 1.7737, 1.7724, 1.7712, 1.772, 1.7721, 1.7717, 1.7714, 1.769,
                   1.7711, 1.774, 1.7745, 1.7745, 1.774, 1.7716, 1.7713, 1.7678, 1.7688, 1.7718,
                   1.7718, 1.7728, 1.7729, 1.7698, 1.7685, 1.7681, 1.769, 1.769, 1.7698, 1.7699,
                   1.7651, 1.7613, 1.7616, 1.7614, 1.7614, 1.7617, 1.7612, 1.7611, 1.7622, 1.7615,
                   1.7598, 1.7598, 1.7592, 1.7573, 1.7566, 1.7567, 1.7591, 1.7582, 1.7585, 1.7613,
                   1.7631, 1.7615, 1.76, 1.7613, 1.7627, 1.7627, 1.7618, 1.7583, 1.7575, 1.7562,
                   1.752, 1.7512, 1.7512, 1.7517, 1.752, 1.7511, 1.748, 1.7519, 1.7531, 1.7531,
                   1.7527, 1.7498, 1.7493, 1.7514, 1.75, 1.7491, 1.7491, 1.7485, 1.7484, 1.7492,
                   1.7471, 1.7459, 1.7477, 1.7477, 1.7483, 1.7458, 1.7448, 1.743, 1.7399, 1.7395,
                   1.7395, 1.7378, 1.7382, 1.7362, 1.7355, 1.7348, 1.7361, 1.7361, 1.7365, 1.7362,
                   1.7331, 1.7339, 1.7344, 1.7327, 1.7327, 1.7336, 1.7333, 1.7359, 1.7359, 1.7372,
                   1.736, 1.736, 1.735, 1.7365, 1.7384, 1.7395, 1.7413, 1.7397, 1.7396, 1.7385,
                   1.7378, 1.7366, 1.74, 1.7411, 1.7416, 1.7415, 1.7414, 1.7431, 1.7431, 1.7438,
                   1.7443, 1.7443, 1.7443, 1.7434, 1.7429, 1.7442, 1.744, 1.7439, 1.7437, 1.7437,
                   1.7429, 1.7413, 1.7399, 1.7418, 1.7468, 1.748, 1.748, 1.749, 1.7494, 1.7522,
                   1.7515, 1.7512, 1.7472, 1.7472, 1.7462, 1.7455, 1.7449, 1.7467, 1.7458, 1.7427,
                   1.7427, 1.743, 1.7429, 1.744, 1.743, 1.7422, 1.7388, 1.7388, 1.7369, 1.7345,
                   1.7345, 1.7345, 1.7352, 1.7341, 1.7341, 1.734, 1.7324, 1.7272, 1.7264, 1.7255,
                   1.7258, 1.7258, 1.7256, 1.7257, 1.7247, 1.7243, 1.7244, 1.7235, 1.7235, 1.7235,
                   1.7235, 1.7262, 1.7288, 1.7311, 1.7337, 1.7337, 1.7324, 1.7297, 1.7317, 1.7315,
                   1.7288, 1.7263, 1.7263, 1.7242, 1.7253, 1.7264, 1.727, 1.7312, 1.7315, 1.7315,
                   1.7318, 1.7358, 1.7419, 1.7454, 1.7437, 1.7424, 1.7424, 1.7415, 1.7419, 1.7414,
                   1.7377, 1.7355, 1.7315, 1.7315, 1.732, 1.7332, 1.7346, 1.7328, 1.7323, 1.734,
                   1.734, 1.7336, 1.7351, 1.7346, 1.7321, 1.7294, 1.7266, 1.7266, 1.7254, 1.7242,
                   1.7213, 1.7197, 1.7219, 1.721, 1.721, 1.721, 1.7219, 1.7159, 1.7133, 1.7115,
                   1.7199, 1.7199, 1.7193, 1.7193, 1.7176, 1.717, 1.7149, 1.7112, 1.7111, 1.7119,
                   1.7146, 1.7163, 1.7189, 1.7177, 1.7177, 1.7177, 1.7191, 1.7118, 1.7179, 1.7153,
                   1.715, 1.7155, 1.7155, 1.7145, 1.7151, 1.7151, 1.7117, 1.7, 1.6995, 1.6994,
                   1.7114, 1.7136, 1.7121, 1.7112, 1.6967, 1.695, 1.695, 1.6939, 1.694, 1.6922,
                   1.6919, 1.6914, 1.6894, 1.6891, 1.6914, 1.689, 1.6834, 1.6823, 1.6817, 1.6815,
                   1.6815, 1.6847, 1.6859, 1.6822, 1.6827, 1.6837, 1.6823, 1.6822, 1.6822, 1.6792,
                   1.6746, 1.6735, 1.6731, 1.6742, 1.6744, 1.6739, 1.6731, 1.6761, 1.6761, 1.6785,
                   1.6818, 1.6836, 1.6823, 1.6815, 1.6793, 1.6849, 1.6833, 1.6825, 1.6825, 1.6816,
                   1.6799, 1.6813, 1.6819, 1.6868, 1.6933, 1.6933, 1.6945, 1.6944, 1.6946, 1.6964,
                   1.6965, 1.6956, 1.6956, 1.695, 1.6948, 1.6928, 1.6887, 1.6824, 1.6794, 1.6794,
                   1.6813, 1.6855, 1.6824, 1.6791, 1.6783, 1.6785, 1.6785, 1.6797, 1.68, 1.6813,
                   1.6815, 1.676, 1.677, 1.677, 1.6736, 1.6726, 1.6764, 1.6821, 1.6831, 1.6842,
                   1.6842, 1.6887, 1.6913, 1.6848, 1.6824, 1.6788, 1.6814, 1.6814, 1.6797, 1.6769,
                   1.6765, 1.6733, 1.6729, 1.6758, 1.6758, 1.675, 1.678, 1.6833, 1.6856, 1.6913,
                   1.6896, 1.6896, 1.6882, 1.6879, 1.6862, 1.6852, 1.6823, 1.6813, 1.6813, 1.6822,
                   1.6812, 1.6812, 1.6784, 1.6748, 1.6747, 1.6747, 1.6748, 1.6733, 1.665, 1.6611,
                   1.6583, 1.659, 1.659, 1.6581, 1.6578, 1.6574, 1.6532, 1.6512, 1.6514, 1.6514,
                   1.6517, 1.651, 1.6489, 1.6424, 1.6416, 1.6382, 1.6382, 1.6341, 1.6344, 1.6378,
                   1.6439, 1.6478, 1.6481, 1.6481, 1.6494, 1.6438, 1.6377, 1.6329, 1.6336, 1.6333,
                   1.6333, 1.633, 1.6371, 1.6413, 1.6396, 1.6364, 1.6356, 1.6356, 1.6368, 1.6357,
                   1.6354, 1.632, 1.6332, 1.6328, 1.6331, 1.6342, 1.6321, 1.6312, 1.6278, 1.6318,
                   1.6324, 1.6324, 1.6317, 1.6277, 1.6269, 1.6335, 1.6392, 1.64, 1.6411, 1.6396,
                   1.6417, 1.6423, 1.6429, 1.6472, 1.6485, 1.6486, 1.6467, 1.6444, 1.6467, 1.6519,
                   1.6478, 1.6461, 1.6461, 1.6468, 1.6449, 1.647, 1.6461, 1.6452, 1.6422, 1.6422,
                   1.6425, 1.6414, 1.6366, 1.6346, 1.635, 1.6346, 1.6346, 1.6343, 1.6346, 1.6379,
                   1.6416, 1.6442, 1.6431, 1.6431, 1.6435, 1.644, 1.6473, 1.6469, 1.6386, 1.6356,
                   1.634, 1.6346, 1.643, 1.6452, 1.6467, 1.6516, 1.6514, 1.6513, 1.6481, 1.6451,
                   1.645, 1.6441, 1.6414, 1.6419, 1.6419, 1.6428, 1.6431, 1.6418, 1.6371, 1.6349,
                   1.6333, 1.6334, 1.6338, 1.6342, 1.632, 1.6318, 1.637, 1.6368, 1.6368, 1.6383,
                   1.6371, 1.6371, 1.6355, 1.632, 1.6277, 1.6276, 1.6291, 1.6274, 1.6293, 1.6311,
                   1.631, 1.6312, 1.6312, 1.6314, 1.6294, 1.6348, 1.6378, 1.6368, 1.6368, 1.6368,
                   1.636, 1.637, 1.6418, 1.6411, 1.6435, 1.6427, 1.6427, 1.6419, 1.6446, 1.6468,
                   1.6487, 1.6594, 1.6666, 1.6666, 1.6678, 1.6712, 1.6715, 1.6718, 1.6784, 1.6811,
                   1.6811, 1.6794, 1.6814, 1.6781, 1.6756, 1.6735, 1.6763, 1.6762, 1.6777, 1.6815,
                   1.6812, 1.678, 1.6796, 1.6817, 1.6817, 1.6832, 1.6877, 1.6912, 1.6914, 1.7119,
                   1.7112, 1.711, 1.7115, 1.7176, 1.7187, 1.717, 1.7115, 1.7131, 1.7129, 1.7116,
                   1.7135, 1.7145, 1.6956, 1.6988, 1.6915, 1.6914, 1.6859, 1.6778, 1.6815, 1.6815,
                   1.6843, 1.6846, 1.6846, 1.6923, 1.6997, 1.7198, 1.7188, 1.7232, 1.7262, 1.7266,
                   1.7359, 1.7368, 1.7337, 1.7317, 1.7387, 1.7467, 1.7461, 1.7366, 1.7319, 1.7361,
                   1.7437, 1.7432, 1.7461, 1.7461, 1.7454, 1.7549, 1.7742, 1.7811, 1.7913, 1.7876,
                   1.7928, 1.7991, 1.8117, 1.7823, 1.7661, 1.785, 1.7863, 1.7862, 1.7821, 1.7858,
                   1.7731, 1.7779, 1.7844, 1.7866, 1.7864, 1.7788, 1.7875, 1.7971, 1.8114, 1.7857,
                   1.7932, 1.7938, 1.7927, 1.7918, 1.7919, 1.7989, 1.7988, 1.7949, 1.7948, 1.7882,
                   1.7745, 1.771, 1.775, 1.7791, 1.7882, 1.7882, 1.7899, 1.7915, 1.7889, 1.7879,
                   1.7855, 1.7866, 1.7865, 1.7795, 1.7758, 1.7717, 1.761, 1.7497, 1.7471, 1.7473,
                   1.7417, 1.7288, 1.7174, 1.6927, 1.7183, 1.7191, 1.719, 1.7153, 1.7156, 1.7158,
                   1.714, 1.7119, 1.7129, 1.7129, 1.7149, 1.7195
            ]
        }
        ];
        var json = {};
        json.chart = chart;
        json.title = title;
        json.subtitle = subtitle;
        json.legend = legend;
        json.tooltip = tooltip;
        json.xAxis = xAxis;
        json.yAxis = yAxis;
        json.series = series;
        json.plotOptions = plotOptions;
        json.credits = credits;
        $('#container_top').highcharts(json);

    });