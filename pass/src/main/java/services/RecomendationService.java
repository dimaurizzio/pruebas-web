package services;

import java.util.Collections;
import java.util.List;

import atraccion.Atraccion;
import comparador.Comparador;
import dao.DAOFactory;
import ofertable.Ofertable;
import promociones.Promocion;
import usuario.Usuario;

public class RecomendationService {

	public List<Atraccion> listAtraccion() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public List<Promocion> listPromo() {
		return DAOFactory.getPromociosDAO().findAll();
	}

	public static List<Promocion> ordenarListasPromo(Usuario usuario, List<Promocion> listPromocion) {

		Collections.sort(listPromocion, new Comparador(usuario.getPreferencia()));

		return listPromocion;
	}

	public static List<Atraccion> ordenarListasAtracc(Usuario usuario, List<Atraccion> listAtraccion) {

		Collections.sort(listAtraccion, new Comparador(usuario.getPreferencia()));

		return listAtraccion;
	}

	public static boolean yaLaCompro(Usuario usuario, Ofertable ofertable) {
		boolean laCompro = false;
		if (ofertable.esPromocion()) {
			if (usuario.comprasDeUsuario.contains(ofertable)) {
				laCompro = true;
			}
		} else {
			if (usuario.comprasDeUsuario.contains(ofertable)) {
				laCompro = true;
			}
		}
		return laCompro;
	}

	public static boolean puedeComprar(Usuario usuario, Ofertable ofertable) {
		boolean puede = true;

		if (usuario.getDineroDisponible() < ofertable.getCosto()) {
			puede = false;
		} else if (usuario.getTiempo() < ofertable.getDuracion()) {
			puede = false;
		} else if (yaLaCompro(usuario, ofertable)) {
			puede = false;
		} else if (ofertable.getLugaresDisponibles() == 0)
			puede = false;
		return puede;
	}

	public List<Atraccion> iterarAtraccion(Usuario usuario) {

		AttractionService attractionService = new AttractionService();
		List<Atraccion> listaAtracciones = attractionService.list();

		listaAtracciones = ordenarListasAtracc(usuario, listaAtracciones);

		for (Atraccion atraccion : listaAtracciones) {

			if (!puedeComprar(usuario, atraccion)) {
				listaAtracciones.remove(atraccion);
			}
		}
		return listaAtracciones;
	}

	public List<Promocion> iterarPromocion(Usuario usuario) {

		PromotionService promotionService = new PromotionService();
		List<Promocion> listaPromociones = promotionService.list();

		listaPromociones = ordenarListasPromo(usuario, listaPromociones);

		for (Promocion promocion : listaPromociones) {

			if (!puedeComprar(usuario, promocion)) {
				listaPromociones.remove(promocion);
			}
		}
		return listaPromociones;
	}
}
