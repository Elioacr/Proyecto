package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelos.Categoria;

public interface RepositorioCategoria extends CrudRepository <Categoria, Long> {
	List<Categoria> findAll();
}
