package com.pe.cibertec.mayorsa.modelo.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_cliente")
public class Cliente {
	@Id
	private Integer idcliente;
	@Column(name = "nombrecliente")
	private String nombrecliente;
	@Column(name = "direccioncliente")
	private String direccioncliente;
	@Column(name = "telefonocliente")
	private String telefonocliente;
	@Column(name = "correocliente")
	private String correocliente;
}
