package com.pe.cibertec.mayorsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pe.cibertec.mayorsa.modelo.bd.Ubicacion;
import com.pe.cibertec.mayorsa.modelo.request.UbicacionRequest;
import com.pe.cibertec.mayorsa.modelo.response.ResultadoResponse;
import com.pe.cibertec.mayorsa.service.UbicacionService;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {
	@Autowired
	private UbicacionService ubicacionService;
	
	@GetMapping("/frmubicacion")
	public String frmManUbicacion(Model model) {
		model.addAttribute("listaubicaciones", ubicacionService.listarUbicaciones());
		return "ubicacion/frmubicacion";
	}
	
	@PostMapping("/registrarUbicacion")
	@ResponseBody
	public ResultadoResponse registrarUbicacion(@RequestBody UbicacionRequest ubicacionRequest) {
		String mensaje = "Ubicación registrada correctamente";
		Boolean respuesta = true;
		try {
			Ubicacion objUbicacion = new Ubicacion();
			if(ubicacionRequest.getIdubicacion()>0) {
				objUbicacion.setIdubicacion(ubicacionRequest.getIdubicacion());
			}
			objUbicacion.setNombreubicacion(ubicacionRequest.getNombreubicacion());
			objUbicacion.setDireccionubicacion(ubicacionRequest.getDireccionubicacion());
			objUbicacion.setCiudadubicacion(ubicacionRequest.getCiudadubicacion());
			objUbicacion.setPaisubicacion(ubicacionRequest.getPaisubicacion());
			ubicacionService.registrarUbicacion(objUbicacion);
		} catch (Exception e) {
			mensaje = "Ubicacion no registada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	
	@PostMapping("/actualizarUbicacion")
	@ResponseBody
	public ResultadoResponse actualizarUbicacion(@RequestBody UbicacionRequest ubicacionRequest) {
		String mensaje = "Ubicación actualizada correctamente";
		Boolean respuesta = true;
		try {
			Ubicacion objUbicacion = new Ubicacion();
			objUbicacion.setIdubicacion(ubicacionRequest.getIdubicacion());
			objUbicacion.setNombreubicacion(ubicacionRequest.getNombreubicacion());
			objUbicacion.setDireccionubicacion(ubicacionRequest.getDireccionubicacion());
			objUbicacion.setCiudadubicacion(ubicacionRequest.getCiudadubicacion());
			objUbicacion.setPaisubicacion(ubicacionRequest.getPaisubicacion());
			ubicacionService.registrarUbicacion(objUbicacion);
		} catch (Exception e) {
			mensaje = "Error al actualizar la ubicacion";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarUbicacion")
	@ResponseBody
	public ResultadoResponse eliminarUbicacion(@RequestBody UbicacionRequest ubicacionRequest) {
		String mensaje = "Ubicacion eliminada correctamente";
		Boolean respuesta = true;
		try {
			ubicacionService.eliminarUbicacion(ubicacionRequest.getIdubicacion());
		} catch (Exception e) {
			mensaje = "Ubicacion no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarUbicaciones")
	@ResponseBody
	public List<Ubicacion> listarUbicaciones(){
		return ubicacionService.listarUbicaciones();
	}
}
