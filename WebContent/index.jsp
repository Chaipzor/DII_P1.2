<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>index</title>
</head>
<body>

	<%
		String texto;
		if (request.getAttribute("texto") != null)
			texto = (String) request.getAttribute("texto");
		else
			texto = "";
	%>

	<div class="caja">

		<div class="contenedorForm">
			<div class="separador"></div>
			<div class="titulo">Datos de contacto</div>
			<div class="subtitulo"><%out.println(texto);%></div>
			<div class="login-item">
				<form action="<%=request.getContextPath()%>/form" method="post"
					class="form form-login">
					<div class="form-field">

						<label for="nombre">NOMBRE</label> 
						<input name="nombre" id="username" type="text" class="form-input"
							placeholder="Nombre" required>
					</div>

					<div class="form-field">

						<label for="apellidos">APELLIDOS</label> <input
							name="apellidos" id="apellidos" type="text" class="form-input"
							placeholder="Apellidos" required>
					</div>

					<div class="form-field">

						<label for="email">EMAIL</label> <input name="email"
							id="email" type="text" class="form-input" placeholder="Email"
							 required>
					</div>

					<div class="form-field">

						<label for="telefono">TELÉFONO</label> <input name="telefono"
							maxlength="9" id="telefono" type="text" class="form-input"
							placeholder="Telefono" required>
					</div>

					<div class="form-field">

						<label for="comentarios">COMENTARIOS</label>
						<textarea id="comments" cols="60" name="comentarios" 
							 placeholder="Comentarios" required></textarea>
					</div>

					<div class="form-field">
						<input type="submit" name="boton" value="Enviar">
					</div>
				</form>
			</div>
			<div class="separador"></div>
		</div>
	</div>

	<div class="contenedorTabla">
		<table>
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>E-mail</th>
					<th>Teléfono</th>
					<th>Comentarios</th>
					<th>Editar</th>
					<th>Borrar</th>
			</thead>
			<c:forEach items="${listaContactos}" var="item">
				<tr>
					<td><c:out value="${item.nombre}" /></td>
					<td><c:out value="${item.apellidos}" /></td>
					<td><c:out value="${item.email}" /></td>
					<td><c:out value="${item.telefono}" /></td>
					<td><c:out value="${item.comentarios}" /></td>
					<td><a id="editar" href="edit?id=${item.id}"></a></td>
					<td><a id="eliminar" href="form?id=${item.id}"></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>