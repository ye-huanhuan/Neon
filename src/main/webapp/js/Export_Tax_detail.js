/**
 * 明细表导出为excel
 */
$("#btnExport").click(function(){
	$("#preview").click();
        $("#Tax_detail").table2excel({
            exclude: ".noExl",
            name: "Worksheet Name",
            filename: "SomeFile" //do not include extension
        });

    });