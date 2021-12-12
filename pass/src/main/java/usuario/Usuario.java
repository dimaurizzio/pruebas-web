package usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import atraccion.Atraccion;
import dao.AtraccionDAO;
import dao.ItinerarioDAO;
import dao.MissingDataException;
import jdbc.ConnectionProvider;
import ofertable.Ofertable;
import promociones.Promocion;
import tipos.Tipo;
import utils.Crypt;

public class Usuario {

    private final int id;
    private final String nombre;
    private int dineroDisponible;
    private final int dineroInicial;
    private final double tiempoInicial;
    private Tipo preferencia;
    private double tiempo;
    public final ArrayList<Atraccion> atraccionesCompradas = new ArrayList<Atraccion>();
    public final ArrayList<Promocion> promocionesCompradas = new ArrayList<Promocion>();
    public final ArrayList<Atraccion> comprasDeUsuario = new ArrayList<Atraccion>();
    private String password;
    private boolean admin;
    public HashMap<String, String> errors;
    private boolean deleted;



    public Usuario(String nombre, int dineroDisponible, Tipo preferencia, double tiempo, int id, String password, boolean admin, boolean deleted) {
        this.id = id;
        this.nombre = nombre;
        this.dineroInicial = dineroDisponible;
        this.tiempoInicial = tiempo;
        this.dineroDisponible = dineroDisponible;
        this.preferencia = preferencia;
        this.tiempo = tiempo;
        this.password = password;
        this.admin = admin;
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean checkPassword(String password) {
        return Crypt.match(password, this.password);
    }
    public boolean isNull() {
        return false;
    }

    public int getId() {
        return id;
    }

    public int getDineroInicial() {
        return dineroInicial;
    }

    public double getTiempoInicial() {
        return tiempoInicial;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double d) {
        this.tiempo = d;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDineroDisponible(int d) {
        this.dineroDisponible = d;
    }

    public int getDineroDisponible() {
        return dineroDisponible;
    }

    public Tipo getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Tipo tipo){this.preferencia = tipo;}

    public void comprar(Ofertable o) {
        if (o.esPromocion()) {
            this.restarDinero(o);
            this.restarTiempo(o);
            promocionesCompradas.add((Promocion) o);
            comprasDeUsuario.addAll(((Promocion) o).getAtracciones());

            ItinerarioDAO.agregarPromocion(o, this.getId());

            ((Promocion) o).atraccionesDePromo.forEach((atraccion) -> {
                this.restarCupo(atraccion);
            });

        } else {
            this.restarDinero(o);
            this.restarTiempo(o);
            this.restarCupo(o);
            atraccionesCompradas.add((Atraccion) o);
            comprasDeUsuario.add((Atraccion) o);

            ItinerarioDAO.agregarAtraccion(o, this.getId());

        }

    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void restarCupo(Ofertable ofertable) {
        ((Atraccion) ofertable).entrarALaAtraccion();
        AtraccionDAO.actualizarCupo(ofertable);
    }

    public void restarTiempo(Ofertable ofertable) {
        this.setTiempo(this.getTiempo() - (ofertable).getDuracion());
        try {
            String sql = "UPDATE usuarios SET tiempo = tiempo - ? WHERE id = ?";
            Connection conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, ofertable.getDuracion());
            statement.setInt(2, this.id);
            statement.executeUpdate();


        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }


    public void restarDinero(Ofertable ofertable) {
        this.setDineroDisponible(this.getDineroDisponible() - ofertable.getCosto());
        try {
            String sql = "UPDATE usuarios SET dinero = dinero - ? WHERE id = ?";
            Connection conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ofertable.getCosto());
            statement.setInt(2, this.id);
            statement.executeUpdate();


        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", dineroDisponible=" + dineroDisponible + ", preferencia="
                + preferencia + ", tiempo=" + tiempo + '}';
    }

    public boolean isValid() {
        validate();
        return errors.isEmpty();
    }

    public void validate() {
        errors = new HashMap<String, String>();

        if (dineroDisponible < 0) {
            errors.put("coins", "Dinero no debe ser negativo");
        }
        if (tiempo < 0) {
            errors.put("time", "Tiempo no debe ser negativo");
        }
        if (nombre == ""){
            errors.put("name", "Debe completar el nombre");
        }
        if (password == ""){
            errors.put("password", "Debe completar la contraseña");
        }
    }
}
