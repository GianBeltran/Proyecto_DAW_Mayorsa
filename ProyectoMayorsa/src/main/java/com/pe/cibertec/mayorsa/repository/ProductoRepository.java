package com.pe.cibertec.mayorsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.cibertec.mayorsa.modelo.bd.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
