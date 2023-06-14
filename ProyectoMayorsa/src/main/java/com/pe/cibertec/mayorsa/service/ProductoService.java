package com.pe.cibertec.mayorsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Producto;
import com.pe.cibertec.mayorsa.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> listarProductos(){
		return productoRepository.findAll();
	}
	public void registrarProducto(Producto producto) {
		productoRepository.save(producto);
	}
	public void eliminarProducto(Integer idproduc) {
		productoRepository.deleteById(idproduc);
	}
}
