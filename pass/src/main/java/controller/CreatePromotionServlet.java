package controller;

import java.io.IOException;
import java.sql.SQLException;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import dao.PromocionDAOimpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import promociones.PromoAbsoluta;
import promociones.PromoPorcentual;
import promociones.PromoRegala;
import promociones.Promocion;
import services.AttractionService;
import services.PromotionService;
import tipos.Tipo;

@WebServlet("/createPromotion")
public class CreatePromotionServlet extends HttpServlet {

    private static final long serialVersionUID = 3951235080038737997L;
    private PromotionService promotionService;
    private AtraccionDAO atraccionDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        this.promotionService = new PromotionService();
        this.atraccionDAO = new AtraccionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("nameCreate");
            Tipo type = Tipo.valueOf(req.getParameter("typeCreate"));
            String attraction1 = req.getParameter("attraction1");
            String attraction2 = req.getParameter("attraction2");
            Integer discount = Integer.parseInt(req.getParameter("discount"));
            String description = req.getParameter("description");
            String promotionTipe = req.getParameter("promotionTipe");

            Promocion promotion = null;

            if (promotionTipe.equals("AxB")) {
                String free = req.getParameter("Free");
                Atraccion gratis = atraccionDAO.findByAtraccionName(free);
                promotion = new PromoRegala(name, type, gratis, description, false);
                promotionService.create(promotion);
            } else if (promotionTipe.equals("PORCENTUAL")) {
                int descuento = discount;
                promotion = new PromoPorcentual(name, type, descuento, description, false);
                promotionService.create(promotion);
            } else if (promotionTipe.equals("NETO")) {
                int descuento = discount;
                promotion = new PromoAbsoluta(name, type, descuento, description, false);
                promotionService.create(promotion);
            }

            if (promotion.isValid()) {
                resp.sendRedirect("panelDeControl_promociones.do");
            } else {
                req.setAttribute("flash", promotion.errors.values());

                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher("/panelDeControl_promociones.do");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("flash", "Ingrese correctamente todos los campos");

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/panelDeControl_promociones.do");
            dispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
