package br.com.alura.spring.casadocodigo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alura.spring.casadocodigo.entity.Produto;
import br.com.alura.spring.casadocodigo.entity.TipoStatus;

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
		p1.setDataPublicacao(LocalDate.of(1999, 3, 20));
		p1.setStatus(TipoStatus.INATIVO);
		
		Produto p2 = new Produto();
		p2.setId(++idProdutos);
		p2.setTitulo("Java OO");
		p2.setDescricao("Livro de java OO da casa do código");
		p2.setPaginas(298);
		p2.setDataPublicacao(LocalDate.of(2013, 7, 15));
		p2.setStatus(TipoStatus.ATIVO);
		
		Produto p3 = new Produto();
		p3.setId(++idProdutos);
		p3.setTitulo("C# OO");
		p3.setDescricao("Construindo aplicação com C#");
		p3.setPaginas(315);
		p3.setDataPublicacao(LocalDate.of(2018, 12, 3));
		p3.setStatus(TipoStatus.ATIVO);
		
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
				p.setDataPublicacao(produto.getDataPublicacao());
				p.setStatus(produto.getStatus());
			}
		}
		
	}
	
	public void removeProduto(int id) {
		
		Banco.produtos.removeIf(p -> p.getId() == id);
		
	}
	
	
}
