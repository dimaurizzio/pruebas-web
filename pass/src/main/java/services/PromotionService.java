package services;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.PromocionDAO;
import dao.PromocionDAOimpl;
import promociones.Promocion;
import java.sql.SQLException;
import java.util.List;

public class PromotionService {

    public List<Promocion> list() {
        return DAOFactory.getPromociosDAO().findAll();
    }

    public void delete(String nombre) throws SQLException {
        PromocionDAOimpl promocionDAO = new PromocionDAOimpl();
        Promocion promotion = promocionDAO.findByName(nombre);
        promocionDAO.delete(promotion);
    }

    public Atraccion find(Integer id) throws SQLException {
        AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
        return attractionDAO.findByAtraccionId(id);
    }

    public void restore(String nombre) throws SQLException{
        PromocionDAOimpl promocionDAO = new PromocionDAOimpl();
        Promocion promocion = promocionDAO.findByName(nombre);
        promocionDAO.restore(promocion);
    }

    public void create(Promocion promocion) throws SQLException {

        if (promocion.isValid()) {
            PromocionDAO promocionDAO = DAOFactory.getPromociosDAO();
            promocionDAO.insert(promocion);
        }
    }

}
