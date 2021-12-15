<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="es">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>Panel de Control/Usuarios</title>

    <!-- favicon -->

    <link rel="apple-touch-icon" sizes="180x180"
          href="img/favicon/apple-touch-icon.png"/>
    <link rel="icon" type="image/png" sizes="32x32"
          href="img/favicon/favicon-32x32.png"/>
    <link rel="icon" type="image/png" sizes="16x16"
          href="img/favicon/favicon-16x16.png"/>
    <link rel="manifest" href="img/favicon/site.webmanifest"/>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/BootstrapCss/bootstrap.min.css"/>
    <script defer src="js/BootstrapJs/bootstrap.min.js"></script>

    <!-- Css -->

    <link rel="stylesheet" href="css/panel.css"/>

    <!-- Jquery -->

    <script defer src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>

    <!-- Js -->

    <script defer src="js/panelDeControlJs/scriptPanel.js"></script>

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
                    <li><a href="panelDeControl.do"
                    >Atracciones</a></li>
                    <li><a href="panelDeControl_itinerarios.do">Itinerarios</a></li>
                    <li><a href="panelDeControl_promociones.do">Promociones</a></li>
                    <li class="active"><a href="panelDeControl_usuarios.do">Usuarios</a></li>
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
    <div id="content">
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
                    d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
          </svg></span>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="contenedor">

                <section class="header" id="home">
                    <div class="container">
                        <nav class="navbar navbar-expand-lg navbar-light nav-sticky-hijo">
                            <div class="container-fluid">
                                <p class="logo">
                                    ¡Bienvenido,
                                    <c:out value="${user.nombre}"/>!
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
                                                                         href="#" id="navbarScrollingDropdown"
                                                                         role="button"
                                                                         data-bs-toggle="dropdown"
                                                                         aria-expanded="false"> Más </a>
                                            <ul class="dropdown-menu dropdown-menu-end"
                                                aria-labelledby="navbarScrollingDropdown">
                                                <li><a class="dropdown-item" href="index.jsp">Home</a>
                                                </li>
                                                <li><a class="dropdown-item" href="itinerario.jsp">Itinerario</a>
                                                </li>
                                                <li>
                                                    <hr class="dropdown-divider"/>
                                                </li>
                                                <li><a type="button" href="logout"
                                                       class="dropdown-item">Cerrar Sesión</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </nav>

                        <c:if test="${flash != null}">
                            <div class="alert alert-danger">
                                <p>
                                    <c:out value="${flash}"/>
                                </p>
                            </div>
                        </c:if>
                        <br>

                        <h2 class="titulo">Usuarios</h2>
                        <br>
                        <a data-bs-target="#modalCreate" data-bs-toggle="modal"
                           class="btn boton-iniciarS" role="button"><i
                                class="bi bi-x-circle-fill">Agregar</i></a>
                        <br>
                        <br>
                        <table class="table table-stripped table-hover">
                            <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Dinero</th>
                                <th>Tiempo</th>
                                <th>Preferencia</th>
                                <th>Acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="users">
                                <tr <c:if test="${users.deleted}"> style="background-color: orangered"</c:if>>
                                    <td><strong>${users.nombre}</strong></td>
                                    <td><p><c:out value="${users.dineroDisponible}"></c:out></p></td>
                                    <td><c:out value="${users.tiempo}"></c:out>
                                    </td>
                                    <td><c:out value="${users.preferencia}"></c:out></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${users.deleted}">
                                                <a href="restoreUser?nombre=${users.nombre}"
                                                   class="btn boton-quiero-tabla" role="button"><i
                                                        class="bi bi-x-circle-fill">Alta</i></a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="deleteUser?nombre=${users.nombre}"
                                                   class="btn boton-iniciarS" role="button"><i
                                                        class="bi bi-x-circle-fill">Baja</i></a>
                                            </c:otherwise>
                                        </c:choose>
                                        <a data-bs-target="#modalEditUser_${users.id}" data-bs-toggle="modal"
                                           class="btn boton-iniciarS" role="button"><i
                                                class="bi bi-x-circle-fill">Modificar</i></a>
                                    </td>
                                </tr>
                                <div class="modal fade" id="modalEditUser_${users.id}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="ModalLabel">Ingrese datos a modificar</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="editUser" method="get">
                                                    <input type="hidden" name="id" value="${users.id}">
                                                    <div class="mb-3">
                                                            ${users.nombre}
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="password" class="col-form-label">Contraseña:</label>
                                                        <input class="form-control" type="text" id="password"
                                                               name="password"></input>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="money" class="col-form-label">Dinero:</label>
                                                        <input class="form-control" type="text" id="money"
                                                               name="money"
                                                               required value="${users.dineroDisponible}"></input>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="time" class="col-form-label">Tiempo:</label>
                                                        <input class="form-control" type="number" id="time" name="time"
                                                               required value="${users.tiempo}"></input>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="preference" class="col-form-label">Tipo: (Elija uno)</label>
                                                        <select class="form-control" id="preference" name="preference">
                                                            <c:forEach items="${types}" var="type">
                                                                <option value="${type}">${type}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn boton-quiero-tabla"
                                                                data-bs-dismiss="modal">
                                                            Cerrar
                                                        </button>
                                                        <button type="submit" class="btn boton-iniciarS">Guardar
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </section>

                <div class="modal fade" id="modalCreate" tabindex="-1"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="ModalC">Ingrese datos del usuario</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="createUser" method="get">
                                    <div class="mb-3">
                                        <label for="nameCreate" class="col-form-label">Nombre:</label>
                                        <input class="form-control" type="text" id="nameCreate" name="nameCreate"
                                               required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="passwordCreate" class="col-form-label">Contraseña:</label>
                                        <input class="form-control" type="text" id="passwordCreate" name="passwordCreate"
                                               required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="typeCreate" class="col-form-label">Preferencia: (Elija uno)</label>
                                        <select class="form-control" id="typeCreate" name="typeCreate">
                                            <c:forEach items="${types}" var="type">
                                                <option value="${type}">${type}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="moneyCreate" class="col-form-label">Dinero:</label>
                                        <input class="form-control" type="number" id="moneyCreate"
                                               name="moneyCreate"
                                               required></input>
                                    </div>
                                    <div class="mb-3">
                                        <label for="timeCreate" class="col-form-label">Tiempo:</label>
                                        <input class="form-control" type="number" id="timeCreate" name="timeCreate"
                                               required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn boton-quiero-tabla"
                                                data-bs-dismiss="modal">Cerrar
                                        </button>
                                        <button type="submit" class="btn boton-iniciarS">Guardar
                                        </button>
                                    </div>
                                </form>
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

