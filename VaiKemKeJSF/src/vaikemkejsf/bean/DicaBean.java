package vaikemkejsf.bean;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Dica;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
@ViewScoped
public class DicaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dica dica;
	private EntityManager entityManager;
	private GenericDAO<Dica> dicaDao;
	private int iddica;
	
	
	public int getIddica() {
		return iddica;
	}

	public void setIddica(int iddica) {
		this.iddica = iddica;
	}

	public DicaBean() {
		this.dica = new Dica();
		this.dica.setData(GregorianCalendar.getInstance().getTime());
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.dicaDao = new GenericDAO<>(entityManager, Dica.class);
	}
	
	public Dica getDica() {
		return dica;
	}

	public void setDica(Dica dica) {
		this.dica = dica;
	}

	public String salvar(){
		this.entityManager.getTransaction().begin();
		this.dicaDao.atualizar(dica);
		this.entityManager.getTransaction().commit();
		return "template.jsf";
	}
	
	public List<Dica> getdicas(){
		return dicaDao.listarTodos();
	}
}
