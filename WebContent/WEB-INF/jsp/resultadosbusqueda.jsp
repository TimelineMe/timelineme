<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Resultados de búsqueda</title>
	<link rel="stylesheet" href="../css/estilos.css" />
</head>
<body>
	<div id="header">
		<div id="menucont">
			<div id="logo">
				<a href="../index.jsp"><img src="../img/timeline_me.png" alt="" /></a>
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
		<div id="contenido">
			<h1>Resultados de búsqueda</h1>
			<ul id="resultadosBusqueda">
			<c:forEach items="${empresasNoSeguidas}" var="unaEmpresaNoSeguida">
				<li><a href="timeline.do?empresa=${unaEmpresaNoSeguida.email}"><img src="../img/empresas/${unaEmpresaNoSeguida.razon_Social}.jpg" alt="" class="avatarLista" />${unaEmpresaNoSeguida.razon_Social}</a> <a href="seguir.do?empresa=${unaEmpresaNoSeguida.email}" class="btnSeguir">Seguir</a></li>
			</c:forEach>
			<c:forEach items="${misEmpresas}" var="unaEmpresa">
				<li><a href="timeline.do?empresa=${unaEmpresa.email}"><img src="../img/empresas/${unaEmpresa.razon_Social}.jpg" alt="" class="avatarLista" />${unaEmpresa.razon_Social}</a> <a href="dejardeseguir.do?empresa=${unaEmpresa.email}" class="btnSeguir">Dejar de Seguir</a></li>
			</c:forEach>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>
