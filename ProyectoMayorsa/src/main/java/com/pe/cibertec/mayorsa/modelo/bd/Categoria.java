package com.pe.cibertec.mayorsa.modelo.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_categoria")
@Data
public class Categoria {
	@Id
	private Integer idcatego;
	@Column(name = "nombrecatego")
	private String nombrecatego;
	@Column(name = "descripcioncatego")
	private String descripcioncatego;
}
