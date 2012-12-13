package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parceiros database table.
 * 
 */
@Entity
@Table(name="parceiros")
public class Parceiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String foto;

	private String nome;

	@Lob
	private String obs;

	private String site;

	public Parceiro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}