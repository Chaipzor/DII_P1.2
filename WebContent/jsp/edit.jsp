<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>edit</title>
</head>
<body>

	<%
		String texto = "";
		if (request.getAttribute("texto") != null)
			texto = (String) request.getAttribute("texto");

		
		String nombre = "";
		if (request.getAttribute("nombre") != null)
			nombre = (String) request.getAttribute("nombre");

		
		String apellidos = "";
		if (request.getAttribute("apellidos") != null)
			apellidos = (String) request.getAttribute("apellidos");

		
		String email = "";
		if (request.getAttribute("email") != null)
			email = (String) request.getAttribute("email");

		
		String telefono = "";
		if (request.getAttribute("telefono") != null)
			telefono = (String)request.getAttribute("telefono");

		
		String comentarios = "";
		if (request.getAttribute("comentarios") != null)
			comentarios = (String) request.getAttribute("comentarios");

	%>

	<div class="caja">

		<div class="contenedorForm">
			<div class="separador"></div>
			<div class="titulo">Editar datos de contacto</div>
			<div class="subtitulo">
				<%
					out.println(texto);
				%>
			</div>
			<div class="login-item">
				<form action="<%=request.getContextPath()%>/edit" method="post"
					class="form form-login">
					<div class="form-field">

						<label class="user" for="nombre">NOMBRE</label>
						<input name="nombre" id="username" type="text" class="form-input"
							placeholder="Nombre" value="<%out.println(nombre);%>" required>
					</div>

					<div class="form-field">

						<label class="user" for="apellidos">APELLIDOS</label>
						<input
							name="apellidos" id="apellidos" type="text" class="form-input"
							placeholder="Apellidos" value="<%out.println(apellidos);%>" required>
					</div>

					<div class="form-field">

						<label class="user" for="email">EMAIL</label>
						<input name="email"
							id="email" type="text" class="form-input" placeholder="Email"
							value="<%out.println(email);%>" readonly="readonly">
					</div>

					<div class="form-field">

						<label class="user" for="telefono">TELÉFONO</label> 
						<input name="telefono"
							maxlength="9" id="telefono" type="text" class="form-input"
							placeholder="Telefono" value="<%out.println(telefono);%>" required>
					</div>

					<div class="form-field">

						<label class="user" for="comentarios">COMENTARIOS</label>
						<textarea id="comments" cols="60" name="comentarios"
							 placeholder="Comentarios" required><%out.println(comentarios);%></textarea>
					</div>

					<div class="form-field">
						<input type="submit" name="boton" value="Editar">
					</div>
				</form>
			</div>
			<div class="separador"></div>
		</div>
	</div>

</body>
</html>