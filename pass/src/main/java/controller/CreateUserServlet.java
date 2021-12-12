package controller;

import java.io.IOException;
import java.sql.SQLException;

import atraccion.Atraccion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.Userservice;
import tipos.Tipo;
import usuario.Usuario;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {

    private static final long serialVersionUID = 565971281443577889L;
    private Userservice userservice;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userservice = new Userservice();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("nameCreate");
            Tipo type = Tipo.valueOf(req.getParameter("typeCreate"));
            Integer money = Integer.parseInt(req.getParameter("moneyCreate"));
            Double time = Double.parseDouble(req.getParameter("timeCreate"));
            String password = req.getParameter("passwordCreate");

            Usuario user = null;
            user = userservice.create(name, password, money, time, type);

            if (user.isValid()) {
                resp.sendRedirect("panelDeControl_usuarios.do");
            } else {
                req.setAttribute("flash", user.errors.values());

                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher("/panelDeControl_usuarios.do");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("flash", "Ingrese correctamente todos los campos");

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/panelDeControl_usuarios.do");
            dispatcher.forward(req, resp);
        }
    }
}
