<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Registro</title>
	<link rel="stylesheet" type="text/css" href="css/estilos.css" />
</head>
<body>
	<div id="header">
		<div id="menucont">
			<div id="logo">
				<img src="img/timeline_me.png" alt="" />
			</div>
			<div id="menu" style="display: none;">
				<ul>
					<div class="notificacion"><p>5</p></div>
					<li class="mail">
						<a href="#" class="icono-mail"></a>
					</li>
					<li class="configuracion">
						<a href="#" class="icon-cogs"></a>
						<ul>
							<li><a href="#">Alta de Agentes</a></li>
							<li><a href="#">Perfil</a></li>
							<li><a href="#">Empresas que sigo</a></li>
						</ul>
					</li>
					<li class="salir">
						<a href="#" class="icon-twitter"></a>
					</li>
				</ul>
			</div>
			<div id="usuario" style="display: none">
				<img src="img/perfil.png" alt="" /> <p>Hola usuario</p>
			</div>
			<div id="login">
				<form action="jsp/index.jsp" method="post" name="formLogin">
					<fieldset>
						<legend>Iniciar sesión</legend>
						<p class="parrafoCampo"><label for="emailLogin">E-mail</label><input type="text" name="email" id="emailLogin" /></p>
						<p class="parrafoCampo"><label for="passwordLogin">Contraseña</label><input type="password" name="password" id="passwordLogin" /></p>
						<p class="parrafoLoginAuto"><input type="checkbox" name="loginAuto" id="loginAuto" value="1" /><label for="loginAuto">Iniciar sesión automáticamente</label></p>
					</fieldset>
					<p><button type="submit">Iniciar sesión</button></p>
				</form>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<div id="registroBienvenida">
			<h1>Bienvenido a timeline.me</h1>
			<p>Bienvenido a timeline.me, un sitio donde podés publicar las novedades de tu empresa, y enterarte de las novedades de las demás.</p>
			<p><a href="paginas/altaagente.do">Alta Agente</a></p>
			<p><a href="paginas/bienvenidoagente.do">Bienvenido agente</a></p>
			<p><a href="paginas/crearnoticia.do">Crear Noticia</a></p>
			<p><a href="paginas/empresasquesigo.do">Empresas que sigo</a></p>
			<p><a href="paginas/notificaciones.do">Notificaciones</a></p>
			<p><a href="paginas/perfilagente.do">Perfil Agente</a></p>
			<p><a href="paginas/timeline.do">Timeline</a></p>
		</div>
		<form action="altaagente.html" method="post" id="formRegistro" enctype="multipart/form-data">
			<fieldset>
				<legend>Registro</legend>
				<p><label for="email">E-mail</label><input type="text" name="email" id="email" /></p>
				<p><label for="password">Contraseña</label><input type="text" name="password" id="password" /></p>
				<p><label for="passwordRepetir">Repetir contraseña</label><input type="text" name="passwordRepetir" id="passwordRepetir" /></p>
				<p><label for="razon_Social">Razón social</label><input type="text" name="razon_Social" id="razon_Social" /></p>
				<p><label for="sitio_Web">Sitio Web</label><input type="text" name="sitio_Web" id="sitio_Web" /></p>
				<p><label for="direccion">Dirección</label><input type="text" name="direccion" id="direccion" /></p>
				<p><label for="telefono">Teléfono</label><input type="text" name="telefono" id="telefono" /></p>
				<p><label for="logoEmpresa">Logo</label><input type="file" name="logo" id="logoEmpresa" /></p>
			</fieldset>
			<p><button type="submit">Aceptar</button></p>
		</form>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>