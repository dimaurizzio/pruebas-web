package services;

import dao.DAOFactory;
import dao.UsuarioDAO;
import tipos.Tipo;
import usuario.Usuario;
import utils.Crypt;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Userservice {

    public static void updatePassword(String password, int id) throws SQLException {
        UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
        password = Crypt.hash(password);
        usuarioDAO.updatePassword(password, id);
    }

    public List<Usuario> list() { return DAOFactory.getUsuarioDAO().findAll();
    }

    public Usuario create(String username, String password, Integer coins, Double time, Tipo type) {
        String passwordHash = Crypt.hash(password);
        Usuario user = new Usuario(username, coins, type, time, -1, passwordHash, false, false);
        user.setPassword(password);

        if (user.isValid()) {
            DAOFactory.getUsuarioDAO().insert(user);
        }

        return user;
    }

    public void delete(String nombre) throws SQLException {
        UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
        Usuario user = usuarioDAO.findByUsername(nombre);
        usuarioDAO.delete(user);
    }

    public void restore(String nombre) {
        UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
        Usuario user = usuarioDAO.findByUsername(nombre);
        usuarioDAO.restore(user);
    }
    public Usuario update(Integer id, Integer dinero, Double tiempo, Tipo tipo) throws SQLException {

        UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
        Usuario user = usuarioDAO.findByAtraccionId(id);

        user.setDineroDisponible(dinero);
        user.setTiempo(tiempo);
        user.setPreferencia(tipo);


        if (user.isValid()) {
            usuarioDAO.update(user);
        }

        return user;
    }

    public List<String> types() {
        List<String> typesL = new LinkedList<>();
        for (Tipo tipo : Tipo.values()){
            typesL.add(tipo.toString());
        }
        return typesL;

    }
}


