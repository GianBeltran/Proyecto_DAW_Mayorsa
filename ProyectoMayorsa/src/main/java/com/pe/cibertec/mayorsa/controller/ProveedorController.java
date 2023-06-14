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

import com.pe.cibertec.mayorsa.modelo.bd.Proveedor;
import com.pe.cibertec.mayorsa.modelo.request.ProveedorRequest;
import com.pe.cibertec.mayorsa.modelo.response.ResultadoResponse;
import com.pe.cibertec.mayorsa.service.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/frmproveedor")
	public String frmMantProveedor(Model model) {
		model.addAttribute("listaproveedores", proveedorService.listarProveedores());
		return "proveedor/frmproveedor";
	}
	
	@PostMapping("/registrarProveedor")
	@ResponseBody
	public ResultadoResponse registrarProveedor(@RequestBody ProveedorRequest proveedorRequest) {
		String mensaje = "Proveedor registrado correctamente";
		Boolean respuesta = true;
		try {
			Proveedor objProveedor = new Proveedor();
			if(proveedorRequest.getIdprov()>0) {
				objProveedor.setIdprov(proveedorRequest.getIdprov());
			}
			objProveedor.setNombreprov(proveedorRequest.getNombreprov());
			objProveedor.setDireccionprov(proveedorRequest.getDireccionprov());
			objProveedor.setTelefonoprov(proveedorRequest.getTelefonoprov());
			objProveedor.setCorreoprov(proveedorRequest.getCorreoprov());
		} catch (Exception e) {
			mensaje = "Proveedor no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	
	@PostMapping("/actualizarProveedor")
	@ResponseBody
	public ResultadoResponse actualizarProveedor(@RequestBody ProveedorRequest proveedorRequest) {
		String mensaje = "Proveedor actualizado correctamente";
		Boolean respuesta = true;
		try {
			Proveedor objProveedor = new Proveedor();
			objProveedor.setIdprov(proveedorRequest.getIdprov());
			objProveedor.setNombreprov(proveedorRequest.getNombreprov());
			objProveedor.setDireccionprov(proveedorRequest.getDireccionprov());
			objProveedor.setTelefonoprov(proveedorRequest.getTelefonoprov());
			objProveedor.setCorreoprov(proveedorRequest.getCorreoprov());
			proveedorService.registrarProveedor(objProveedor);
		} catch (Exception e) {
			mensaje = "Error al actualizar proveedor";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarProveedor")
	@ResponseBody
	public ResultadoResponse eliminarProveedor(@RequestBody ProveedorRequest proveedorRequest) {
		String mensaje = "Proveedor eliminado correctamente";
		Boolean respuesta = true;
		try {
			proveedorService.eliminarProveedor(proveedorRequest.getIdprov());
		} catch (Exception e) {
			mensaje = "Proveedor no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarProveedores")
	@ResponseBody
	public List<Proveedor> listarProveedores(){
		return proveedorService.listarProveedores();
	}
}
