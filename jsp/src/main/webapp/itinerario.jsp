<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pruebas</title>

    <!-- Bootstrap -->

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />

    <!-- Css -->
    <link rel="stylesheet" href="css\main.css" />

    <link rel="stylesheet" type="text/css" href="css\GlideCss\glider.css">

    <!-- Js Bootstrap -->

    <script
      defer
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>

    <script defer src="js\GlideJs\glider.js"></script>
    <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script defer src="js\script.js"></script>

  </head>
  
  <body>
    <div class="loader-wrapper">
      <span class="loader"><span class="loader-inner"></span></span>
  </div>
  
    <div class="container-fluid">

    <div class="contenedor">
      <section class="header">
          <div class="container viewport">
        <nav class="navbar navbar-expand-lg navbar-light ">
            <div class="container-fluid">
              <a class="logo" href="index.html">muy lejano <span class="logo-span" >PASS</span> </a>

              <button class="navbar-toggler nav-button" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon">
                </span>
              </button>
                    <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav ms-auto my-5 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 200px;">
                  <li class="nav-item">
                    <a class=" iniciar-sesion" aria-current="page" href="#">Iniciar Sesion</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link nav-a" href="#">Nosotros</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle nav-a" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Más
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                      <li><a class="dropdown-item" href="itinerario.jsp">Itinerario</a></li>
                      <li><a class="dropdown-item" href="#">algo</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item disabled" href="#">Alta y baja</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <div class="itinerario">
            <h3 class="titulo">Su itinerario</h3>
            <div class="accordion accordion-flush" id="accordionFlushExample">
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingOne">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                      <div class="accordion-data row">
                        <div class="col-6 nombre-atraccion"><p>Nombre de la actividad que compró el usuario (Por ej: El Calabozo)</p></div>
                        <div class="col-3 clock-in-accordion"><img class="clock" src="img\clock.svg" /></div>
                        <div class="col-3 coin-in-accordion"><img class="coin" src="img\coin.svg" /></div>
                       </div>
                    </button>
                  </h2>
                  <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                    <div class="container">
                        <div class="row">
                          <div class="col-6">
                              <div class="accordion-body descripcion-accordion">Descripción de la atracción</div>
                          </div>
                          <div class="col-3">
                              <div class="accordion-body tiempo-accordion">Duración</div>
                          </div>
                          <div class="col-3">
                            <div class="accordion-body costo-accordion">Costo</div>
                          </div>
                        </div>
                    </div>
                  </div>
                </div>
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingTwo">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                      <div class="accordion-data row">
                        <div class="col-6 nombre-atraccion"><p>Duloc</p></div>
                        <div class="col-3 clock-in-accordion"><img class="clock" src="img\clock.svg" /></div>
                        <div class="col-3 coin-in-accordion"><img class="coin" src="img\coin.svg" /></div>
                       </div>
                    </button>
                  </h2>
                  <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                    <div class="container">
                        <div class="row">
                          <div class="col-6">
                              <div class="accordion-body descripcion-accordion">Por qué elegiste esto?</div>
                          </div>
                          <div class="col-3">
                              <div class="accordion-body tiempo-accordion">1:30 horas</div>
                          </div>
                          <div class="col-3">
                            <div class="accordion-body costo-accordion">20 monedas de oro </div>
                          </div>
                        </div>
                    </div>
                  </div>
                </div>
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingThree">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                      <div class="accordion-data row">
                        <div class="col-6 nombre-atraccion"><p>Banquete en el Pantano</p></div>
                        <div class="col-3 clock-in-accordion"><img class="clock" src="img\clock.svg" /></div>
                        <div class="col-3 coin-in-accordion"><img class="coin" src="img\coin.svg" /></div>
                       </div>
                    </button>
                  </h2>
                  <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
                    <div class="container">
                        <div class="row">
                          <div class="col-6">
                              <div class="accordion-body descripcion-accordion">Buena relación costo/calidad</div>
                          </div>
                          <div class="col-3">
                              <div class="accordion-body tiempo-accordion">1 hora</div>
                          </div>
                          <div class="col-3">
                            <div class="accordion-body costo-accordion">5 monedas de oro </div>
                          </div>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
        </div>
          <!-- end navbar -->

          <!-- titular y bg -->
        </div>        
      </section>

    <section>

    </section>

    </div>
    </div>
    <footer></footer>
  
  </body>
</html>