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
public class BuscarPorCodigo {

    public static void main(String[] args) {

        Fabricante f1 = new Fabricante();
        f1.setCodigo(1L);

        Fabricante f2 = new Fabricante();
        f2.setCodigo(2L);

        FabricanteDao fdao = new FabricanteDao();

        try {
            Fabricante f3 = fdao.buscaPorCodigo(f1);
            Fabricante f4 = fdao.buscaPorCodigo(f2);
            System.out.println("Cliente 1: ----->  " + f3);
            System.out.println("Clinete 2  ----->  " + f4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro ao tentar buscar o cliente");
            e.printStackTrace();
        }
    }
}
