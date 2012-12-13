package vaikemkejsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import vaikemkejsf.model.Usuario;

public class LoginDao {

	protected EntityManager manager;
	
	public LoginDao(EntityManager manager) {
		this.manager = manager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(int pagina, int quantidadePorPagina){
		Query query = manager.createQuery("SELECT x FROM Usuario x");
		query.setFirstResult(pagina);
		query.setMaxResults(quantidadePorPagina);
		return query.getResultList();
	}
	
	public Usuario getUsuario(String email, String senha) {
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
		query.setParameter("email", email);
		query.setParameter("senha", senha);

		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
