package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import atraccion.Atraccion;
import jdbc.ConnectionProvider;
import tipos.Tipo;
import usuario.NullUser;
import usuario.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private Connection conn;

    @Override
    public void restore(Usuario user) {
        try {
            String sql = "UPDATE usuarios SET deleted = '0' WHERE nombre = ?";
            conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getNombre());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    @Override
    public List<Usuario> findAll() {
        try {
            String sql = "SELECT * FROM usuarios";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultados = statement.executeQuery();

            List<Usuario> usuarios = new LinkedList<Usuario>();
            while (resultados.next()) {
                usuarios.add(toUser(resultados));
            }

            return usuarios;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }
    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public int insert(Usuario t) {
        try {
            String sql = "INSERT INTO usuarios (nombre, password, dinero, tiempo, preferencia) VALUES (?, ?, ?, ?, ?)";
            Connection conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getNombre());
            statement.setString(2, t.getPassword());
            statement.setInt(3, t.getDineroDisponible());
            statement.setDouble(4, t.getTiempo());
            statement.setString(5, t.getPreferencia().toString());
            int rows = statement.executeUpdate();

            return rows;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    @Override
    public int update(Usuario t) {
        try {
            String sql = "UPDATE usuarios SET dinero = ?, tiempo = ?, preferencia = ? WHERE id = ?";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, t.getDineroDisponible());
            statement.setDouble(2, t.getTiempo());
            statement.setString(3, t.getPreferencia().toString());
            statement.setInt(4, t.getId());
            int rows = statement.executeUpdate();

            return rows;

        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    public void createArray() {
        try {
            String sql = "SELECT * FROM usuarios";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int dineroDisponible = rs.getInt("dinero");
                Tipo preferencia = Tipo.valueOf(rs.getString("preferencia"));
                int tiempo = rs.getInt("tiempo");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("password");

                listaUsuarios.add(new Usuario(nombre, dineroDisponible, preferencia, tiempo, id, password, admin, false));
            }

        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    public void actualizarDBUsuarios() {
        for (Usuario usuario : listaUsuarios) {
            this.update(usuario);
        }

    }

    @Override
    public int delete(Usuario t) {
        try {
            String sql = "UPDATE usuarios SET deleted = '1' WHERE nombre = ?";
            conn = ConnectionProvider.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getNombre());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new MissingDataException(e);
        }
        return 1;
    }


    public Usuario findByUsername(String username) {
        try {
            String sql = "SELECT * FROM usuarios WHERE nombre = ?";
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            Usuario user = NullUser.build();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int dineroDisponible = rs.getInt("dinero");
                Tipo preferencia = Tipo.valueOf(rs.getString("preferencia"));
                int tiempo = rs.getInt("tiempo");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("password");

                user = new Usuario(nombre, dineroDisponible, preferencia, tiempo, id, password, admin, false);
            }

            return user;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    private Usuario toUser(ResultSet userRegister) throws SQLException {
        return new Usuario(userRegister.getString("nombre"), userRegister.getInt("dinero"), Tipo.valueOf(userRegister.getString("preferencia")), userRegister.getDouble("tiempo"), userRegister.getInt("id"), userRegister.getString("password"), userRegister.getBoolean("admin"), userRegister.getBoolean("deleted"));
    }

    @Override
    public Usuario findByAtraccionId(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultados = statement.executeQuery();

            Usuario usuario = null;

            if (resultados.next()) {
                usuario = toUser(resultados);
            }

            return usuario;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

}

