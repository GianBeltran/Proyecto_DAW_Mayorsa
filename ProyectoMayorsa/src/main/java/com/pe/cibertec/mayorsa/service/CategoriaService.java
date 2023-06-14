package com.pe.cibertec.mayorsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Categoria;
import com.pe.cibertec.mayorsa.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarCategorias(){
		return categoriaRepository.findAll();
	}
	public void registrarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	public void eliminarCategoria(Integer idcatego) {
		categoriaRepository.deleteById(idcatego);
	}
}
