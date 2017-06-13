/**
 * 预览产品分析下载数据
 */
$("#preview").click(function(){
	 var selectedNumber = [];
     $('input:checkbox[name=select]').not("input:checked").each(function(i){
    	 selectedNumber[i] = $(this).attr('id');
     });
     if(selectedNumber.length === 7){
    	 selectedNumber = [];
     }
 var trs = document.getElementById("Tax_detail").rows;
 alert(trs.length);
 for(var i = 0, len = trs.length; i < len; i++){
	 if(i<=1||trs[i].cells.length ===8){
		 var cell0 = trs[i].cells[0];
	     var parent = cell0.parentNode;
	     if($(cell0).children(':first').attr('name') === "all"){
	    	 parent.removeChild(cell0);
	     }
	     
	     for(var j=0;j<selectedNumber.length;j++){
	    	 trs[i].cells[selectedNumber[j]-j-1].parentNode.removeChild(trs[i].cells[selectedNumber[j]-j-1]);
	     }
	 }else{
		 cell0 = trs[i].cells[0];
	     //cell0.style.display = 'none';
	     parent = cell0.parentNode;
	     if($(cell0).children(':first').attr('name') === "all"){
	    	 parent.removeChild(cell0);
	     }
	     for(var j=0;j<selectedNumber.length;j++){
	    	 if(selectedNumber[0]!=1){
	    	 	trs[i].cells[selectedNumber[j]-j-2].parentNode.removeChild(trs[i].cells[selectedNumber[j]-j-2]);
	    	 }else{
	    		 if(j!=0){
	    			 trs[i].cells[selectedNumber[j]-j-1].parentNode.removeChild(trs[i].cells[selectedNumber[j]-j-1]);
	    		 }
	    		 
	    	 }
	    	
	     }
	 }
     
 }
 });