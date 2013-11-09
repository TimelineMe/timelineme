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
				<a href="../index.html"><img src="../img/timeline_me.png" alt="" /></a>
			</div>
			<div id="menu">
				<ul>
					<div class="notificacion"><p>5</p></div>
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
			<div id="usuario">
				<img src="../img/perfil.png" alt="" /> <p>Hola usuario</p>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<form action="" method="post" id="formNoticia" enctype="multipart/form-data">
			<fieldset>
			<legend>Crear una nueva noticia</legend>
				<p><label for="titulo">Titulo</label><input type="text" name="titulo" id="titulo" /></p>
				<p><label for="contenido">Contenido</label><textarea name="contenido" id="contenido" cols="20" rows="17"></textarea></p>
			</fieldset>
			<p><button type="submit">Aceptar</button></p>
		</form>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>