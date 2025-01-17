<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="es">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>Panel de Control</title>

    <!-- favicon -->

    <link rel="apple-touch-icon" sizes="180x180"
          href="img/favicon/apple-touch-icon.png"/>
    <link rel="icon" type="image/png" sizes="32x32"
          href="img/favicon/favicon-32x32.png"/>
    <link rel="icon" type="image/png" sizes="16x16"
          href="img/favicon/favicon-16x16.png"/>
    <link rel="manifest" href="img/favicon/site.webmanifest"/>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/BootstrapCss/bootstrap.min.css">
    <script defer src="js/BootstrapJs/bootstrap.js"></script>

    <!-- Css -->

    <link rel="stylesheet" href="css/panel.css"/>

    <!-- Jquery -->


    <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>

    <!-- Js -->

    <script defer src="js/scriptPanel.js"></script>

</head>

<body>

<div class="loader-wrapper">
    <span class="loader"><span class="loader-inner"></span></span>
</div>

<div class="wrapper">
    <div class="cursor"></div>
    <!-- Sidebar  -->
    <nav id="sidebar"
         class="mCustomScrollbar _mCS_1 mCS-autoHide mCS_no_scrollbar"
         style="overflow: visible;">
        <div id="mCSB_1"
             class="mCustomScrollBox mCS-minimal mCSB_vertical mCSB_outside"
             style="max-height: none;" tabindex="0">
            <div id="mCSB_1_container"
                 class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y"
                 style="position: relative; top: 0; left: 0;" dir="ltr">
                <div class="sidebar-header">
                    <a class="logo" href="index.jsp">muy lejano <span
                            class="logo-span">PASS</span>
                    </a>
                </div>

                <ul class="list-unstyled components">
                    <p>Panel de control</p>
                    <li class="active"><a href="#homeSubmenu"
                                          data-toggle="collapse" aria-expanded="false"
                                          class="dropdown-toggle">Home</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li><a href="#">Home 1</a></li>
                            <li><a href="#">Home 2</a></li>
                            <li><a href="#">Home 3</a></li>
                        </ul>
                    </li>
                    <li><a href="#">About</a></li>
                    <li><a href="#pageSubmenu" data-toggle="collapse"
                           aria-expanded="false" class="dropdown-toggle">Pages</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li><a href="#">Page 1</a></li>
                            <li><a href="#">Page 2</a></li>
                            <li><a href="#">Page 3</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Portfolio</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>

            </div>
        </div>
        <div id="mCSB_1_scrollbar_vertical"
             class="mCSB_scrollTools mCSB_1_scrollbar mCS-minimal mCSB_scrollTools_vertical"
             style="display: none;">
            <div class="mCSB_draggerContainer">
                <div id="mCSB_1_dragger_vertical" class="mCSB_dragger"
                     style="position: absolute; min-height: 50px; height: 0; top: 0;">
                    <div class="mCSB_dragger_bar" style="line-height: 50px;"></div>
                </div>
                <div class="mCSB_draggerRail"></div>
            </div>
        </div>
    </nav>

    <!-- Page Content  -->
    <div class="container-fluid">
        <div class="contenedor">

            <section class="header" id="home">
                <div class="container">
                    <nav class="navbar navbar-expand-lg navbar-light nav-sticky-hijo">
                        <div class="container-fluid">
                            <p class="logo">
                                �Bienvenido,
                                <c:out value="${user.nombre}"/>
                                !
                            </p>
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
                                    <li class="nav-item dropdown"><a class="nav-link nav-a"
                                                                     href="#" id="navbarScrollingDropdown" role="button"
                                                                     data-bs-toggle="dropdown" aria-expanded="false">
                                        M�s </a>
                                        <ul class="dropdown-menu dropdown-menu-end"
                                            aria-labelledby="navbarScrollingDropdown">
                                            <li><a class="dropdown-item" href="index.jsp">Home</a>
                                            </li>
                                            <li><a class="dropdown-item" href="itinerario.jsp">Itinerario</a>
                                            </li>
                                            <li>
                                                <hr class="dropdown-divider"/>
                                            </li>
                                            <li><a type="button" href="index.jsp"
                                                   class="dropdown-item">Cerrar Sesi�n</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>

                    <h2 class="titulo">Atracciones</h2>

                    <table class="table table-stripped table-hover">
                        <thead>
                        <tr>
                            <th>Atracci&oacute;n</th>
                            <th>Costo</th>
                            <th>Duraci&oacute;n</th>
                            <th>Cupo</th>
                            <th>Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:out value="${attractions}"></c:out>
                        <c:forEach items="${attractions}" var="attraction">
                            <tr>
                                <td><strong>${attraction.nombre}</strong>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing
                                        elit. Cras pretium eros urna. Sed quis erat congue,
                                        bibendum tortor malesuada, iaculis diam. Ut ut imperdiet
                                        sapien.</p></td>
                                <td><c:out value="${attraction.costo}"></c:out></td>
                                <td><c:out value="${attraction.duracion}"></c:out></td>
                                <td><c:out value="${attraction.capacity}"></c:out></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </div>
</div>
</body>

</html>

