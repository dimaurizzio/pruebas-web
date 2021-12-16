package services;

import atraccion.Atraccion;
import atraccion.Itinerario;
import dao.DAOFactory;
import ofertable.Ofertable;
import usuario.Usuario;

import java.util.List;

public class ItineraryService {

    public List<Itinerario> list() {
        return DAOFactory.getItinerarioDAO().findAll();
    }

    public List<Ofertable> listPersonal(Usuario user){
        return DAOFactory.getItinerarioDAO().itinerarioPersonal(user);
    }
}
