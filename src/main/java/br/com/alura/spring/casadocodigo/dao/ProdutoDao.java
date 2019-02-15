package br.com.alura.spring.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.spring.casadocodigo.entity.Produto;

@Repository
public class ProdutoDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void adicionaProduto(Produto produto) {
		manager.persist(produto);
	}
	
	@Transactional(readOnly = true)
	public List<Produto> listProdutos(){
		TypedQuery<Produto> query = manager.createQuery("from Produto p", Produto.class);
		return query.getResultList();
	}
	
	public Produto getProduto(int id) {
//		for (Produto produto : ProdutoDao.produtos) {
//			if(produto.getId() == id)
//				return produto;
//		}
		
		return null;
	}
	
	public int sizeProdutos() {
//		return ProdutoDao.idProdutos;
		return 0;
	}

	public void atualizaProduto(Produto produto) {
//		for (Produto p : produtos) {
//			if(produto.getId() == p.getId()) {
//				p.setTitulo(produto.getTitulo());
//				p.setDescricao(produto.getDescricao());
//				p.setPaginas(produto.getPaginas());
//				p.setDataPublicacao(produto.getDataPublicacao());
//				p.setStatus(produto.getStatus());
//			}
//		}
		
	}
	
	public void removeProduto(int id) {
		
//		ProdutoDao.produtos.removeIf(p -> p.getId() == id);
		
	}
	
	
}
