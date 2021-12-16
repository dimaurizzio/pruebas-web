package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import dao.DAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.BuyAttractionService;
import usuario.Usuario;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {

    private static final long serialVersionUID = 3455721046062278592L;
    private BuyAttractionService buyAttractionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.buyAttractionService = new BuyAttractionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        Map<String, String> errors = buyAttractionService.buy(user.getId(), nombre);

        Usuario user2 = null;
        try {
            user2 = DAOFactory.getUsuarioDAO().findByAtraccionId(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("user", user2);

        if (errors.isEmpty()) {
            req.setAttribute("success", "¡Gracias por su compra!");
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("flash", "No ha podido realizarse la compra");
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/recomendaciones.do");
        dispatcher.forward(req, resp);
    }
}
