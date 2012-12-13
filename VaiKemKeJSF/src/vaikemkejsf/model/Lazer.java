package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lazer database table.
 * 
 */
@Entity
public class Lazer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	//bi-directional many-to-many association to Pesqueiro
	@ManyToMany(mappedBy="lazers")
	private List<Pesqueiro> pesqueiros;

	public Lazer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pesqueiro> getPesqueiros() {
		return this.pesqueiros;
	}

	public void setPesqueiros(List<Pesqueiro> pesqueiros) {
		this.pesqueiros = pesqueiros;
	}
	public String toString(){
		return getNome();
	}

}