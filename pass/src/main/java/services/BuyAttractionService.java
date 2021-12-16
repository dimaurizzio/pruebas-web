package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import atraccion.Atraccion;
import dao.*;
import ofertable.Ofertable;
import usuario.Usuario;

public class BuyAttractionService {

    AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
    PromocionDAOimpl promocionDAOimpl = new PromocionDAOimpl();
    UsuarioDAOImpl userDAO = new UsuarioDAOImpl();

    public Map<String, String> buy(Integer userId, String nombre) {
        Map<String, String> errors = new HashMap<String, String>();
        Ofertable attraction = null;
        Usuario user = null;

        try {
            if (promocionDAOimpl.findByName(nombre) != null) {
                user = userDAO.findByAtraccionId(userId);
                attraction = promocionDAOimpl.buscarPromo(nombre);
                user.comprar(attraction);
            } else {

                user = userDAO.findByAtraccionId(userId);
                attraction = attractionDAO.findByAtraccionName(nombre);


                if (attraction.getCupoMaximo() < 1) {
                    errors.put("attraction", "No hay cupo disponible");
                }
                if (user.getDineroDisponible() < attraction.getCosto()) {
                    errors.put("user", "No tienes dinero suficiente");
                }
                if (user.getTiempo() < attraction.getDuracion()) {
                    errors.put("user", "No tienes tiempo suficiente");
                }

                if (errors.isEmpty()) {
                    user.comprar(attraction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return errors;
    }

}
