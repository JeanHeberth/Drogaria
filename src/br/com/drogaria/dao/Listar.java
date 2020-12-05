/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Heberth
 */
public class Listar {

    public static void main(String[] args) {

        try {
            FabricanteDao fdao = new FabricanteDao();
            ArrayList<Fabricante> lista = fdao.listar();
            for (Fabricante f : lista) {
                System.out.println("Resultado " + f);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar");
            e.printStackTrace();
        }

    }

}
