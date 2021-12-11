package com.proyecto.TurismoMuyMuyLejano;

import dao.*;
import maquinaDeSugerencias.MaquinaDeSugerencias;
import services.LoginService;
import tipos.Tipo;

import java.io.IOException;
import java.sql.SQLException;


public class App {

	public static void main(String[] args) throws IOException, SQLException {
		for (Tipo tipo : Tipo.values()){
			System.out.println(tipo);
		}
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		LoginService login = new LoginService();
		System.out.println(login.login("Burro", "burro"));
		usuarioDAO.createArray();
 		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.createArray();
		PromocionDAO promocionDAO = DAOFactory.getPromociosDAO();
		promocionDAO.findAll();
		MaquinaDeSugerencias.iterarListas();
	}

}
