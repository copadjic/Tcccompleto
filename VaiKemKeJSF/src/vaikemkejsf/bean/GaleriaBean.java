package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.FotoDao;
import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Foto;
import vaikemkejsf.model.Peixe;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class GaleriaBean {
	private Peixe peixe;
	private EntityManager entityManager;
	private FotoDao fotoDao;

	public GaleriaBean(){ 
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.fotoDao = new FotoDao(entityManager);

		peixe = new GenericDAO<Peixe>(entityManager, Peixe.class).ler(1);

	}  

	public List<Foto> getImages() {
		List<Foto> fotos = fotoDao.listarFotos(peixe);
		System.out.println(fotos.size());
		return fotos;  
	}

	public Peixe getPeixe() {
		return peixe;
	}

	public void setPeixe(Peixe peixe) {
		this.peixe = peixe;
	}
}
