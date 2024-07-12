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
    <h1>Nuevo Producto</h1>
    <form action="/procesar/producto" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <label for="descripcion">Descripcion:</label>
        <input type="text" id="descripcion" name="descripcion" required>
        <label for="precio">Precio:</label>
        <input type="number" id=precio name="precio" required>

        <button type="submit">Crear</button>
    </form>
</body>
</html>