<!--
Cosas por hacer:
-hundir boton al presionarse
-boton scroll to top
-info clip path
-billetera clip path
-clip path bubble con info de politicas de ofertas
...
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <title>muy lejano PASS</title>

  <!-- favicon -->

  <link rel="apple-touch-icon" sizes="180x180" href="img/favicon/apple-touch-icon.png" />
  <link rel="icon" type="image/png" sizes="32x32" href="img/favicon/favicon-32x32.png" />
  <link rel="icon" type="image/png" sizes="16x16" href="img/favicon/favicon-16x16.png" />
  <link rel="manifest" href="img/favicon/site.webmanifest" />

  <!-- Bootstrap Css -->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />

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

  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>

  <!-- Jquery -->

  <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

  <!-- Js -->

  <script defer src="js\script.js"></script>

</head>

<body>
  <div class="loader-wrapper">
    <span class="loader"><span class="loader-inner"></span></span>
  </div>

   <div class="modal" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog  modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <p class="modal-title pe-1" id="exampleModalLabel">Hola Visitante! </p><span><svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
          </svg></span>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
              <button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="container-fluid">
    <a href="#home" class="scroll-to-top">
      <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
          d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z" />
      </svg>
    </a>
    <div class="contenedor">
      <div class="cursor"></div>
      <section class="header" id="home">
        <div class="container">
          <nav class="navbar navbar-expand-lg navbar-light nav-sticky-hijo">
            <div class="container-fluid">
              <a class="logo" href="#home">muy lejano <span class="logo-span">PASS</span>
              </a>

              <button class="navbar-toggler nav-button" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"> </span>
              </button>
              <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav ms-auto my-5 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 200px">
                  <li class="nav-item">
                  </li>
                  <li class="nav-item">
                    <a class="iniciar-sesion" aria-current="page" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal">Iniciar Sesion</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link nav-a" href="#">Nosotros</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle nav-a" href="#" id="navbarScrollingDropdown" role="button"
                      data-bs-toggle="dropdown" aria-expanded="false">
                      M�s
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                      <li>
                        <a class="dropdown-item" href="itinerario.jsp">Itinerario</a>
                      </li>
                      <li>
                        <hr class="dropdown-divider" />
                      </li>
                      <li>
                        <a class="dropdown-item" href="panelDeControl.do" >Alta y baja</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <!-- end navbar -->
          <c:if test="${flash != null}">
            <div class="alert alert-danger">
              <p>
                <c:out value="${flash}" />
              </p>
            </div>
          </c:if>
          <!-- titular y bg -->
          <div class="container">
            <div class="row justify-content-center viewport-no-nav">
              <div class="col-10 enunciado">
                <h1 data-aos="fade-up" data-aos-duration="2000">
                  Plane� tus salidas con <span class="pass-span">PASS</span>
                </h1>
                <a data-aos="fade-down" data-aos-duration="1000" class="btn boton-destinos"
                  href="#Destinos">destinos</a>
              </div>
              <div class="shrek-img" data-aos="fade-up" data-aos-duration="1500">
                <img class="img" src="img\shrek-bg.png" />
              </div>
            </div>
          </div>
        </div>
      </section>
      <div class="clip-verde"></div>
      <section class="catalogo" id="Destinos">
        <div class="container viewport">
          <div class="row titular">
            <div class="col-10 titulo">
              <h2>
                nuestros <span class="pass-span">destinos</span>
              </h2>
            </div>
          </div>
          <div class="container glider-contenedor">
            <div class="glider-contain">
              <div class="glider">
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img\1-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-locura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img/3-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-degustacion.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img\1-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-aventura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img/2-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-locura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img\3-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-aventura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img\1-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-locura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img/2-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-degustacion.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img\3-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-aventura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img/1-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-locura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img\2-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-aventura.png" />
                    </div>
                  </div>
                </div>
                <div>
                  <div class="card-contenedor">
                    <div class="img-contenedor">
                      <img class="img-card" src="img/3-card.png" />
                    </div>
                    <div class="titulo-contenedor">
                      <p class="titulo-carta">pack locura</p>
                    </div>
                    <div class="valores-contenedor">
                      <div class="valor-i">
                        <img class="coin" src="img\coin.svg" />
                      </div>
                      <span class="valor"> 50u </span>
                    </div>
                    <div class="valores-contenedor tiempo">
                      <div class="valor-i">
                        <img class="clock" src="img\clock.svg" />
                      </div>
                      <span class="valor"> 1.5hs </span>
                    </div>
                    <div class="categoria-i">
                      <img src="img\cat-degustacion.png" />
                    </div>
                  </div>
                </div>
              </div>

              <button aria-label="Previous" class="glider-prev">�</button>
              <button aria-label="Next" class="glider-next">�</button>
              <div role="tablist" class="dots"></div>
            </div>
          </div>
          <article>
            <p class="titulo summer verde"> agregar contador de ventas
              <!-- temporada verano 2021
              <img class="summer-img" src="img\sun.png" /><img class="summer-img" src="img\flamingo.png" />
              --> </p> 
          </article>
        </div>
      </section>

      <section class="lista">
        <div class="container viewport">
          <div class="row titular">
            <div class="col-10 titulo"> 
              <h3>en muy <b>muy lejano</b>...</h3>
              <h4 class="subtitulo">
                Tenemos destinos personalizados para t�
              </h4>
              <a class="btn boton-quiero" data-bs-toggle="modal" data-bs-target="#exampleModal">Quiero!</a>
            </div>
            <div class="info-container">
              <div class="info">
                <span>i</span>
                <p class="h1">Hey!</p>
                <p>Piensa con detenimiento tu compra!, una vez realizada esta no tendra reembolso.</p>
              </div>
            </div>
          </div>
          
          <div class="row tabla-contenedor">
            <table class="col-8 table table-striped">
              <thead>
                <tr>
                  <th scope="col"></th>
                  <th scope="col">Nombre</th>
                  <th scope="col">Costo</th>
                  <th scope="col">Duraci�n</th>
                  <td></td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">1</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">2</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">3</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">4</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">5</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">6</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">7</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">8</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
                <tr>
                  <th scope="row">9</th>
                  <td>PACK LOCURA</td>
                  <td>50u</td>
                  <td>1.5hs</td>
                  <td><a class="btn boton-quiero-tabla">Quiero!</a></td>
                </tr>
              </tbody>
            </table>
          </div>
          <article>
            <p class="politicas">
              *Promociones v�lidas del 25/08 al 30/12 de 2021. Cupos limitados, SOLO CON RESERVA, comunicarse al
              0800-000-000
              lunes a s�bados de 8hs a 20hs.
            </p>
          </article>
        </div>
      </section>
    </div>
    <footer></footer>
  </div>
</body>

</html>

