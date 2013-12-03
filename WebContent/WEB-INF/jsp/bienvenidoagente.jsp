<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Bienvenido agente</title>
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
						<a href="notificaciones.do"></a>
					</li>
					<li class="configuracion">
						<a href="#"></a>
						<ul>
							<!--<li><a href="altaagente.do">Alta de Agentes</a></li>-->
							<li><a href="perfilagente.do">Perfil</a></li>
							<li><a href="empresasquesigo.do">Empresas que sigo</a></li>
							<li><a href="crearnoticia.do">Crear una noticia</a></li>
						</ul>
					</li>
					<li class="salir">
						<a href="logout.do"></a>
					</li>
				</ul>
			</div>
			<form action="buscador.do" id="headerFormBuscar">
				<p><label for="textoBuscarHeader">Buscar</label><input type="text" name="palabra" id="textoBuscarHeader" /></p>
				<p><button type="submit">Buscar</button></p>
			</form>
			<div id="usuario">
				<img src="../img/perfil.png" alt="" /> <p>Hola ${agente.nombre}</p>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<div id="contenido">
			<h1>Bienvenido ${agente.nombre}</h1>
			<ul id="botonesQueHacer">
				<li id="botonesQueHacerBtnCrearNoticia"><a href="crearnoticia.do">Crear una noticia</a></li>
				<li id="botonesQueHacerBtnVerPerfil"><a href="perfilagente.do">Ver mi perfil</a></li>
				<li id="botonesQueHacerBtnEmpresasQueSigo"><a href="empresasquesigo.do">Ver empresas que sigo</a></li>
				<li id="botonesQueHacerBtnBuscarEmpresas"><a href="resultadosbusqueda.do">Buscar empresas</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andrés Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>
