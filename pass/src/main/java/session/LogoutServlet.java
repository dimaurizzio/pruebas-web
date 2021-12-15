package session;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getSession().removeAttribute("user");
		req.setAttribute("flash", "Gracias por utilizar muy lejano PASS");
		
		RequestDispatcher dispatcher = getServletContext()
  		      .getRequestDispatcher("/index.do");
  		    dispatcher.forward(req, resp); 	
    }
}
