<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/procesar/formulario/producto/categoria/${idCategoria}" method=POST>
	<input type="hidden" name="_method" value="PUT"> 
	<div> 
		<label for="idProducto"> ¿Qué producto deseas agregar? </label> 
			<select name="idProducto" id="idProducto"> 
				<c:forEach var="producto" items="${listaProductos}"> 
					<option value="${producto.id}"> ${producto.nombre} 
					</option> 
				</c:forEach> 
		</select> 
	</div> 
	<button type="submit"> Agregar </button> 
	</form>
</body>
</html>