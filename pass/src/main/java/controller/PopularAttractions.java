package controller;

import java.io.IOException;
import java.util.List;

import atraccion.Atraccion;
import atraccion.Itinerario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;
import services.ItineraryService;


@WebServlet("/index.do")
public class PopularAttractions extends HttpServlet implements Servlet {

    private static final long serialVersionUID = 3039471316829931374L;
    private AttractionService attractionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.attractionService = new AttractionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Atraccion> attraction = attractionService.list();
        req.setAttribute("attraction", attraction);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}