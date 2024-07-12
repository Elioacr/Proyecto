package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.Categoria;
import com.example.demo.modelos.Producto;
import com.example.demo.servicios.ServicioCategoria;
import com.example.demo.servicios.ServicioProducto;

import jakarta.validation.Valid;

@Controller
public class ControladorCategoria {
    @Autowired
    private ServicioCategoria servicioCategoria;
    private ServicioProducto servicioProducto;
    
    public ControladorCategoria(ServicioCategoria servicioCategoria,
    							ServicioProducto servicioProducto) {
    	this.servicioCategoria = servicioCategoria;
    	this.servicioProducto = servicioProducto;
    }

    @GetMapping("/categorias")
    public String index(Model model) {
    	List<Categoria> listaCategorias = this.servicioCategoria.obtenerTodas();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias.jsp";
    }

    @GetMapping("/formulario/categoria")
    public String newCategory(@ModelAttribute("categoria") Categoria categoria) {
        return "formularioCategoria.jsp";
    }

    @PostMapping("/procesar/categoria")
    public String create(@Valid @ModelAttribute("categoria") Categoria categoria,
    											BindingResult validaciones) {
    	if(validaciones.hasErrors()) {
    		return "formularioCategoria.jsp";
    	}
    	servicioCategoria.insertarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/formulario/producto/categoria/{idCategoria}")
    public String desplegarFormularioCategoriaProducto(@PathVariable("idCategoria") Long idCategoria, Model model) {
    	List<Producto> listaProductos = this.servicioProducto.obtenerTodas();
        model.addAttribute("idCategoria", idCategoria);
        model.addAttribute("listaProductos", listaProductos);
        return "formularioCategoriaProducto.jsp";
    }

    @PutMapping("/procesar/formulario/producto/categoria/{idCategoria}")
    public String addCategory(@PathVariable("idCategoria") Long idCategoria, @RequestParam("idProducto") Long idProducto) {
    	Categoria categoriaActual = this.servicioCategoria.obtenerPorId(idCategoria);
        Producto productoActual = this.servicioProducto.obtenerPorId(idProducto);
        
        List<Producto> productosActuales = categoriaActual.getProductos();
        productosActuales.add(productoActual);
        
        categoriaActual.setProductos(productosActuales);
        
        this.servicioCategoria.actualizarProducto(categoriaActual);
        return "redirect:/categorias";
    }
}