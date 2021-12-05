package services;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import dao.DAOFactory;
import tipos.Tipo;

import java.sql.SQLException;
import java.util.List;

public class AttractionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String name, Integer cost, Tipo tipo, Double duration, Integer capacity, String descripcion) throws SQLException {

		Atraccion attraction = new Atraccion(-1, name, tipo, cost, duration, capacity, descripcion);

		if (attraction.isValid()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
			attractionDAO.insert(attraction);
		}

		return attraction;
	}

	public Atraccion update(Integer id, String name, Integer cost, Double duration, Integer capacity) throws SQLException {

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = attractionDAO.findByAtraccionId(id);

		attraction.setNombre(name);
		attraction.setCosto(cost);
		attraction.setDuracion(duration);
		attraction.setCupoMaximo(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
		}

		return attraction;
	}

	public void delete(Integer id) throws SQLException {
		Atraccion attraction = new Atraccion(id, null, null, null, null, null, null);

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) throws SQLException {
		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		return attractionDAO.findByAtraccionId(id);
	}

}
