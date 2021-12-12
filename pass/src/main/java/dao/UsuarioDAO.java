package dao;

import java.sql.SQLException;

import usuario.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{

	public abstract Usuario findByUsername(String username);


	public abstract void createArray() throws SQLException;

	public abstract void actualizarDBUsuarios();

	void restore(Usuario user);

    Usuario findByAtraccionId(int id) throws SQLException;
}
