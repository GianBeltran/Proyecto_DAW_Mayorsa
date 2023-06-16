$(document).on("click", "#btnagregar", function() {
	$("#txtidcatego").val("").prop("readonly", false);
    $("#txtnombre").val("");
    $("#txtdescripcion").val("");
    $("#modalCategoria").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    var idCategoria = $(this).attr("data-idcatego");
    $("#txtidcatego").val(idCategoria).prop("readonly", true);
    $("#txtnombre").val($(this).attr("data-nombrecatego"));
    $("#txtdescripcion").val($(this).attr("data-descripcioncatego"));
    $("#modalCategoria").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    var idCategoria = $("#txtidcatego").val();
    var url = idCategoria ? "/categoria/actualizarCategoria" : "/categoria/registrarCategoria";

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify({
            idcatego: idCategoria,
            nombrecatego: $("#txtnombre").val(),
            descripcioncatego: $("#txtdescripcion").val(),
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listarCategorias();
        }
    });

    $("#modalCategoria").modal("hide");
});

$(document).on("click", ".btneliminarcatego", function(){
	$("#hddideliminarcategoria").val("");
	$("#hddideliminarcategoria").val($(this).attr("data-idcatego"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la categoria "+ 
			$(this).attr("data-nombrecatego")+"?");
	$("#modalEliminarCategoria").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/categoria/eliminarCategoria",
		data: JSON.stringify({
			idcatego: $("#hddideliminarcategoria").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listarCategorias();
		}
	})
	$("#modalEliminarCategoria").modal("hide");
})

function listarCategorias(){
	$.ajax({
		type: "GET",
		url: "/categoria/listarCategorias",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblcategoria > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcategoria > tbody").append("<tr>"+
						"<td>"+value.idcatego+"</td>"+
						"<td>"+value.nombrecatego+"</td>"+
						"<td>"+value.descripcioncatego+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idcatego='"+value.idcatego+"'"+
							" data-nombrecatego='"+value.nombrecatego+"'"+
							" data-descripcioncatego='"+value.descripcioncatego+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcatego'"+	
							" data-idcatego='"+value.idcatego+"'"+
							" data-nombrecatego='"+value.nombrecatego+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





