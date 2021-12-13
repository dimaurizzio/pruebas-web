package promociones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import atraccion.Atraccion;
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
		if (this.getDuracion() <= 0) {
			errors.put("duration", "Duracion debe ser positivo");
		}
		if (this.getCupoMaximo() <= 0) {
			errors.put("capacity", "Capacidad debe ser positivo");
		}
		if (nombre == ""){
			errors.put("name", "Debe completar el nombre");
		}
		if (this.getBreveDescripcion() == ""){
			errors.put("description", "Debe completar la descripcion");
		}
	}
}
