/*
 * C�digo-fonte do livro "Programa��o Java para a Web"
 * Autores: D�cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN:978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - todos os direitos reservados
 *
 * LICEN�A: Este arquivo-fonte est� sujeito a Atribui��o 2.5 Brasil, da licen�a Creative Commons,
 * que encontra-se dispon�vel no seguinte endere�o URI: http://creativecommons.org/licenses/by/2.5/br/
 * Se voc� n�o recebeu uma c�pia desta licen�a, e n�o conseguiu obt�-la pela internet, por favor,
 * envie uma notifica��o aos seus autores para que eles possam envi�-la para voc� imediatamente.
 *
 *
 * Source-code of "Programando Java para Web" book
 * Authors: D�cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN:978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - all rights reserved
 *
 * LICENSE: This source file is subject to Attibution version 2.5 Brazil of the Creative Commons
 * license that is available through the following URI:  http://creativecommons.org/licenses/by/2.5/br/
 * If you did not receive a copy of this license and are unable to obtain it through the web, please
 * send a note to the authors so they can mail you a copy immediately.
 *
 */


package com.livro.capitulo3.cadastro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.livro.capitulo3.categoria.Categoria;
import com.livro.capitulo3.categoria.CategoriaDAO;
import com.livro.capitulo3.produto.Produto;
import com.livro.capitulo3.produto.ProdutoDAO;

public class Cadastro {

	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro();

		cadastro.cadastraProdutos();
		cadastro.cadastraCategorias();
		System.out.println("Cadastros gerados com sucesso!");
	}

	public void cadastraProdutos() {
		String descricao[] = {"Bicicleta", "Televis�o", "DVD"};
		Double preco[] = {356.83, 19.99, 195.60};
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = null;

		for (int i = 0; i < 3; i++) {
			produto = new Produto();
			produto.setDescricao(descricao[i]);
			produto.setPreco(preco[i]);
			produtoDAO.salvar(produto);
		}
	}

	public void cadastraCategorias() {
		String descricao[] = {"Utilidades", "Geral"};
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = null;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Set<Produto> produtos = new HashSet<Produto>();
		List<Produto> produtosListagem = produtoDAO.listar();

		for (int i = 0; i < produtosListagem.size(); i++) {
			produtos.add(produtosListagem.get(i));
		}

		for (int i = 0; i < 2; i++) {
			categoria = new Categoria();
			categoria.setDescricao(descricao[i]);
			categoria.setProdutos(produtos);
			categoriaDAO.salvar(categoria);
		}
	}
}
