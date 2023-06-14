package com.pe.cibertec.mayorsa.modelo.request;

import lombok.Data;

@Data
public class ProductoRequest {
	private Integer idproduc;
	private String nombreproduc;
	private String descripcionproduc;
	private double precioproduc;
	private Integer stockproduc;
	
	private Integer idprov;
	private Integer idcatego;
}
