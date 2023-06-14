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

import com.pe.cibertec.mayorsa.modelo.bd.Categoria;
import com.pe.cibertec.mayorsa.modelo.bd.Producto;
import com.pe.cibertec.mayorsa.modelo.bd.Proveedor;
import com.pe.cibertec.mayorsa.modelo.request.ProductoRequest;
import com.pe.cibertec.mayorsa.modelo.response.ResultadoResponse;
import com.pe.cibertec.mayorsa.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/frmproducto")
	public String frmMantProducto(Model model) {
		model.addAttribute("listaproductos", productoService.listarProductos());
		return "producto/frmproducto";
	}
	
	@PostMapping("/registrarProducto")
	@ResponseBody
	public ResultadoResponse registrarProducto(@RequestBody ProductoRequest productoRequest) {
		String mensaje = "Producto fue registrado correctamente";
		Boolean respuesta = true;
		try {
			Producto objProducto = new Producto();
			if(productoRequest.getIdproduc() > 0) {
				objProducto.setIdproduc(productoRequest.getIdproduc());
			}
			objProducto.setNombreproduc(productoRequest.getNombreproduc());
			objProducto.setDescripcionproduc(productoRequest.getDescripcionproduc());
			objProducto.setPrecioproduc(productoRequest.getPrecioproduc());
			objProducto.setStockproduc(productoRequest.getStockproduc());
			
			Proveedor objProveedor = new Proveedor();
			objProveedor.setIdprov(productoRequest.getIdprov());
			objProducto.setProveedor(objProveedor);
			
			Categoria objCategoria = new Categoria();
			objCategoria.setIdcatego(productoRequest.getIdcatego());
			objProducto.setCategoria(objCategoria);
			
			productoService.registrarProducto(objProducto);
		} catch (Exception e) {
			mensaje = "Producto no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	
	@DeleteMapping("/eliminarProducto")
	@ResponseBody
	public ResultadoResponse eliminarProducto(@RequestBody ProductoRequest productoRequest) {
		String mensaje = "Producto eliminado correctamente";
		Boolean respuesta = true;
		try {
			productoService.eliminarProducto(productoRequest.getIdproduc());
		} catch (Exception e) {
			mensaje = "Producto no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarProductos")
	@ResponseBody
	public List<Producto> listarProducto(){
		return productoService.listarProductos();
	}
}
