package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Peixe;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class PeixeBean {
	private Peixe peixe;
	private EntityManager entityManager;
	private GenericDAO<Peixe> peixeDao;
	
	
	public PeixeBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.peixeDao = new GenericDAO<>(entityManager, Peixe.class);
		this.peixe = new Peixe();
		
	}
	
	public Peixe getPeixe() {
		return peixe;
	}

	public void setPeixe(Peixe peixe) {
		this.peixe = peixe;
	}

	public List<Peixe> getPeixes(){
		return peixeDao.listarTodos("nome");
	}
}
