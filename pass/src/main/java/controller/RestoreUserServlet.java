package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AttractionService;
import services.Userservice;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/restoreUser")
public class RestoreUserServlet extends HttpServlet {

    private static final long serialVersionUID = -7854298822454533486L;
    private Userservice userservice;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userservice = new Userservice();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");

            userservice.restore(nombre);

        resp.sendRedirect("panelDeControl_usuarios.do");
    }


}
