package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Estado;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class EstadoBean {
	private Estado estado;
	private EntityManager entityManager;
	private GenericDAO<Estado> estadoDao;
	
	
	public EstadoBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.estadoDao = new GenericDAO<>(entityManager, Estado.class);
		this.estado = new Estado();
		
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String salvar(){
		this.entityManager.getTransaction().begin();
		this.estadoDao.atualizar(estado);
		this.entityManager.getTransaction().commit();
		
		return "template.jsf";
	}

	
	public List<Estado> getEstados(){
		return estadoDao.listarTodos(0, 27);
	}
}
