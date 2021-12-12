package services;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import dao.DAOFactory;
import tipos.Tipo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AttractionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String name, Integer cost, Tipo tipo, Double duration, Integer capacity, String descripcion) throws SQLException {

		Atraccion attraction = new Atraccion(-1, name, tipo, cost, duration, capacity, descripcion, false);

		if (attraction.isValid()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
			attractionDAO.insert(attraction);
		}

		return attraction;
	}

	public Atraccion update(Integer id, Integer cost, Double duration, Integer capacity, String description) throws SQLException {

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = attractionDAO.findByAtraccionId(id);

		attraction.setCosto(cost);
		attraction.setDuracion(duration);
		attraction.setCupoMaximo(capacity);
		attraction.setBreveDescripcion(description);


		if (attraction.isValid()) {
			attractionDAO.update(attraction);
		}

		return attraction;
	}

	public void delete(String nombre) throws SQLException {
		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = attractionDAO.findByAtraccionName(nombre);
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) throws SQLException {
		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		return attractionDAO.findByAtraccionId(id);
	}

	public void restore(String nombre) throws SQLException{
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = atraccionDAO.findByAtraccionName(nombre);
		atraccionDAO.restore(attraction);
	}

    public List<String> types() {
		List<String> typesL = new LinkedList<>();
		for (Tipo tipo : Tipo.values()){
			typesL.add(tipo.toString());
		}
		return typesL;

    }
}
