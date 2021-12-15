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
import services.RecomendationService;
import usuario.Usuario;



@WebServlet("/index.do")
public class RecomendationServlet extends HttpServlet implements Servlet {

  
	private static final long serialVersionUID = 3302529498089859809L;
	private RecomendationService recomendationService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.recomendationService = new RecomendationService();
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Usuario user = (Usuario) req.getSession().getAttribute("user");
    	List<Promocion> promocion = recomendationService.iterarPromocion(user);
        List<Atraccion> atraccion = recomendationService.iterarAtraccion(user);
        
        req.setAttribute("promotions", promocion);
        req.setAttribute("attractions", atraccion);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}