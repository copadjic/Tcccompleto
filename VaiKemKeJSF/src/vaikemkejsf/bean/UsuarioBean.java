package vaikemkejsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.GenericDAO;
import vaikemkejsf.model.Tipousuario;
import vaikemkejsf.model.Usuario;
import vaikemkejsf.util.JPAUtil;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario;
	private EntityManager entityManager;
	private GenericDAO<Usuario> usuarioDao;
	private int idusuario;
	
	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public UsuarioBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.usuarioDao = new GenericDAO<>(entityManager, Usuario.class);
		this.usuario = new Usuario();
		Tipousuario tu = new Tipousuario();
		tu.setId(2);
		idusuario = 2;
		
		this.usuario.setTipousuario(tu);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String salvar(){
		Tipousuario tu = new Tipousuario();
		tu.setId(idusuario);
		usuario.setTipousuario(tu);
		this.entityManager.getTransaction().begin();
		this.usuarioDao.atualizar(usuario);
		this.entityManager.getTransaction().commit();
		
		return "templateadm.jsf";
	}

	
	public List<Usuario> getUsuarios(){
		return usuarioDao.listarTodos(1, 100);
	}
}
