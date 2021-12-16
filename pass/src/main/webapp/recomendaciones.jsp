<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Itinerario</title>

<!-- favicon -->

<link rel="apple-touch-icon" sizes="180x180"
	href="img/favicon/apple-touch-icon.png" />
<link rel="icon" type="image/png" sizes="32x32"
	href="img/favicon/favicon-32x32.png" />
<link rel="icon" type="image/png" sizes="16x16"
	href="img/favicon/favicon-16x16.png" />
<link rel="manifest" href="img/favicon/site.webmanifest" />

<!-- Bootstrap -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />

<!-- Css -->

<link rel="stylesheet" href="css\main.css" />

<link rel="stylesheet" type="text/css" href="css\GlideCss\glider.css">

<!-- Js Bootstrap -->

<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script defer src="js\GlideJs\glider.js"></script>
<script defer src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script defer src="js\indexJs\script.js"></script>

<script type="text/javascript" defer
	src="js\itinerarioJs\HTML2PDF\html2pdf.bundle.min.js"></script>
<script type="text/javascript" defer
	src="js\itinerarioJs\HTML2PDF\descargarPDF.js"></script>

<script type="text/javascript" defer
	src="js\itinerarioJs\acordionJs\scriptMostrarAccordion.js"></script>
<script type="text/javascript" defer
	src="js\itinerarioJs\acordionJs\scriptMostrarLista.js"></script>

<script type="text/javascript" defer
	src="js\itinerarioJs\climaJs\clima.js"></script>
<script type="text/javascript" defer
	src="js\itinerarioJs\climaJs\hora.js"></script>

</head>

<body>
	<div class="loader-wrapper">
		<span class="loader"><span class="loader-inner"></span></span>
	</div>
	<div class="modal" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog  modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<p class="modal-title pe-1" id="exampleModalLabel">Hola
						Visitante!</p>
					<span><svg xmlns="http://www.w3.org/2000/svg" width="22"
							height="22" fill="currentColor" class="bi bi-person-fill"
							viewBox="0 0 16 16">
            <path
								d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
          </svg></span>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
					<c:if test="${flash != null}">
						<div class="alert alert-danger">
							<p>
								<c:out value="${flash}" />
							</p>
						</div>
					</c:if>
				</div>
				<div class="modal-body">
					<form action="login" method="post">

						<div class="mb-3">
							<label for="username" class="form-label">Usuario</label> <input
								class="form-control" name="username">
						</div>

						<div class="mb-3">
							<label for="password" class="form-label">Contraseña</label> <input
								type="password" class="form-control" name="password">
						</div>

						<div class="d-grid gap-2">
							<button type="submit" class="btn boton-iniciarS">Iniciar
								Sesión</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<a class="logo" href="#home">muy lejano <span class="logo-span">PASS</span>
					</a>

					<button class="navbar-toggler nav-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarScroll"
						aria-controls="navbarScroll" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"> </span>
					</button>
					<div class="collapse navbar-collapse" id="navbarScroll">
						<ul class="navbar-nav ms-auto my-5 my-lg-0 navbar-nav-scroll"
							style="-bs-scroll-height: 200px">
							<li class="nav-item"></li>
							<c:choose>
								<c:when test="${user.nombre != null}">
									<li><a type="button" href="logout" class="iniciar-sesion">Cerrar
											Sesión</a></li>
								</c:when>
								<c:otherwise>
									<li class="nav-item"><a class="iniciar-sesion"
										aria-current="page" href="#" data-bs-toggle="modal"
										data-bs-target="#exampleModal">Iniciar Sesión</a></li>
								</c:otherwise>
							</c:choose>
							<li class="nav-item"><a class="nav-link nav-a"
								href="nosotros.jsp">Nosotros</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle nav-a" href="#"
								id="navbarScrollingDropdown" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> Más </a>
								<ul class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarScrollingDropdown">
									<li><a class="dropdown-item" href="itinerario.jsp">Itinerario</a>
									</li>

									<c:if test="${user.admin}">
										<li>
											<hr class="dropdown-divider" />
										</li>
										<li><a class="dropdown-item" href="panelDeControl.do">Alta
												y baja</a></li>
									</c:if>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="contenedor">
				<div class="row titular">
					<div class="col-10 titulo">
						<h3>
							pensamos <span class="pass-span">como vos</span> 🤭 !
						</h3>
					</div>
					<div class="info-container">
						<div class="info">
							<span>i</span>
							<p class="h1">Hey!</p>
							<p>Piensa con detenimiento tu compra!, una vez realizada esta
								no tendra reembolso.</p>
						</div>
					</div>
				</div>
			
			
			
			</div>
		</div>
	</div>
</body>
</html>