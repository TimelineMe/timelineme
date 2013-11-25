<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Perfil del agente</title>
	<link rel="stylesheet" href="../css/estilos.css" />
</head>
<body>
	<div id="header">
		<div id="menucont">
			<div id="logo">
				<a href="bienvenidoagente.do"><img src="../img/timeline_me.png" alt="" /></a>
			</div>
			<div id="menu">
				<div class="notificacion"><p>5</p></div>
				<ul>
					<li class="mail">
						<a href="notificaciones.do"></a>
					</li>
					<li class="configuracion">
						<a href="#"></a>
						<ul>
							<!--<li><a href="altaagente.do">Alta de Agentes</a></li>-->
							<li><a href="perfilagente.do">Perfil</a></li>
							<li><a href="empresasquesigo.do">Empresas que sigo</a></li>
							<li><a href="crearnoticia.do">Crear una noticia</a></li>
							<li><a href="resultadosbusqueda.do">Buscar Empresas</a></li>
						</ul>
					</li>
					<li class="salir">
						<a href="logout.do"></a>
					</li>
				</ul>
			</div>
			<form action="resultadosbusqueda.do" id="headerFormBuscar">
				<p><label for="textoBuscarHeader">Buscar</label><input type="text" name="q" id="textoBuscarHeader" /></p>
				<p><button type="submit">Buscar</button></p>
			</form>
			<div id="usuario">
				<img src="../img/perfil.png" alt="" /> <p>Hola ${agente}</p>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<div id="headerEmpresa">
			<h2>${miAgente.nombre}</h2>
			<p id="fotoEmpresa"><img src="../img/perfil.jpg" width="200" height="200" /></p>
			<ul>
				<li>Cargo: ${miAgente.cargo}</li>
				<li>Empresa: <a href="timeline.do?empresa=${miEmpresa.email}">${miEmpresa.razon_Social}</a></li>
				<li>E-mail: <a href="mailto:${miAgente.email_Agente}">${miAgente.email_Agente}</a></li>
			</ul>
		</div>
		<div id="contenido">
			<h1>Perfil</h1>
			<h2>Descripción</h2>
			<p>${miAgente.descripcion}</p>
		</div>
		<c:forEach items="${misNoticias}" var="unaNoticia">
		<div class="noticia">
			<h2>${unaNoticia.titulo}</h2>
			<p>${unaNoticia.contenido}</p>
			<p class="noticiaPublicadaPor">Publicada por <a href="perfilautor.do?emailAgente=${unaNoticia.autor}">${unaNoticia.autor}</a> el ${unaNoticia.fecha}</p>
		</div>
		</c:forEach>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>
