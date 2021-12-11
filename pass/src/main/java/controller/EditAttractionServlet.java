package controller;

import atraccion.Atraccion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AttractionService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditAttractionServlet extends HttpServlet {

    private static final long serialVersionUID = 7598291131560345626L;
    private AttractionService attractionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.attractionService = new AttractionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String description = req.getParameter("description");
        Integer capacity = Integer.parseInt(req.getParameter("capacity"));
        Integer cost = Integer.parseInt(req.getParameter("cost"));
        Double duration = Double.parseDouble(req.getParameter("duration"));

        Atraccion attraction = null;

            attraction = attractionService.update(id, cost, duration, capacity, description);


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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}