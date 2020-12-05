/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.dao.ProdutoDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

/**
 *
 * @author Jean Heberth
 */
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	private Produto produto;
	private ArrayList<Fabricante> comboFabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public void carregarListagem() {
		try {
			ProdutoDao dao = new ProdutoDao();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void prepararNovo() {
		try {
			produto = new Produto();
			FabricanteDao dao = new FabricanteDao();
			comboFabricantes = dao.listar();
		} catch (SQLException ex) {
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void novo() {

		try {
			ProdutoDao dao = new ProdutoDao();
			dao.salvar(produto);
			itens = dao.listar();
			JSFUtil.adicionarMessagemDeSucesso("Produto salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(e.getMessage());
		}

	}

	public void excluir() {
		try {

			ProdutoDao dao = new ProdutoDao();
			dao.excluir(produto);
			itens = dao.listar();
			JSFUtil.adicionarMessagemDeSucesso(" Produto excluído com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void prepararEditar() {

		try {

			FabricanteDao dao = new FabricanteDao();
			comboFabricantes = dao.listar();
		} catch (SQLException e) {
 			JSFUtil.adicionarMensagemDeErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			ProdutoDao dao = new ProdutoDao();
			dao.editar(produto);
			JSFUtil.adicionarMessagemDeSucesso("Produto editado com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemDeErro(e.getMessage());
		}
	}

}
