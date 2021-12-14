package controller;

import java.io.IOException;
import java.util.List;

import atraccion.Itinerario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ItineraryService;

@WebServlet("/panelDeControl_itinerarios.do")
public class ListItineraryServlet extends HttpServlet implements Servlet {

    private static final long serialVersionUID = 3039471316829931374L;
    private ItineraryService itineraryService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.itineraryService = new ItineraryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Itinerario> itinerary = itineraryService.list();
        req.setAttribute("itinerary", itinerary);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/panelDeControl_itinerarios.jsp");
        dispatcher.forward(req, resp);
    }
}