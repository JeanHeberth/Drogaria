/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jean Heberth
 */
public class ConexaoFactory {
    
    private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useTimezone=true&serverTimezone=UTC";

	public static Connection conectar() throws SQLException {

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;

	}

	public static void main(String[] args) {

		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("ConexaoFactory realizada com sucesso!");
		} catch (SQLException ex) {
			System.out.println("ErroFactory ao conectar");
		}

	}

    
}
