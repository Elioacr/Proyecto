package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelos.Producto;

public interface RepositorioProducto extends CrudRepository <Producto, Long> {
	List<Producto> findAll();
}
