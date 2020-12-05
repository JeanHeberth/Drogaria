/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jean Heberth
 */
@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> itensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}

	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void preparaPesquisa() {

		try {
			FabricanteDao dao = new FabricanteDao();
			itens = dao.listar();
		} catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void prepararNovo() {

		fabricante = new Fabricante();

	}

	public void novo() {

		try {
			if (!fabricante.getDescricao().equals("")) {
				FabricanteDao dao = new FabricanteDao();
				dao.salvar(fabricante);

				itens = dao.listar();

				JSFUtil.adicionarMessagemDeSucesso("Fabricante salvo com sucesso.");

			} else {
				JSFUtil.adicionarMensagemDeErro("Descrição não pode ser vazio!");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void excluir() {

		try {
			FabricanteDao dao = new FabricanteDao();
			dao.excluir(fabricante);

			itens = dao.listar();
			JSFUtil.adicionarMessagemDeSucesso("Fabricante excluido com sucesso!");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void editar() {
		try {
			FabricanteDao dao = new FabricanteDao();
			dao.editar(fabricante);

			itens = dao.listar();

			JSFUtil.adicionarMessagemDeSucesso("Fabricante editado com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}

	}

}
