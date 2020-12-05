/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Heberth
 */
public class Editar {

    public static void main(String[] args) {

        Fabricante f1 = new Fabricante();
        f1.setCodigo(1L);
        f1.setDescricao("Heberth");

        FabricanteDao fdao = new FabricanteDao();

        try {
            fdao.editar(f1);
            JOptionPane.showMessageDialog(null, " Cliente alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro ao tentar alterar o cliente");
        }
    }

}
