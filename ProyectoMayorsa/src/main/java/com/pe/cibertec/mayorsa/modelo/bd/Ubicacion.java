package com.pe.cibertec.mayorsa.modelo.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_ubicacion")
@Data
public class Ubicacion {
	@Id
	private Integer idubicacion;
	@Column(name = "nombreubicacion")
	private String nombreubicacion;
	@Column(name = "direccionubicacion")
	private String direccionubicacion;
	@Column(name = "ciudadubicacion")
	private String ciudadubicacion;
	@Column(name = "paisubicacion")
	private String paisubicacion;
}
