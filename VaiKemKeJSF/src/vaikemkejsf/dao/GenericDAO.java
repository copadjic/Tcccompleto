package vaikemkejsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import vaikemkejsf.util.JPAUtil;

@SessionScoped

public class GenericDAO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected EntityManager manager;
	protected Class<?> tipo;
	protected String nomeTabela;
	

	public GenericDAO(EntityManager manager, Class<?> tipo) {
		this.manager = manager;
		this.tipo = tipo;
		this.nomeTabela = JPAUtil.getTableName(tipo);
	}
	
	public void criar(T t) {
		manager.persist(t);
		manager.flush();
	}
	
	@SuppressWarnings("unchecked")
	public T ler(int codigo){
		return (T) manager.getReference(tipo, codigo);
	}
	
	public void remover(T t){
		manager.remove(t);
		manager.flush();
	}
	
	public void atualizar(T t){
		manager.merge(t);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<T> listarTodos(int pagina, int quantidadePorPagina){
		Query query = manager.createQuery("SELECT x FROM " + nomeTabela + " x");
		query.setFirstResult(pagina);
		query.setMaxResults(quantidadePorPagina);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	
	public List<T> listarTodos(String nome){
		Query query = manager.createQuery("SELECT x FROM " + nomeTabela + " x" + " order by " + nome);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<T> listarTodos(){
		Query query = manager.createQuery("SELECT x FROM " + nomeTabela + " x");
		return query.getResultList();
	}
	
	public long getTotal() {
		Query query = manager.createQuery("SELECT COUNT(p) FROM " + nomeTabela + " p");
		Number result = (Number) query.getSingleResult();
		return result.longValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listarPorid(Integer id) {
		
		String sql = "from Comentario c where c.materia.id = :idMateria"; 
		Query query = manager.createQuery(sql);
		query.setParameter("idMateria", id);
		return query.getResultList();
	}
	

}
	
