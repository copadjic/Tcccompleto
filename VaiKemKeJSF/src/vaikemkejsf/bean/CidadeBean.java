package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Cidade;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class CidadeBean {
	private Cidade cidade;
	private EntityManager entityManager;
	private GenericDAO<Cidade> cidadeDao;
	
	
	public CidadeBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.cidadeDao = new GenericDAO<>(entityManager, Cidade.class);
		this.cidade = new Cidade();
		
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String salvar(){
		this.entityManager.getTransaction().begin();
		this.cidadeDao.atualizar(cidade);
		this.entityManager.getTransaction().commit();
		
		return "template.jsf";
	}

	
	public List<Cidade> getCidades(){
		return cidadeDao.listarTodos("nome");
	}
}
