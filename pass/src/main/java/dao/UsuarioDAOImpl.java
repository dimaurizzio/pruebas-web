package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;
import tipos.Tipo;
import usuario.NullUser;
import usuario.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private Connection conn;

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public int insert(Usuario t) {
        return 0;
    }

    @Override
    public int update(Usuario t) {
        try {
            String sql = "UPDATE usuarios SET dinero = ?, tiempo = ? WHERE id = ?";
            conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, t.getDineroDisponible());
            statement.setDouble(2, t.getTiempo());
            statement.setInt(3, t.getId());
            int rows = statement.executeUpdate();

            return rows;

        } catch (Exception e) {
            throw new MissingDataException(e);
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

                listaUsuarios.add(new Usuario(nombre, dineroDisponible, preferencia, tiempo, id, password, admin));
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
        return 0;
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

                user = new Usuario(nombre, dineroDisponible, preferencia, tiempo, id, password, admin);
            }

            return user;
        } catch (Exception e) {
            throw new MissingDataException(e);
        }
    }

    private Usuario toUser(ResultSet userRegister) throws SQLException {
        return new Usuario(userRegister.getString("nombre"), userRegister.getInt("dinero"), Tipo.valueOf(userRegister.getString("preferencia")), userRegister.getDouble("tiempo"), userRegister.getInt("id"), userRegister.getString("password"), userRegister.getBoolean("admin"));
    }

}

