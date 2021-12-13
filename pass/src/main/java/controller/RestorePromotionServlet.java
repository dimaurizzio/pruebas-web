package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AttractionService;
import services.PromotionService;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/restorePromotion")
public class RestorePromotionServlet extends HttpServlet {

    private static final long serialVersionUID = -7103600744808286691L;
    private PromotionService promotionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.promotionService = new PromotionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");

        try {
            promotionService.restore(nombre);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("panelDeControl_promociones.do");
    }


}
