package com.pe.cibertec.mayorsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Proveedor;
import com.pe.cibertec.mayorsa.repository.ProveedorRepository;

@Service
public class ProveedorService {
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> listarProveedores(){
		return proveedorRepository.findAll();
	}
	public void registrarProveedor(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}
	public void eliminarProveedor(Integer idprov) {
		proveedorRepository.deleteById(idprov);
	}
}
