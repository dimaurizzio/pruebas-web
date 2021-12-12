package controller;

import java.io.IOException;
import java.util.List;

import atraccion.Atraccion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;
import services.Userservice;
import usuario.Usuario;

@WebServlet("/panelDeControl_usuarios.do")
public class ListUsersServlet extends HttpServlet implements Servlet {

    private static final long serialVersionUID = -8346640902238722429L;
    private Userservice userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = new Userservice();
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> users = userService.list();
        List<String> tipos = userService.types();
        req.setAttribute("types", tipos);
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/panelDeControl_usuarios.jsp");
        dispatcher.forward(req, resp);
    }
}