$(document).on("click", "#btnagregar", function() {
	$("#txtidprov").val("").prop("readonly", false);
    $("#txtnombreprov").val("");
    $("#txtdireccionprov").val("");
    $("#txttelefonoprov").val("");
    $("#txtcorreoprov").val("");
    $("#modalProveedor").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    var idProveedor = $(this).attr("data-idprov");
    $("#txtidprov").val(idProveedor).prop("readonly", true);
    $("#txtnombreprov").val($(this).attr("data-nombreprov"));
    $("#txtdireccionprov").val($(this).attr("data-direccionprov"));
    $("#txttelefonoprov").val($(this).attr("data-telefonoprov"));
    $("#txtcorreoprov").val($(this).attr("data-correoprov"));
    $("#modalProveedor").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    var idProv = $("#txtidprov").val();
    var url = idProv ? "/proveedor/actualizarProveedor" : "/proveedor/registrarProveedor";

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify({
            idprov: idProv,
            nombreprov: $("#txtnombreprov").val(),
            direccionprov: $("#txtdireccionprov").val(),
            telefonoprov: $("#txttelefonoprov").val(),
            correoprov: $("#txtcorreoprov").val(),
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listarProveedores();
        }
    });

    $("#modalProveedor").modal("hide");
});

$(document).on("click", ".btneliminarproveedor", function(){
	$("#hddideliminarprov").val("");
	$("#hddideliminarprov").val($(this).attr("data-idprov"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el proveedor "+ 
			$(this).attr("data-nombreprov")+"?");
	$("#modalEliminarProveedor").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/proveedor/eliminarProveedor",
		data: JSON.stringify({
			idprov: $("#hddideliminarprov").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listarProveedores();
		}
	})
	$("#modalEliminarProveedor").modal("hide");
})

function listarProveedores(){
	$.ajax({
		type: "GET",
		url: "/proveedor/listarProveedores",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblproveedor > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblproveedor > tbody").append("<tr>"+
						"<td>"+value.idprov+"</td>"+
						"<td>"+value.nombreprov+"</td>"+
						"<td>"+value.direccionprov+"</td>"+
						"<td>"+value.telefonoprov+"</td>"+
						"<td>"+value.correoprov+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idprov='"+value.idprov+"'"+
							" data-nombreprov='"+value.nombreprov+"'"+
							" data-direccionprov='"+value.direccionprov+"'"+
							" data-telefonoprov='"+value.telefonoprov+"'"+
							" data-correoprov='"+value.correoprov+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarproveedor'"+	
							" data-idprov='"+value.idprov+"'"+
							" data-nombreprov='"+value.nombreprov+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





