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
import com.pe.cibertec.mayorsa.modelo.request.CategoriaRequest;
import com.pe.cibertec.mayorsa.modelo.response.ResultadoResponse;
import com.pe.cibertec.mayorsa.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/frmcategoria")
	public String frmMantCategoria(Model model) {
		model.addAttribute("listacategorias", categoriaService.listarCategorias());
		return "categoria/frmcategoria";
	}
	
	@PostMapping("/registrarCategoria")
	@ResponseBody
	public ResultadoResponse registrarCategoria(@RequestBody CategoriaRequest categoriaRequest) {
		String mensaje = "Categoria registrada correctamente";
		Boolean respuesta = true;
		try {
			Categoria objCategoria = new Categoria();
			if(categoriaRequest.getIdcatego()>0) {
				objCategoria.setIdcatego(categoriaRequest.getIdcatego());
			}
			objCategoria.setNombrecatego(categoriaRequest.getNombrecatego());
	        objCategoria.setDescripcioncatego(categoriaRequest.getDescripcioncatego());
	        categoriaService.registrarCategoria(objCategoria);
		} catch (Exception e) {
			mensaje = "Categoria no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	
	@PostMapping("/actualizarCategoria")
	@ResponseBody
	public ResultadoResponse actualizarCategoria(@RequestBody CategoriaRequest categoriaRequest) {
	    String mensaje = "Categoria actualizada correctamente";
	    Boolean respuesta = true;
	    try {
	        Categoria objCategoria = new Categoria();
	        objCategoria.setIdcatego(categoriaRequest.getIdcatego());
	        objCategoria.setNombrecatego(categoriaRequest.getNombrecatego());
	        objCategoria.setDescripcioncatego(categoriaRequest.getDescripcioncatego());
	        categoriaService.registrarCategoria(objCategoria);
	    } catch (Exception e) {
	        mensaje = "Error al actualizar la categoría";
	        respuesta = false;
	    }
	    return ResultadoResponse.builder()
	            .mensaje(mensaje)
	            .respuesta(respuesta)
	            .build();
	}
	
	@DeleteMapping("/eliminarCategoria")
	@ResponseBody
	public ResultadoResponse eliminarCategoria(@RequestBody CategoriaRequest categoriaRequest) {
		String mensaje = "Categoria eliminada correctamente";
		Boolean respuesta = true;
		try {
			categoriaService.eliminarCategoria(categoriaRequest.getIdcatego());
		} catch (Exception e) {
			mensaje = "Categoria no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	
	@GetMapping("/listarCategorias")
	@ResponseBody
	public List<Categoria> listarCategorias(){
		return categoriaService.listarCategorias();
	}
 }
