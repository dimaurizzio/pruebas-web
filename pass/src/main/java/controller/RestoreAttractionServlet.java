package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AttractionService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/restore")
public class RestoreAttractionServlet extends HttpServlet {

    private static final long serialVersionUID = -7854298822454533486L;
    private AttractionService attractionService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.attractionService = new AttractionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");

        try {
            attractionService.restore(nombre);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("panelDeControl.do");
    }


}
