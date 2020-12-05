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
public class Excluir {

    public static void main(String[] args) {
        Fabricante f1 = new Fabricante();
        Fabricante f2 = new Fabricante();
        f1.setCodigo(11L);
        f2.setCodigo(8L);

        FabricanteDao fdao = new FabricanteDao();

        try {

            fdao.excluir(f1);
            fdao.excluir(f2);
            JOptionPane.showMessageDialog(null, " Cliente excluido com sucesso!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir");
        }
    }

}
