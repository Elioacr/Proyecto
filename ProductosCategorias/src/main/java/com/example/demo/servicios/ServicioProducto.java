package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Producto;
import com.example.demo.repositorios.RepositorioProducto;

@Service
public class ServicioProducto {
	@Autowired
	private final RepositorioProducto repositorioProducto;

	public ServicioProducto(RepositorioProducto repositorioProducto) {
		this.repositorioProducto = repositorioProducto;
	}

	public Producto insertarProducto(Producto nuevoProducto) {
		return this.repositorioProducto.save(nuevoProducto);
	}

	public List<Producto> obtenerTodas(){
		return this.repositorioProducto.findAll();
	}

	public Producto obtenerPorId(Long id) {
		return this.repositorioProducto.findById(id).orElse(null);
	}

	public void eliminarPorId(Long id) {
		this.repositorioProducto.deleteById(id);
	}

	public Producto actualizarProducto(Producto producto) {
		return this.repositorioProducto.save(producto);
	}
}