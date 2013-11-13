<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Alta Agentes</title>
	<link rel="stylesheet" type="text/css" href="../css/estilos.css" />
</head>
<body>
	<div id="header">
		<div id="menucont">
			<div id="logo">
				<a href="../index.jsp"><img src="../img/timeline_me.png" alt="" /></a>
			</div>
			<div id="menu">
				<div class="notificacion"><p>5</p></div>
				<ul>
					<li class="mail">
						<a href="notificaciones.do" class="icono-mail"></a>
					</li>
					<li class="configuracion">
						<a href="#" class="icon-cogs"></a>
						<ul>
							<li><a href="altaagente.do">Alta de Agentes</a></li>
							<li><a href="perfilagente.do">Perfil</a></li>
							<li><a href="empresasquesigo.do">Empresas que sigo</a></li>
							<li><a href="crearnoticia.do">Crear una noticia</a></li>
						</ul>
					</li>
					<li class="salir">
						<a href="#" class="icon-twitter"></a>
					</li>
				</ul>
			</div>
			<form action="resultadosbusqueda.do" id="headerFormBuscar">
				<p><label for="textoBuscarHeader">Buscar</label><input type="text" name="q" id="textoBuscarHeader" /></p>
				<p><button type="submit">Buscar</button></p>
			</form>
			<div id="usuario">
				<img src="../img/perfil.png" alt="" /> <p>Hola ${empresa}</p>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<div id="registroBienvenida">
			<h1>Bienvenido ${empresa} a timeline.me</h1>
			<p>Para poder empezar a publicar, tenés que dar de alta un agente.</p>
		</div>
		<form action="" method="post" id="formRegistroAgente" enctype="multipart/form-data">
			<fieldset>
			<legend>Registro Agentes</legend>
				<p><label for="nombre_Agente">Nombre y Apellido</label><input type="text" name="nombre_Agente" id="nombre_Agente" /></p>
				<p><label for="email">E-mail</label><input type="text" name="email" id="email" /></p>
				<p><label for="password">Contraseña</label><input type="text" name="password" id="password" /></p>
				<p><label for="passwordRepetir">Repetir contraseña</label><input type="text" name="passwordRepetir" id="passwordRepetir" /></p>
				<p><label for="cargo">Cargo</label><input type="text" name="cargo" id="cargo" /></p>
				<p><label for="descripcion">Descripción</label><textarea name="descripcion" id="descripcion" cols="20" rows="5"></textarea></p>
				<p><label for="foto">Foto</label><input type="file" name="foto" id="foto" /></p>
			</fieldset>
			<p><button type="submit">Aceptar</button></p>
		</form>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>