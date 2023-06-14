package com.pe.cibertec.mayorsa.modelo.request;

import lombok.Data;

@Data
public class UbicacionRequest {
	private Integer idubicacion;
	private String nombreubicacion;
	private String direccionubicacion;
	private String ciudadubicacion;
	private String paisubicacion;
}
