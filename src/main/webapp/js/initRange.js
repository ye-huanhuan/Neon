/**
 *  使用jRange插件
 */
//初始化
$('.range-slider').jRange({
    from: -3,
    to: 5,
    step: 0.2,
    scale: [-3,-1,1,3,5],
    format: '%s',
    width: 300,
    showLabels: true,
    isRange : true,
    
});
	//得到range的值
	$(".range-slider").change(function(){
    	var aa = $(".range-slider").val();
    	document.getElementById("demo").innerHTML= aa;
    	
	});