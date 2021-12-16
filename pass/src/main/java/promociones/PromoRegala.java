package promociones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import atraccion.Atraccion;
import ofertable.Ofertable;
import tipos.Tipo;

public class PromoRegala extends Promocion implements Ofertable {

	static Atraccion regalo;
	private String breveDescripcion;
	private String tipoP = "Regalo";

	public PromoRegala(String nombre, Tipo tipo, Atraccion regalo, String breveDescripcion, boolean deleted) {
		super(nombre, tipo, deleted);
		PromoRegala.regalo = regalo;
		this.breveDescripcion = breveDescripcion;
	}

	public static Atraccion getRegalo() {
		return regalo;
	}

	public String getTipoP() {
		return tipoP;
	}

	public void setTipoP(String tipoP) {
		this.tipoP = tipoP;
	}

	@Override
	public Integer getCosto() {
		Integer costoTotal = 0;
		Iterator<Atraccion> iteradorCosto = getAtracciones().iterator();
		while (iteradorCosto.hasNext()) {
			Atraccion a = iteradorCosto.next();
			costoTotal += a.getCosto();
		}
		costoTotal -= regalo.getCosto();
		return costoTotal;
	}

	@Override
	public boolean esPromocionRegala() {
		return true;
	}


	@Override
	public void setLugaresDisponibles(Integer lugaresDisponibles) {
	}

	@Override
	public String getBreveDescripcion() {
		return breveDescripcion;
	}

	@Override
	public Tipo getTipo() {
		return this.getTipoAtraccion();
	}

}
