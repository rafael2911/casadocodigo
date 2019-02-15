package br.com.alura.spring.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.spring.casadocodigo.entity.Produto;
import br.com.alura.spring.casadocodigo.entity.TipoStatus;

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
	
	@Transactional(readOnly = true)
	public Produto getProduto(int id) {
		TypedQuery<Produto> query = manager.createQuery("from Produto p where p.id = :id", Produto.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public int sizeProdutos() {
//		return ProdutoDao.idProdutos;
		return 0;
	}
	
	@Transactional
	public void atualizaProduto(Produto produto) {
		manager.merge(produto);
	}
	
	@Transactional
	public void removeProduto(int id) {	
		manager.remove(manager.getReference(Produto.class, id));	
	}
	
	@Transactional(readOnly = true)
	public List<Produto> getByStatus(TipoStatus status){
		TypedQuery<Produto> query = manager.createQuery("from Produto p where p.status = :status", Produto.class);
		query.setParameter("status", status);
		return query.getResultList();
	}
	
}
