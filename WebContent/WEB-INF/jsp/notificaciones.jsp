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
						<a href="notificaciones.do" class="icono-mail"></a>
					</li>
					<li class="configuracion">
						<a href="#" class="icon-cogs"></a>
						<ul>
							<!--<li><a href="altaagente.do">Alta de Agentes</a></li>-->
							<li><a href="perfilagente.do">Perfil</a></li>
							<li><a href="empresasquesigo.do">Empresas que sigo</a></li>
							<li><a href="crearnoticia.do">Crear una noticia</a></li>
							<li><a href="resultadosbusqueda.do">Buscar Empresas</a></li>
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
				<img src="../img/perfil.png" alt="" /> <p>Hola ${agente}</p>
			</div>
		</div>
	</div>
	<div id="contenedor">
		<div id="contenido">
		<h1>Notificaciones</h1>
		<ul id="listaNotificaciones">
			<li><a href="timeline.do">Timeline.me</a> public� el 16/12/2013 a las 21:00 la siguiente noticia: <a href="timeline.do">Disculpas por promocionar al innombrable</a></li>
			<li><a href="timeline.do">Timeline.me</a> public� el 15/12/2013 a las 11:00 la siguiente noticia: <a href="timeline.do">M�s sorteos de navidad</a></li>
			<li><a href="timeline.do">Timeline.me</a> public� el 12/12/2013 a las 11:00 la siguiente noticia: <a href="timeline.do">M�s sorpresas para los usuarios</a></li>
		</ul>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Timeline.me, taller Web (Andr�s Malagreca, Alicia Rosenthal, Marcos Scalzotto).</p>
	</div>
</body>
</html>
