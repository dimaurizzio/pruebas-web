package services;

import dao.DAOFactory;
import tipos.Tipo;
import usuario.Usuario;
import utils.Crypt;

import java.util.List;

public class Userservice {

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
}

