package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Cidade;
import vaikemkejsf.model.Estado;
import vaikemkejsf.model.Pesqueiro;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class PesqueiroBean {
	private EntityManager entityManager;
	private GenericDAO<Pesqueiro> pesqueiroDao;
	private Pesqueiro pesqueiro;
	private int idestado;
	private int idcidade;


	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public int getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}

	public Pesqueiro getPesqueiro() {
		return pesqueiro;
	}

	public void setPesqueiro(Pesqueiro pesqueiro) {
		this.pesqueiro = pesqueiro;
	}


	public GenericDAO<Pesqueiro> getPesqueiroDao() {
		return pesqueiroDao;
	}

	public void setPesqueiroDao(GenericDAO<Pesqueiro> pesqueiroDao) {
		this.pesqueiroDao = pesqueiroDao;
	}

	public PesqueiroBean() {
		this.pesqueiro = new Pesqueiro();
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.pesqueiroDao = new GenericDAO<>(entityManager, Pesqueiro.class);
		Cidade cid = new Cidade();
		cid.setId(1);
		idcidade = 1;
		this.pesqueiro.setCidade(cid);
		
	}

	public List<Pesqueiro> getPesqueiros(){
		return pesqueiroDao.listarTodos("nome");
	}
	public String salvar(){
		Cidade cid = new Cidade();
		cid.setId(idcidade);
		pesqueiro.setCidade(cid);
		this.entityManager.getTransaction().begin();
		this.pesqueiroDao.atualizar(pesqueiro);
		this.entityManager.getTransaction().commit();
		return "templateadm.jsf";
	}
}