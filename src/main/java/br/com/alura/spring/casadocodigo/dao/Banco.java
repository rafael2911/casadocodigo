package br.com.alura.spring.casadocodigo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alura.spring.casadocodigo.entity.Produto;

@Repository
public class Banco {
	
	private static List<Produto> produtos = new ArrayList<>();
	private static int idProdutos = 0;
	
	static {
		Produto p1 = new Produto();
		p1.setId(++idProdutos);
		p1.setTitulo("Spring");
		p1.setDescricao("Livro de spring da casa do código");
		p1.setPaginas(220);
		
		Produto p2 = new Produto();
		p2.setId(++idProdutos);
		p2.setTitulo("Java OO");
		p2.setDescricao("Livro de java OO da casa do código");
		p2.setPaginas(298);
		
		Produto p3 = new Produto();
		p3.setId(++idProdutos);
		p3.setTitulo("C# OO");
		p3.setDescricao("Construindo aplicação com C#");
		p3.setPaginas(315);
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
	}
	
	public void adicionaProduto(Produto produto) {
		produto.setId(++Banco.idProdutos);
		Banco.produtos.add(produto);
	}
	
	public List<Produto> listProdutos(){
		return Collections.unmodifiableList(Banco.produtos);
	}
	
	public Produto getProduto(int id) {
		for (Produto produto : Banco.produtos) {
			if(produto.getId() == id)
				return produto;
		}
		
		return null;
	}
	
	public int sizeProdutos() {
		return Banco.idProdutos;
	}

	public void atualizaProduto(Produto produto) {
		for (Produto p : produtos) {
			if(produto.getId() == p.getId()) {
				p.setTitulo(produto.getTitulo());
				p.setDescricao(produto.getDescricao());
				p.setPaginas(produto.getPaginas());
			}
		}
		
	}
	
	
}
