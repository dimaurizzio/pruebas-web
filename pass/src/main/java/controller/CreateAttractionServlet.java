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
import services.AttractionService;
import tipos.Tipo;

@WebServlet("/create")
public class CreateAttractionServlet extends HttpServlet {

    private static final long serialVersionUID = 3455721046062278592L;
    private AttractionService attractionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.attractionService = new AttractionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("nameCreate");
            Integer cost = Integer.parseInt(req.getParameter("costCreate"));
            Double duration = Double.parseDouble(req.getParameter("durationCreate"));
            Integer capacity = Integer.parseInt(req.getParameter("capacityCreate"));
            String description = req.getParameter("descriptionCreate");
            Tipo type = Tipo.valueOf(req.getParameter("typeCreate"));

            Atraccion attraction = null;
            attraction = attractionService.create(name, cost, type, duration, capacity, description);

            if (attraction.isValid()) {
                resp.sendRedirect("panelDeControl.do");
            } else {
                req.setAttribute("flash", attraction.errors.values());

                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher("/panelDeControl.do");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("flash", "Ingrese correctamente todos los campos");

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/panelDeControl.do");
            dispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
