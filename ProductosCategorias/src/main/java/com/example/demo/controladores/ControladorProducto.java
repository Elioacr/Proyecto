package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelos.Producto;
import com.example.demo.servicios.ServicioProducto;

import jakarta.validation.Valid;

@Controller
public class ControladorProducto {
	@Autowired
    private ServicioProducto servicioProducto;
    
    public ControladorProducto(ServicioProducto servicioProducto) {
    	this.servicioProducto = servicioProducto;
    }
	
	@GetMapping("/formulario/producto")
    public String newProduct(@ModelAttribute("producto") Producto producto) {
        return "formularioProducto.jsp";
    }

    @PostMapping("/procesar/producto")
    public String createProduct(@Valid @ModelAttribute("producto") Producto producto,
    											BindingResult validaciones) {
    	if(validaciones.hasErrors()) {
    		return "formularioProducto.jsp";
    	}
    	servicioProducto.insertarProducto(producto);
        return "redirect:/categorias";
    }

}
