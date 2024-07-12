<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categorias</title>
</head>
<body>
 <h1> Lista de categorias </h1> 
	<c:forEach var="categoria" items="${listaCategorias}"> 
	<a href="/formulario/producto/categoria/${categoria.id}"> ${categoria.nombre} </a>
	<ul> 
	<c:forEach var="producto" items="${categoria.productos}"> 
	<li> ${producto.nombre} </li> 
	</c:forEach>
	 </ul> 
	 </c:forEach> 
	 <a href="/formulario/producto"> Nuevo producto </a> - 
	 <a href="/formulario/categoria">Nuevo Categoria</a>
</body>
</html>