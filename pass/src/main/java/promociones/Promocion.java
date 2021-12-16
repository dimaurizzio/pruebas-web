package promociones;

import java.sql.SQLException;
import java.util.*;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import ofertable.Ofertable;
import tipos.Tipo;


public abstract class Promocion implements Ofertable {

	private String nombre;
	private boolean deleted;
	private Tipo tipoAtracciones; // DE ATRACCION
	public ArrayList<Atraccion> atraccionesDePromo = new ArrayList<Atraccion>();
	public Map<String, String> errors;


	public ArrayList<Atraccion> getAtraccionesDePromo() {
		return atraccionesDePromo;
	}

	public void setAtraccionesDePromo(ArrayList<Atraccion> atraccionesDePromo) {
		this.atraccionesDePromo = atraccionesDePromo;
	}

	public Promocion(String nombre, Tipo tipo, boolean deleted) {
		this.nombre = nombre;
		this.tipoAtracciones = tipo;
		this.deleted = deleted;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void agregarAtraccion(Atraccion nuevaAtraccion) {
		atraccionesDePromo.add(nuevaAtraccion);
	}

	public ArrayList<Atraccion> getAtracciones() {
		return this.atraccionesDePromo;
	}

	public Double getDuracion() {
		Double duracionTotal = 0.0;
		Iterator<Atraccion> iteradorDuracion = atraccionesDePromo.iterator();
		while (iteradorDuracion.hasNext()) {
			Atraccion a = iteradorDuracion.next();
			duracionTotal += a.getDuracion();
		}
		return duracionTotal;
	}

	public Tipo getTipo() {
		return this.tipoAtracciones;
	}

	public abstract Integer getCosto();

	public boolean esPromocion() {
		return true;
	}

	public boolean esPromocionRegala() {
		return false;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Tipo getTipoAtraccion() {
		return this.tipoAtracciones;
	}

	public Integer getCupoMaximo() {
		return null;
	}

	@Override
	public String toString() {
		return "Promocion{" +
				"nombre='" + nombre + '\'' +
				", deleted=" + deleted +
				", tipoAtracciones=" + tipoAtracciones +
				", atraccionesDePromo=" + atraccionesDePromo +
				", errors=" + errors +
				'}';
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (this.getCosto() <= 0) {
			errors.put("cost", "Costo debe ser positivo");
		}
		if (!this.getAtraccionesDePromo().get(0).getTipo().toString().equals(this.getAtraccionesDePromo().get(1).getTipo().toString())){
			errors.put("duration", "Las atracciones y el tipo deben coincidir");
		}

		if (nombre == ""){
			errors.put("name", "Debe completar el nombre");
		}
		if (this.getBreveDescripcion() == ""){
			errors.put("description", "Debe completar la descripcion");
		}
	}

	public Integer getLugaresDisponibles() {
		ArrayList<Integer> lugares = new ArrayList<Integer>();
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		ArrayList<Atraccion> atraccioneslist = new ArrayList<Atraccion>();

		try {
			Atraccion atraccion1 = atraccionDAO.findByAtraccionId(atraccionesDePromo.get(0).getId());
			Atraccion atraccion2 = atraccionDAO.findByAtraccionId(atraccionesDePromo.get(1).getId());
			return Math.min(atraccion1.getCupoMaximo(), atraccion2.getCupoMaximo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
