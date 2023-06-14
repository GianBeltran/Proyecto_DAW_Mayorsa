package com.pe.cibertec.mayorsa.modelo.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_producto")
public class Producto {
	@Id
	private Integer idproduc;
	@Column(name = "nombreproduc")
	private String nombreproduc;
	@Column(name = "descripcionproduc")
	private String descripcionproduc;
	@Column(name = "precioproduc")
	private double precioproduc;
	@Column(name = "stockproduc")
	private Integer stockproduc;
	
	@ManyToOne
	@JoinColumn(name = "idprov")
	private Proveedor proveedor;	
	@ManyToOne
	@JoinColumn(name = "idcatego")
	private Categoria categoria;
}
