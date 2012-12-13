package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	private Estado estado;

	//bi-directional many-to-one association to Pesqueiro
	@OneToMany(mappedBy="cidade")
	private List<Pesqueiro> pesqueiros;

	public Cidade() {
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

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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