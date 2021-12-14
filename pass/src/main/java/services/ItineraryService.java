package services;

import atraccion.Itinerario;
import dao.DAOFactory;
import java.util.List;

public class ItineraryService {

    public List<Itinerario> list() {
        return DAOFactory.getItinerarioDAO().findAll();
    }
}
