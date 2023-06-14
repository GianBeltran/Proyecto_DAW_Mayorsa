package com.pe.cibertec.mayorsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Ubicacion;
import com.pe.cibertec.mayorsa.repository.UbicacionRepository;

@Service
public class UbicacionService {
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	public List<Ubicacion> listarUbicaciones(){
		return ubicacionRepository.findAll();
	}
	public void registrarUbicacion(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}
	public void eliminarUbicacion(Integer idubi) {
		ubicacionRepository.deleteById(idubi);
	}
}
