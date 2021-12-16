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
import ofertable.Ofertable;
import services.ItineraryService;
import usuario.Usuario;

@WebServlet("/personalItinerary.do")
public class ListPersonalItineraryServlet extends HttpServlet implements Servlet {

    private static final long serialVersionUID = 7827962565281014110L;
    private ItineraryService itineraryService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.itineraryService = new ItineraryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        List<Ofertable> itinerary = itineraryService.listPersonal(user);
        req.setAttribute("itinerary", itinerary);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/personalItinerary.jsp");
        dispatcher.forward(req, resp);
    }
}