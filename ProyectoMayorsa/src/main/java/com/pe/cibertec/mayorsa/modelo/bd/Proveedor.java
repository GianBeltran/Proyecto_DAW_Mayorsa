package com.pe.cibertec.mayorsa.modelo.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_proveedor")
public class Proveedor {
	@Id
	private Integer idprov;
	@Column(name = "nombreprov")
	private String nombreprov;
	@Column(name = "direccionprov")
	private String direccionprov;
	@Column(name = "telefonoprov")
	private String telefonoprov;
	@Column(name = "correoprov")
	private String correoprov;
}
