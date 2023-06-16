$(document).on("click", "#btnagregar", function() {
	$("#txtidcliente").val("").prop("readonly", false);
    $("#txtnombrecliente").val("");
    $("#txtdireccioncliente").val("");
    $("#txttelefonocliente").val("");
    $("#txtcorreocliente").val("");
    $("#modalCliente").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    var idCliente = $(this).attr("data-idcliente");
    $("#txtidcliente").val(idCliente).prop("readonly", true);
    $("#txtnombrecliente").val($(this).attr("data-nombrecliente"));
    $("#txtdireccioncliente").val($(this).attr("data-direccioncliente"));
    $("#txttelefonocliente").val($(this).attr("data-telefonocliente"));
    $("#txtcorreocliente").val($(this).attr("data-correocliente"));
    $("#modalCliente").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    var idCliente = $("#txtidcliente").val();
    var url = idCliente ? "/cliente/actualizarCliente" : "/cliente/registrarCliente";

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify({
            idcliente: idCliente,
            nombrecliente: $("#txtnombrecliente").val(),
            direccioncliente: $("#txtdireccioncliente").val(),
            telefonocliente: $("#txttelefonocliente").val(),
            correocliente: $("#txtcorreocliente").val(),
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listarClientes();
        }
    });

    $("#modalCliente").modal("hide");
});

$(document).on("click", ".btneliminarcliente", function(){
	$("#hddideliminarcliente").val("");
	$("#hddideliminarcliente").val($(this).attr("data-idcliente"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el cliente "+ 
			$(this).attr("data-nombrecliente")+"?");
	$("#modalEliminarCliente").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/cliente/eliminarCliente",
		data: JSON.stringify({
			idcliente: $("#hddideliminarcliente").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listarClientes();
		}
	})
	$("#modalEliminarCliente").modal("hide");
})

function listarClientes(){
	$.ajax({
		type: "GET",
		url: "/cliente/listarClientes",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblcliente > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcliente > tbody").append("<tr>"+
						"<td>"+value.idcliente+"</td>"+
						"<td>"+value.nombrecliente+"</td>"+
						"<td>"+value.direccioncliente+"</td>"+
						"<td>"+value.telefonocliente+"</td>"+
						"<td>"+value.correocliente+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idcliente='"+value.idcliente+"'"+
							" data-nombrecliente='"+value.nombrecliente+"'"+
							" data-direccioncliente='"+value.direccioncliente+"'"+
							" data-telefonocliente='"+value.telefonocliente+"'"+
							" data-correocliente='"+value.correocliente+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcliente'"+	
							" data-idcliente='"+value.idcliente+"'"+
							" data-nombrecliente='"+value.nombrecliente+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





