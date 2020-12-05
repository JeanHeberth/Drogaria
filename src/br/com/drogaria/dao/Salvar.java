/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Heberth
 */
public class Salvar {

    /* Metodo para salvar cliente no BD drogaria */
    public static void main(String[] args) {

        Fabricante f1 = new Fabricante();

        f1.setDescricao("Joao");

        FabricanteDao fdao = new FabricanteDao();
        try {
            fdao.salvar(f1);
            JOptionPane.showMessageDialog(null, " Cliente criado com sucesso!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar criar");
        }

    }
}
