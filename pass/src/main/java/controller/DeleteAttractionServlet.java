package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteAttractionServlet extends HttpServlet {

    private static final long serialVersionUID = 1537949074766873118L;
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
            attractionService.delete(nombre);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("panelDeControl.do");
    }


}
