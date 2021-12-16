package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import atraccion.Itinerario;
import jdbc.ConnectionProvider;
import ofertable.Ofertable;

public class ItinerarioDAO {
    private Connection conn;

    public static List<Itinerario> findAll(){
        try {
            String sql = "SELECT * FROM itinerario";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultados = statement.executeQuery();
            UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
            List<Itinerario> itinerarios = new LinkedList<>();
            while (resultados.next()) {
                int id = resultados.getInt("id_usuario");
                String compra = resultados.getString("compra");
                String nombre = usuarioDAO.findByAtraccionId(id).getNombre();

                if (isRepeated(itinerarios, id) == -1){
                    Itinerario i = new Itinerario(id, nombre);
                    i.getCompras().add(compra);
                    itinerarios.add(i);
                } else {
                    for (Itinerario actual : itinerarios){
                        if (actual.getId().equals(id)){
                            actual.getCompras().add(compra);
                        }
                    }
                }
            }
            return itinerarios;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    public static int isRepeated (List<Itinerario> list, int id) {
        for (Itinerario actual : list) {
            if (actual.getId().equals(id)) {
                return actual.getId();
            }
        }
        return -1;
    }

    public static void agregarPromocion(Ofertable promocion, int id) {
        try {
            String sql = "INSERT INTO itinerario (id_usuario, compra) VALUES (?, ?)";
            Connection conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            statement.setString(2, promocion.getNombre());
            statement.executeUpdate();


        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    public static void agregarAtraccion(Ofertable atraccion, int id) {
        try {
            String sql = "INSERT INTO itinerario (id_usuario, compra) VALUES (?, ?)";
            Connection conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            statement.setString(2, atraccion.getNombre());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }


    public boolean tieneCompra(int id, Ofertable ofertable) {
        try {
            String sql = "SELECT * FROM itinerario WHERE id_usuario = ? AND compra = ?";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, ofertable.getNombre());
            ResultSet resultados = statement.executeQuery();

            if (resultados.getString("compra").equals(ofertable.getNombre())){
                return true;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

