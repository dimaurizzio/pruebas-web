package com.proyecto.TurismoMuyMuyLejano;

import dao.*;
import maquinaDeSugerencias.MaquinaDeSugerencias;
import promociones.Promocion;
import services.ItineraryService;
import services.LoginService;
import tipos.Tipo;

import java.io.IOException;
import java.sql.SQLException;


public class App {

	public static void main(String[] args) throws IOException, SQLException {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.createArray();
 		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.createArray();
		System.out.println(AtraccionDAO.listaAtracciones.get(1).getTipo().toString().equals(AtraccionDAO.listaAtracciones.get(1).toString()));
		PromocionDAO promocionDAO = DAOFactory.getPromociosDAO();
		promocionDAO.findAll();
		MaquinaDeSugerencias.iterarListas();
	}

}
