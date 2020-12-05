/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.test;

import br.com.drogaria.dao.ProdutoDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Jean Heberth
 */
public class ProdutoDaoTeste {

	@Test
	public void salvar() throws SQLException {

		Produto p = new Produto();
		p.setDescricao(" Cataflan com 45 comprimidos ");
		p.setPreco(38.99D);
		p.setQuantidade(10L);

		Fabricante f = new Fabricante();
		f.setCodigo(1L);

		p.setFabricante(f);

		ProdutoDao pdao = new ProdutoDao();
		pdao.salvar(p);
	}

	@Test
	@Ignore
	public void listar() throws SQLException {
		ProdutoDao dao = new ProdutoDao();
		ArrayList<Produto> lista = dao.listar();

		for (Produto p : lista) {
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Código do Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
			System.out.println("");

		}
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Produto p = new Produto();
		p.setCodigo(4L);

		ProdutoDao dao = new ProdutoDao();
		dao.excluir(p);

	}

	@Test
	@Ignore
	public void editar() throws SQLException {
		Produto p = new Produto();
		p.setCodigo(17L);
		p.setDescricao("Cataflan pomada com 60 Gramas");
		p.setPreco(19.99D);
		p.setQuantidade(10L);

		Fabricante f = new Fabricante();
		f.setCodigo(2L);
		p.setFabricante(f);

		ProdutoDao dao = new ProdutoDao();
		dao.editar(p);
	}
}
