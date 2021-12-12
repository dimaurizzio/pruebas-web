package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;
import services.Userservice;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1537949074766873118L;
    private Userservice userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = new Userservice();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");

        try {
            userService.delete(nombre);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("panelDeControl_usuarios.do");
    }


}
