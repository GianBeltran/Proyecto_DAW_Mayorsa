package com.pe.cibertec.mayorsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Cliente;
import com.pe.cibertec.mayorsa.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	public void registrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	public void eliminarCliente(Integer idcliente) {
		clienteRepository.deleteById(idcliente);
	}
}
