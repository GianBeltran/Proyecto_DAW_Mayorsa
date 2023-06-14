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

import com.pe.cibertec.mayorsa.modelo.bd.Cliente;
import com.pe.cibertec.mayorsa.modelo.request.ClienteRequest;
import com.pe.cibertec.mayorsa.modelo.response.ResultadoResponse;
import com.pe.cibertec.mayorsa.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/frmcliente")
	public String frmMantCliente(Model model) {
		model.addAttribute("listaclientes", clienteService.listarClientes());
		return "cliente/frmcliente";
	}
	
	@PostMapping("/registrarCliente")
	@ResponseBody
	public ResultadoResponse registrarCliente(@RequestBody ClienteRequest clienteRequest) {
		String mensaje = "Cliente registrado correctamente";
		Boolean respuesta = true;
		try {
			Cliente objCliente = new Cliente();
			if(clienteRequest.getIdcliente()>0) {
				objCliente.setIdcliente(clienteRequest.getIdcliente());
			}
			objCliente.setNombrecliente(clienteRequest.getNombrecliente());
			objCliente.setDireccioncliente(clienteRequest.getDireccioncliente());
			objCliente.setTelefonocliente(clienteRequest.getTelefonocliente());
			objCliente.setCorreocliente(clienteRequest.getCorreocliente());
		} catch (Exception e) {
			mensaje = "Cliente no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	
	@PostMapping("/actualizarCliente")
	@ResponseBody
	public ResultadoResponse actualizarCliente(@RequestBody ClienteRequest clienteRequest) {
		String mensaje = "Cliente actualizado correctamente";
		Boolean respuesta = true;
		try {
			Cliente objCliente = new Cliente();
			objCliente.setIdcliente(clienteRequest.getIdcliente());
			objCliente.setNombrecliente(clienteRequest.getNombrecliente());
			objCliente.setDireccioncliente(clienteRequest.getDireccioncliente());
			objCliente.setTelefonocliente(clienteRequest.getTelefonocliente());
			objCliente.setCorreocliente(clienteRequest.getCorreocliente());
			clienteService.registrarCliente(objCliente);
		} catch (Exception e) {
			mensaje = "Error al actualizar el cliente";
			respuesta = false;
		}
		return ResultadoResponse.builder()
					            .mensaje(mensaje)
					            .respuesta(respuesta)
					            .build();
	}
	
	@DeleteMapping("/eliminarCliente")
	@ResponseBody
	public ResultadoResponse eliminarCliente(@RequestBody ClienteRequest clienteRequest) {
		String mensaje = "Cliente eliminado correctamente";
		Boolean respuesta = true;
		try {
			clienteService.eliminarCliente(clienteRequest.getIdcliente());
		} catch (Exception e) {
			mensaje = "Cliente no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
	            .mensaje(mensaje)
	            .respuesta(respuesta)
	            .build();
	}
	
	@GetMapping("/listarClientes")
	@ResponseBody
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}
}
