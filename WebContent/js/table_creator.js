//alert
//console.log
$(document).ready(function(){
	console.log("javascript!!!");
	$.get("/GroupView",function(json_list){
		
		var $table = $("<table>").apendTo("#table");
		var db_list = $.parseJSON(json_list);
		$.each(db_list, function(index, obj){
		var row = $("<tr>");
		//foreach field in obj...
			row.append($("<td>").text(obj[i]))
		row.apendTo($table);
		});
	});
});
