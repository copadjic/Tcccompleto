package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipousuario database table.
 * 
 */
@Entity
public class Tipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipousuario")
	private List<Usuario> usuarios;

	public Tipousuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}