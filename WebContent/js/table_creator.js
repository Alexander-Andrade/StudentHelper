//alert
//console.log
$.get("/GroupView",function(json_list){
	console.log("here here here");
	var $table = $("<table>").apendTo("#table");
	var db_list = $.parseJSON(json_list);
	$.each(db_list, function(index, obj){
	var row = $("<tr>");
	//foreach field in obj...
		row.append($("<td>").text(obj[i]))
	row.apendTo($table);
	});
});

construct_table();