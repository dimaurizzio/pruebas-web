package dao;

import atraccion.Atraccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jdbc.ConnectionProvider;
import promociones.PromoAbsoluta;
import promociones.PromoPorcentual;
import promociones.PromoRegala;
import promociones.Promocion;
import tipos.Tipo;

public class PromocionDAOimpl implements PromocionDAO {

    public static List<Promocion> listaPromociones = new ArrayList<Promocion>();
    private Connection conn;

    private AtraccionDAO AtraccionDAO;

    public PromocionDAOimpl() {
        this.AtraccionDAO = new AtraccionDAO();
    }

    public Promocion findByName(String name) throws SQLException {
        try {
            String sql = "SELECT * FROM \"promociones\" WHERE nombre = ?";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultados = statement.executeQuery();

            Promocion promocion = null;

            if (resultados.next()) {
                promocion = toPromo(resultados);
            }

            return promocion;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }


    public List<Promocion> findAll() {
        try {
            String sql = "SELECT * FROM promociones";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultados = statement.executeQuery();
            List<Promocion> lista = new LinkedList<Promocion>();
            while (resultados.next()) {
                try {
                    Promocion promo = toPromo(resultados);
                    promo.agregarAtraccion(buscarPorId(resultados.getInt("Atraccion1")));
                    promo.agregarAtraccion(buscarPorId(resultados.getInt("Atraccion2")));
                    lista.add(promo);
                } catch (Exception e) {

                    throw new MissingDataException(e);
                }
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PromocionDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countAll() {
        try {
            String sql = "SELECT COUNT(1) AS TOTAL FROM Promocion";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultados = statement.executeQuery();

            resultados.next();
            int total = resultados.getInt("TOTAL");

            return total;
        } catch (SQLException ex) {
            Logger.getLogger(PromocionDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        return 0;
    }

    public int insert(Promocion t) {
        try {
            String sql = "INSERT INTO Promocion  (nombre ,Tipo,monto,AtraccionGratis,Descuento) VALUES "
                    + "(?,?,?,?,?,?)";
            conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getNombre());
            statement.setObject(2, t.getTipo());
            statement.setDouble(3, t.getCosto());
            statement.setObject(5, PromoRegala.getRegalo());
            statement.setDouble(6, ((PromoPorcentual) t).getPorcentaje());

            int rows = statement.executeUpdate();

            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(PromocionDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
        return 0;
    }

    public int update(Promocion t) {
        try {
            String sql = "UPDATE Promocion SET Nombre = ? WHERE Tipo  = ?";
            conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getNombre());
            statement.setObject(2, t.getTipo());
            int rows = statement.executeUpdate();

            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(PromocionDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
        return 0;
    }

    @Override
    public int delete(Promocion promocion) {
        try {
            String sql = "UPDATE promociones SET deleted = '1' WHERE nombre = ?";
            conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocion.getNombre());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new MissingDataException(e);
        }
        return 1;
    }

    private Promocion toPromo(ResultSet resultados) throws Exception {

        Tipo tipoAtraccion = Tipo.valueOf(resultados.getString(6));
        String breveDescripcion = resultados.getString(9);
        String nombre = resultados.getString(1);
        String promocionTipo = resultados.getString(2);
        Boolean deleted = resultados.getBoolean(10);
        Promocion promo = null;
        promo = crearPromo(resultados, tipoAtraccion, breveDescripcion, nombre, promocionTipo, promo, deleted);
        return promo;

    }

    private Promocion crearPromo(ResultSet resultados, Tipo tipo, String breveDescripcion,
                                 String nombre, String promocionTipo, Promocion promo, Boolean deleted) throws SQLException {
        if (promocionTipo.equals("AxB")) {
            Atraccion gratis = buscarPorId(resultados.getInt(4));
            promo = new PromoRegala(nombre, tipo, gratis, breveDescripcion, deleted);
        } else if (promocionTipo.equals("PORCENTUAL")) {
            int descuento = resultados.getInt(5);
            promo = new PromoPorcentual(nombre, tipo, descuento, breveDescripcion, deleted);
        } else if (promocionTipo.equals("NETO")) {
            int descuento = resultados.getInt(3);
            promo = new PromoAbsoluta(nombre, tipo, descuento, breveDescripcion, deleted);
        }
        return promo;
    }

    public Atraccion[] atraccionesDeLaPromocion(Long atraccion1, Long atraccion2) throws Exception {
        Atraccion[] promos = new Atraccion[2];
        try {

            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sqlAtraccion());
            statement.setLong(1, atraccion1);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                promos[0] = AtraccionDAO.toAtraccion(result);
            }
            statement.setLong(1, atraccion2);
            ResultSet result2 = statement.executeQuery();
            while (result2.next()) {
                promos[1] = AtraccionDAO.toAtraccion(result2);
                //promos[1] = AtraccionDAO.toAtraccion(result2);
            }
            return promos;
        } catch (SQLException e) {
            throw new Exception();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String sqlAtraccion() {
        String sql = "select *" + "from atracciones WHERE id = ?";
        return sql;
    }

    public Atraccion buscarPorId(int atraccionID) throws SQLException {
        try {
            String sql = "SELECT * FROM \"atracciones\" WHERE id = ?";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, atraccionID);
            ResultSet resultados = statement.executeQuery();

            Atraccion atraccion = null;

            if (resultados.next()) {
                atraccion = AtraccionDAO.toAtraccion(resultados);
            }

            return atraccion;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    public void restore(Promocion promocion) {
        try {
            String sql = "UPDATE promociones SET deleted = '0' WHERE nombre = ?";
            conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocion.getNombre());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }
}
