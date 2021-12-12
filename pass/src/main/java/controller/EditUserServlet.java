package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.Userservice;
import tipos.Tipo;
import usuario.Usuario;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1322817578889859766L;
    private Userservice userservice;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userservice = new Userservice();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Tipo preference = Tipo.valueOf(req.getParameter("preference"));
            Integer money = Integer.parseInt(req.getParameter("money"));
            Double time = Double.parseDouble(req.getParameter("time"));

            Usuario user = null;

            user = userservice.update(id, money, time, preference);


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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}