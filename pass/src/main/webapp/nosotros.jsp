<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Nosotros</title>

<!-- favicon -->

<link rel="apple-touch-icon" sizes="180x180"
	href="img/favicon/apple-touch-icon.png" />
<link rel="icon" type="image/png" sizes="32x32"
	href="img/favicon/favicon-32x32.png" />
<link rel="icon" type="image/png" sizes="16x16"
	href="img/favicon/favicon-16x16.png" />
<link rel="manifest" href="img/favicon/site.webmanifest" />

<!-- Bootstrap Css -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />

<!-- Css -->

<link rel="stylesheet" href="css\main.css" />

<!-- Glider Css-->

<link rel="stylesheet" type="text/css" href="css\GlideCss\glider.css" />

<!-- AOS scroll  -->

<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

<!-- AOS scroll Js-->

<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

<!-- Glider Js-->

<script defer src="js\GlideJs\glider.js"></script>

<!-- Bootstrap Js -->

<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<!-- Jquery -->

<script defer src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<!-- Js -->

<script defer src="js\indexJs\script.js"></script>

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
		<a href="#home" class="scroll-to-top"> <svg
				xmlns="http://www.w3.org/2000/svg" fill="currentColor"
				viewBox="0 0 16 16">
        <path fill-rule="evenodd"
					d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z" />
      </svg>
		</a>
		<div class="contenedor">
			<div class="cursor"></div>

			<div class="container">
				<nav class="navbar navbar-expand-lg navbar-light ">
					<div class="container-fluid">
						<a class="logo" href="index.do">muy lejano <span
							class="logo-span">PASS</span>
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
										<li class="nav-item"><a class="iniciar-sesion"
											href="recomendaciones.do">Quiero!</a></li>
									</c:when>
									<c:otherwise>
										<li class="nav-item"><a class="iniciar-sesion"
											aria-current="page" href="#" data-bs-toggle="modal"
											data-bs-target="#exampleModal">Iniciar Sesión</a></li>
									</c:otherwise>
								</c:choose>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle nav-a" href="#"
									id="navbarScrollingDropdown" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Más </a>
									<ul class="dropdown-menu dropdown-menu-end"
										aria-labelledby="navbarScrollingDropdown">
										<li><a class="dropdown-item" href="index.do">Home</a></li>
										<c:choose>
											<c:when test="${user.nombre != null}">
												<li>
													<hr class="dropdown-divider" />
												</li>
												<li><a class="dropdown-item"
													href="personalItinerary.do">Itinerario</a></li>
												<li><c:if test="${user.admin}">
														<li>
															<hr class="dropdown-divider" />
														</li>
														<li><a class="dropdown-item" href="panelDeControl.do">Alta
																y baja</a></li>
													</c:if>

													<hr class="dropdown-divider" /></li>
												<li><a type="button" href="logout"
													class="dropdown-item">Cerrar Sesión</a></li>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose>
									</ul></li>
							</ul>
						</div>
					</div>
				</nav>

				<!--  end Navbar -->


				<!--  main content  -->

				<div class="container">

					<div class="nosotros-container">
						<h2 class="titulo">Somos una empresa con amplia experiencia
							en el rubro</h2>
					</div>
					<br>
					<div class="row">
						<div class="col">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Pellentesque vestibulum mi quis erat venenatis tristique. Duis
								consectetur, sapien vitae euismod lacinia, ipsum felis tempor
								augue, a vehicula erat odio sed urna. Mauris rhoncus
								pellentesque gravida. Nulla semper mauris vitae mauris tempus
								fermentum. Suspendisse vitae felis placerat, ultricies ante sed,
								consequat velit. Donec vehicula tristique malesuada. Vestibulum
								quis sollicitudin orci. Donec tempor nibh elit, eu congue augue
								mattis in. Curabitur a suscipit nibh. Donec sit amet mattis
								dolor, at vestibulum sem. Pellentesque a suscipit lorem. Morbi
								id turpis fermentum, posuere augue id, fringilla tortor.
								Suspendisse convallis vel augue vitae hendrerit. Cras in lorem
								at mi iaculis dictum vel non leo. Vestibulum quis consectetur
								elit, congue pellentesque est. Nulla facilisi. Ut ut ullamcorper
								massa, at imperdiet leo. In tempor eros non ligula imperdiet, eu
								egestas eros malesuada. Sed pellentesque faucibus lorem id
								faucibus. Proin sed scelerisque risus. Vivamus diam nisl,
								laoreet sit amet pellentesque non, egestas eu justo.</p>
						</div>
						<div class="col">
							<img alt="Parque temático de Shrek"
								src="img\icons\shrekparque.jpg" style="width: 40vw;">
						</div>
					</div>
					<br>

					<div>
						<div class="row">
							<div class="col">
								<div class="card" style="width: 18rem;">
									<img src="img\3-card.png" class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Fede Gasior</h5>
										<p class="card-text">Bastante piola, le faltan un par de
											detalles. Ah, y la página está bien.</p>
										<br>
										<p>Puntuación:</p>
										<div class="progress">
											<div class="progress-bar" role="progressbar"
												style="width: 90%;" aria-valuenow="90" aria-valuemin="0"
												aria-valuemax="100">90%</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card" style="width: 18rem;">
									<img src="img\1-card.png" class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">El Leo Blau</h5>
										<p class="card-text">Digamos que para lo que se pidió,
											cumple. Este parque podría estar mejor.</p>
										<br>
										<p>Puntuación:</p>
										<div class="progress">
											<div class="progress-bar" role="progressbar"
												style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
												aria-valuemax="100">75%</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card" style="width: 18rem;">
									<img src="img\1-card.png" class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Lucas Vid</h5>
										<p class="card-text">Buen precio. Le falta Spring.</p>
										<br>
										<p>Puntuación:</p>
										<div class="progress">
											<div class="progress-bar" role="progressbar"
												style="width: 65%;" aria-valuenow="65" aria-valuemin="0"
												aria-valuemax="100">65%</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
</body>

</html>