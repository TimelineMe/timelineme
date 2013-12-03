<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Timeline Me</title>
	<link rel="stylesheet" href="../css/estilos.css" />
</head>
<body>
	<div id="header">
		<div id="menucont">
			<div id="logo">
				<a href="bienvenidoagente.do"><img src="../img/timeline_me.png" alt="" /></a>
			</div>
			<div id="menu">
				<div class="notificacion"><p>${novedades}</p></div>
				<ul>
					<li class="mail">
						<a href="notificaciones.do" class="icono-mail"></a>
					</li>
					<li class="configuracion">
						<a href="#" class="icon-cogs"></a>
						<ul>
							<!--<li><a href="altaagente.do">Alta de Agentes</a></li>-->
							<li><a href="perfilagente.do">Perfil</a></li>
							<li><a href="empresasquesigo.do">Empresas que sigo</a></li>
							<li><a href="crearnoticia.do">Crear una noticia</a></li>
						</ul>
					</li>
					<li class="salir">
						<a href="logout.do" class="icon-twitter"></a>
					</li>
				</ul>
			</div>
			<form action="buscador.do" id="headerFormBuscar">
				<p><label for="textoBuscarHeader">Buscar</label><input type="text" name="palabra" id="textoBuscarHeader" /></p>
				<p><button type="submit">Buscar</button></p>
			</form>
			<div id="usuario">
				<img src="../img/usuarios/${agente.nombre}.jpg" alt="" class="avatar" /> <p>Hola ${agente.nombre}</p>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<div id="headerEmpresa">
			<h1>${miEmpresa.razon_Social}</h1>
			<p id="fotoEmpresa"><img src="../img/empresas/${miEmpresa.razon_Social}.jpg" width="200" height="200" /></p>
			<ul>
				<li>Dirección: ${miEmpresa.direccion}</li>
				<li>Teléfono: ${miEmpresa.telefono}</li>
				<li>Sitio Web: <a href="http://${miEmpresa.sitio_Web}">${miEmpresa.sitio_Web}</a></li>
				<li>E-mail: <a href="mailto:${miEmpresa.email}">${miEmpresa.email}</a></li>
			</ul>
		</div>
		${pemailEmpresa}
		<c:forEach items="${misNoticias}" var="unaNoticia">
		<div class="noticia">
			<h2>${unaNoticia.titulo}</h2>
			<p>${unaNoticia.contenido}</p>
			<p class="noticiaPublicadaPor">Publicada por <a href="perfilautor.do?emailAgente=${unaNoticia.autor}">${unaNoticia.autor}</a> el ${unaNoticia.fecha}</p>
		</div>
		</c:forEach>
		<div id="contenido">
			<h2>Agentes que me siguen</h2>
			<ul id="listaEmpresasQueSigo">
				<c:forEach items="${misSeguidores}" var="unSeguidor">
					<li><a href="perfilautor.do?emailAgente=${unSeguidor.email_Agente}">${unSeguidor.nombre}</a></li>
				</c:forEach>
				
			</ul>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>
