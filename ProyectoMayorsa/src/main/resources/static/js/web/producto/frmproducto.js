$(document).on("click", "#btnagregar", function(){
	$("#txtidproduc").val("");
	$("#txtnombreproduc").val("");
	$("#txtdescripcionproduc").val("");
	$("#cbocategoria").empty();
	$.ajax({
		type: "GET",
		url: "/categoria/listarCategorias",
		dataType: "json",
		success: function(resultado){
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbocategoria").append(
							`<option value="${value.idcatego}">
								${value.nombrecatego}</option>`
							);
				})
			}			
		}
	})
	$("#txtprecioproduc").val("");
	$("#txtstockproduc").val("");
	$("#cboproveedor").empty();
	$.ajax({
		type: "GET",
		url: "/proveedor/listarProveedores",
		dataType: "json",
		success: function(resultado){
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cboproveedor").append(
							`<option value="${value.idprov}">
								${value.nombreprov}</option>`
							);
				})
			}			
		}
	})
	$("#modalProducto").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/producto/registrarProducto",
		contentType: "application/json",
		data: JSON.stringify({
			idproduc: $("#txtidproduc").val(),
			nombreproduc: $("#txtnombreproduc").val(),
			descripcionproduc: $("#txtdescripcionproduc").val(),
			idcatego: $("#cbocategoria").val(),
			precioproduc: $("#txtprecioproduc").val(),
			stockproduc: $("#txtstockproduc").val(),
			idprov: $("#cboproveedor").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarProductos();
		}
	});
	$("#modalProducto").modal("hide");
})

$(document).on("click", ".btneliminarproducto", function(){
	$("#hddideliminarproducto").val("");
	$("#hddideliminarproducto").val($(this).attr("data-idproduc"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el producto "+ 
			$(this).attr("data-nombreproduc")+"?");
	$("#modalEliminarProducto").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/producto/eliminarProducto",
		data: JSON.stringify({
			idproduc: $("#hddideliminarproducto").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarProductos();
		}
	})
	$("#modalEliminarProducto").modal("hide");
})

function ListarProductos(){
	$.ajax({
		type: "GET",
		url: "/producto/listarProductos",
		dataType: "json",
		success: function(resultado){
			$("#tblproducto > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblproducto > tbody").append("<tr>"+
						"<td>"+value.idproduc+"</td>"+
						"<td>"+value.nombreproduc+"</td>"+
						"<td>"+value.descripcionproduc+"</td>"+
						"<td>"+value.categoria.nombrecatego+"</td>"+	
						"<td>"+value.precioproduc+"</td>"+
						"<td>"+value.stockproduc+"</td>"+
						"<td>"+value.proveedor.nombreprov+"</td>"+	
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarproducto'"+	
							" data-idproduc='"+value.idproduc+"'"+
							" data-nombreproduc='"+value.nombreproduc+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})			
		}
	})
}

