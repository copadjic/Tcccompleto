package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Integrante;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class IntegranteBean {
	private EntityManager entityManager;
	private GenericDAO<Integrante> integranteDao;
	private Integrante integrante;
	
	
	public GenericDAO<Integrante> getIntegranteDao() {
		return integranteDao;
	}

	public void setIntegranteDao(GenericDAO<Integrante> integranteDao) {
		this.integranteDao = integranteDao;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public IntegranteBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.integranteDao = new GenericDAO<Integrante>(entityManager, Integrante.class);
		this.integrante = new Integrante();
		
	}
	
	public List<Integrante> getIntegrantes(){
		return integranteDao.listarTodos();
	}
}
