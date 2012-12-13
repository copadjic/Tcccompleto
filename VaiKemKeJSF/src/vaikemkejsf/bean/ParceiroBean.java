package vaikemkejsf.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Parceiro;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class ParceiroBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	private GenericDAO<Parceiro> parceiroDao;

	public ParceiroBean() {
	this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.parceiroDao = new GenericDAO<>(entityManager, Parceiro.class);
		
		}
	
	public List<Parceiro> getParceiros(){
		return parceiroDao.listarTodos("nome");
	}
}
