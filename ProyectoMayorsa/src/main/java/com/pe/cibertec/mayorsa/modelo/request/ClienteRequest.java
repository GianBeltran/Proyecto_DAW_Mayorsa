package com.pe.cibertec.mayorsa.modelo.request;

import lombok.Data;

@Data
public class ClienteRequest {
	private Integer idcliente;
	private String nombrecliente;
	private String direccioncliente;
	private String telefonocliente;
	private String correocliente;
}
