$(document).on("click", "#btnagregar", function() {
	$("#txtidubicacion").val("");
    $("#txtnombre").val("");
    $("#txtdireccion").val("");
    $("#txtciudad").val("");
    $("#txtpais").val("");
    $("#modalUbicacion").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtidubicacion").val($(this).attr("data-idubicacion"));
    $("#txtnombre").val($(this).attr("data-nombreubicacion"));
    $("#txtdireccion").val($(this).attr("data-direccionubicacion"));
    $("#txtciudad").val($(this).attr("data-ciudadubicacion"));
    $("#txtpais").val($(this).attr("data-paisubicacion"));
    $("#modalUbicacion").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    var idUbicacion = $("#txtidubicacion").val();
    var url = idUbicacion ? "/ubicacion/actualizarUbicacion" : "/ubicacion/registrarUbicacion";

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify({
            idubicacion: idUbicacion,
            nombreubicacion: $("#txtnombre").val(),
            direccionubicacion: $("#txtdireccion").val(),
            ciudadubicacion: $("#txtciudad").val(),
            paisubicacion: $("#txtpais").val(),
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listarUbicaciones();
        }
    });

    $("#modalUbicacion").modal("hide");
});

$(document).on("click", ".btneliminarubicacion", function(){
	$("#hddideliminarubicacion").val("");
	$("#hddideliminarubicacion").val($(this).attr("data-idubicacion"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la ubicación "+ 
			$(this).attr("data-nombreubicacion")+"?");
	$("#modalEliminarUbicacion").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/ubicacion/eliminarUbicacion",
		data: JSON.stringify({
			idubicacion: $("#hddideliminarubicacion").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listarUbicaciones();
		}
	})
	$("#modalEliminarUbicacion").modal("hide");
})

function listarUbicaciones(){
	$.ajax({
		type: "GET",
		url: "/ubicacion/listarUbicaciones",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblubicacion > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblubicacion > tbody").append("<tr>"+
						"<td>"+value.idubicacion+"</td>"+
						"<td>"+value.nombreubicacion+"</td>"+
						"<td>"+value.direccionubicacion+"</td>"+
						"<td>"+value.ciudadubicacion+"</td>"+
						"<td>"+value.paisubicacion+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idubicacion='"+value.idubicacion+"'"+
							" data-nombreubicacion='"+value.nombreubicacion+"'"+
							" data-direccionubicacion='"+value.direccionubicacion+"'"+
							" data-ciudadubicacion='"+value.ciudadubicacion+"'"+
							" data-paisubicacion='"+value.paisubicacion+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarubicacion'"+	
							" data-idubicacion='"+value.idubicacion+"'"+
							" data-nombreubicacion='"+value.nombreubicacion+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}