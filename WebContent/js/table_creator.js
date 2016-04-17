$(document).ready(function(){
		//alert(<%=request.getAttribute("view_serv_name")%>)
		$.get("GroupView",function(db_list){
			alert(db_list);
			//get names of the columns from the first object
			//var table_headers = Object.keys(db_list[0]);
			//var table = $("<table border ='1'> </table>")
			//var table_capt = append_caption(table, "group");
			/*
			var row = $("<tr><td>34");
			table.append(row);
			*/
			/*
			table_headers.forEach(h_name, i, table_headers){
				alert(h_name)
			}
			*/
			//draw_table_header(table, table_headers);
			
			/*
			
			$.each(db_list, function(index, obj){
			var row = $("<tr>");
			//foreach field in obj...
				row.append($("<td>").text(obj[i]))
			row.apendTo($table);
			});
			*/
			//$('#table').append(table);
		});
});
/*
function append_caption(table,title){
	var caption = $("<caption>");
	caption.append(title);
	table.append(caption)
	return caption
}


function draw_table_header(table,table_hlist){
	var header = $("<tr>");
	//add column names
	table_hlist.forEach(h_name, i, table_hlist){
		alert(h_name)
		var col = $("<th>");
		col.append(h_name)
		header.append(col)
		//header.append($("<th>").text(h_name))
	}
	header.appendTo(table)
}
*/
