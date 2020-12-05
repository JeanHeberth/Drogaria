/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Heberth
 */
public class BuscaPorDescricao {
    
    public static void main(String[] args) {

		Fabricante f1 = new Fabricante();
		f1.setDescricao("a");

		FabricanteDao fdao = new FabricanteDao();

		try {
			ArrayList<Fabricante> lista = fdao.buscaPorDescricao(f1);

			for (Fabricante f : lista) {
				System.out.println(" Resultado: " + f);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, " Erro ao tentar buscar o cliente");

		}

	}
    
}
