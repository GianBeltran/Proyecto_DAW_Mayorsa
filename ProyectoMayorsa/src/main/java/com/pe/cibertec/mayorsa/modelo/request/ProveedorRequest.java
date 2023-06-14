package com.pe.cibertec.mayorsa.modelo.request;

import lombok.Data;

@Data
public class ProveedorRequest {
	private Integer idprov;
	private String nombreprov;
	private String direccionprov;
	private String telefonoprov;
	private String correoprov;
}
