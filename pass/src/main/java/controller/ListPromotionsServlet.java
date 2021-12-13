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
import promociones.Promocion;
import services.AttractionService;
import services.PromotionService;

@WebServlet("/panelDeControl_promociones.do")
public class ListPromotionsServlet extends HttpServlet implements Servlet {

    private static final long serialVersionUID = 1910289517059726826L;
    private PromotionService promotionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.promotionService = new PromotionService();
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Promocion> promotions = promotionService.list();
        req.setAttribute("promotions", promotions);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/panelDeControl_promociones.jsp");
        dispatcher.forward(req, resp);
    }
}