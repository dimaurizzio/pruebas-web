package promociones;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import ofertable.Ofertable;
import tipos.Tipo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class PromoAbsoluta extends Promocion implements Ofertable {

	private Integer descuento = 0;
	private String breveDescripcion;
	Integer costoTotal = 0;
	private String tipoP = "Absoluta";


	public PromoAbsoluta(String nombre, Tipo tipo, int descuento, String breveDescripcion, boolean deleted) {
		super(nombre, tipo, deleted);
		this.descuento = descuento;
		this.breveDescripcion = breveDescripcion;
	}

	public String getTipoP() {
		return tipoP;
	}

	public void setTipoP(String tipoP) {
		this.tipoP = tipoP;
	}

	@Override
	public Integer getCosto() {
		costoTotal = 0;
		for (Atraccion atracciones : atraccionesDePromo) {
			this.costoTotal += atracciones.getCosto();
		}

		return this.costoTotal - this.descuento;
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
