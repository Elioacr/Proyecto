package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Categoria;
import com.example.demo.repositorios.RepositorioCategoria;

@Service
public class ServicioCategoria {
	@Autowired
	private final RepositorioCategoria repositorioCategoria;

	public ServicioCategoria(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	}

	public Categoria insertarCategoria(Categoria nuevaCategoria) {
		return this.repositorioCategoria.save(nuevaCategoria);
	}

	public List<Categoria> obtenerTodas(){
		return this.repositorioCategoria.findAll();
	}

	public Categoria obtenerPorId(Long id) {
		return this.repositorioCategoria.findById(id).orElse(null);
	}

	public void eliminarPorId(Long id) {
		this.repositorioCategoria.deleteById(id);
	}

	public Categoria actualizarProducto(Categoria categoria) {
		return this.repositorioCategoria.save(categoria);
	}
}