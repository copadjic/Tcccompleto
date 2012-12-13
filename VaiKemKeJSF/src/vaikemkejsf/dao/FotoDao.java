package vaikemkejsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vaikemkejsf.model.Foto;
import vaikemkejsf.model.Peixe;

public class FotoDao extends GenericDAO<Foto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FotoDao(EntityManager manager) {
		super(manager, Foto.class);
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Foto> listarFotos(Peixe peixe){
		Query query = manager.createQuery("SELECT x FROM Foto x WHERE x.peixe = :peixe");
		query.setParameter("peixe", peixe);
		return query.getResultList();
	}



}
