package vaikemkejsf.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Comentario;
import vaikemkejsf.model.Materia;
import vaikemkejsf.model.Pesqueiro;
import vaikemkejsf.util.JPAUtil;

@SessionScoped  
@ManagedBean
public class MateriaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Materia materia;
	private EntityManager entityManager;
	private GenericDAO<Materia> materiaDao;
	private GenericDAO<Comentario> comentarioDao;
	
	
	private List<Comentario> comentarios;
	



	private Comentario comentario = new Comentario();
	private int idpesqueiro;
	private int idcomentario;
	
	
	public int getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}

	public GenericDAO<Comentario> getComentarioDao() {
		return comentarioDao;
	}
	
	public void setComentarioDao(GenericDAO<Comentario> comentarioDao) {
		this.comentarioDao = comentarioDao;
	}
	
	public Comentario getComentario() {
		return comentario;
	}
	
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	public GenericDAO<Materia> getMateriaDao() {
		return materiaDao;
	}

	public void setMateriaDao(GenericDAO<Materia> materiaDao) {
		this.materiaDao = materiaDao;
	}

	public int getIdpesqueiro() {
		return idpesqueiro;
	}

	public void setIdpesqueiro(int idpesqueiro) {
		this.idpesqueiro = idpesqueiro;
	}

	public MateriaBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.materiaDao = new GenericDAO<Materia>(entityManager, Materia.class);
		this.materia = new Materia();
		this.materia.setData(GregorianCalendar.getInstance().getTime());
		this.materia.setPesqueiro(new GenericDAO<Pesqueiro>(entityManager, Pesqueiro.class).ler(2));
		Pesqueiro pesq = new Pesqueiro();
		pesq.setId(1);
		idpesqueiro = 1;
		this.materia.setPesqueiro(pesq);
		
	}	
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String salvar(){
		Pesqueiro pesq = new Pesqueiro();
		pesq.setId(idpesqueiro);
		materia.setPesqueiro(pesq);
		this.entityManager.getTransaction().begin();
		this.materiaDao.atualizar(materia);
		this.entityManager.getTransaction().commit();
		
		return "templateadm.jsf";
	}
	

	public String salvarComentario() {

		this.comentarioDao = new GenericDAO<Comentario>(entityManager, Comentario.class);
		comentario.setMateria(this.materia);
		comentario.setData(new Date());

		this.entityManager.getTransaction().begin();
		this.comentarioDao.atualizar(comentario);
		this.entityManager.getTransaction().commit();
		
		return "templateadm.jsf";
		
		/*this.comentarioDao = new GenericDAO<Comentario>(entityManager, Comentario.class);

		comentario.setMateria(this.materia);
		comentario.setData(new Date());

		this.comentarioDao.criar(this.comentario);
		return null;*/

	}
	
	
	
	public List<Comentario> getComentarios() {

		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	

	public List<Materia> getMaterias(){
		return materiaDao.listarTodos("data desc");
	}
	public List<Comentario> getListarComentarioPorMateria(){
        return comentarioDao.listarPorid(materia.getId());
	} 
	
	public String visualizarMateria(){  
        return "materiadetalhada.jsf";
	}
}
