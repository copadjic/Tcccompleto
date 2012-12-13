package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Previsao;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class PrevisaoBean {
	private Previsao previsao;
	private EntityManager entityManager;
	private GenericDAO<Previsao> prevDao;
	
	
	public PrevisaoBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.prevDao = new GenericDAO<>(entityManager, Previsao.class);
		this.previsao = new Previsao();
		
	}
	
	public Previsao getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Previsao previsao) {
		this.previsao = previsao;
	}

	public List<Previsao> getPrevisoes(){
		return prevDao.listarTodos("tipoprevisao");
	}
}
