package vaikemkejsf.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Comentario;
import vaikemkejsf.model.Materia;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class ComentarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	private GenericDAO<Comentario> comentarioDao;
	private Materia materia;
	

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public ComentarioBean() {
	this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.comentarioDao = new GenericDAO<>(entityManager, Comentario.class);
		
		}
	
	public List<Comentario> getListarComentarioPorMateria(){
        return comentarioDao.listarPorid(materia.getId());
}
}
