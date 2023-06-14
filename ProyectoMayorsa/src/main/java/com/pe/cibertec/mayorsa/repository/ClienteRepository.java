package com.pe.cibertec.mayorsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.cibertec.mayorsa.modelo.bd.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
