/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jean Heberth
 */
public class FabricanteDao {

    /* 
    
    ######## Metodo para salvar cliente no BD drogaria ################
    
     */
    public void salvar(Fabricante f) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Fabricante (descricao) VALUES (?) ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        comando.executeUpdate();

    }

    /*
    
    ####### Metodo para Excluir cliente no BD drogaria ###########
    
     */
    public void excluir(Fabricante f) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM fabricante WHERE codigo = ? ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getCodigo());

        comando.executeUpdate();
    }

    /* 
    
    ######## Metodo para editar cliente no BD drogaria ################
    
     */
    public void editar(Fabricante f) throws SQLException {

        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE fabricante SET descricao = ? WHERE codigo = ? ");

        Connection conexao = ConexaoFactory.conectar();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getDescricao());
        comando.setLong(2, f.getCodigo());

        comando.executeUpdate();
    }

    /* 
    
    ######## Metodo para buscar por codigo cliente no BD drogaria ################
    
     */
    public Fabricante buscaPorCodigo(Fabricante f) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, descricao FROM fabricante WHERE codigo = ? ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getCodigo());

        ResultSet resultado = comando.executeQuery();

        Fabricante retorno = null;

        if (resultado.next()) {

            retorno = new Fabricante();
            retorno.setCodigo(resultado.getLong("codigo"));
            retorno.setDescricao(resultado.getString("descricao"));
        }

        return retorno;
    }

    /* 
    
    ######## Metodo para lista Crescente cliente no BD drogaria ################
    
     */
    public ArrayList<Fabricante> listar() throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, descricao FROM fabricante ORDER BY descricao ASC ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());

        ResultSet resultado = comando.executeQuery();

        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

        while (resultado.next()) {
            Fabricante f = new Fabricante();
            f.setCodigo(resultado.getLong("codigo"));
            f.setDescricao(resultado.getString("descricao"));

            lista.add(f);
        }
        return lista;

    }

    /*  ######## Metodo para buscar por DescriÃ§Ã£o lista Crescente cliente no BD drogaria ################
    
    
     */
    public ArrayList<Fabricante> buscaPorDescricao(Fabricante f) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT codigo, descricao FROM fabricante WHERE descricao like ? ORDER BY descricao ASC ");

        Connection conexao = ConexaoFactory.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, "%" + f.getDescricao() + "%");

        ResultSet resultado = comando.executeQuery();

        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

        while (resultado.next()) {
            Fabricante item = new Fabricante();
            item.setCodigo(resultado.getLong("codigo"));
            item.setDescricao(resultado.getString("descricao"));

            lista.add(item);
        }
        return lista;

    }

}
