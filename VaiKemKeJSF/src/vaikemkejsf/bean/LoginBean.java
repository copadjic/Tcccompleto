package vaikemkejsf.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import vaikemkejsf.dao.LoginDao;
import vaikemkejsf.model.Tipousuario;
import vaikemkejsf.model.Usuario;
import vaikemkejsf.util.JPAUtil;


@ManagedBean
@SessionScoped
public class LoginBean {

	private EntityManager entityManager;
	private LoginDao loginDao;

	private String email;
	private String senha;
	private Usuario usuarioLogado;
	private Tipousuario tipoUsuario;


	public LoginBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.loginDao = new LoginDao(this.entityManager);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login(){
		this.setUsuarioLogado(loginDao.getUsuario(email, senha));
		if(usuarioLogado == null){
			return "erroLogin.xhtml";
		}else {
			if(usuarioLogado.getTipousuario().getId() == 2){

				return "ultimasmaterias.jsf";
				
			} else{
				if(usuarioLogado.getTipousuario().getId() == 1){
					return "templateadm.jsf";
				}else{
					return "login.jsf";
				}
			}
		}		
	}

	public String logout(){
		this.setUsuarioLogado(null);
		return null;
	}
	

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Tipousuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Tipousuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
