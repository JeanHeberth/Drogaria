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
public class Conexao {

    public static Connection getConexao() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/drogaria", "root", "");
            System.out.println("ConectadoConexao com sucesso!");
        } catch (SQLException ex) {
            System.out.println("ErroConexao ao conectar!");
        }
        return conn;
    }

    public static void main(String[] args) {
        Conexao.getConexao();
    }

}
