package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import usuario.Usuario;

import java.io.IOException;

@WebFilter(filterName = "adminFilter")
public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Usuario user = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user != null) {
            if (user.isAdmin()) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("flash", "Necesita ser administrador");

                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("flash", "Por favor, ingresa al sistema");

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

    }

}
