package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the peixe database table.
 * 
 */
@Entity
public class Peixe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String foto;

	@Lob
	private String historia;

	private String nome;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="peixe")
	private List<Foto> fotos1;

	//bi-directional many-to-many association to Foto
	@ManyToMany
	@JoinTable(
		name="peixe_has_foto"
		, joinColumns={
			@JoinColumn(name="Peixe_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Foto_ID")
			}
		)
	private List<Foto> fotos2;

	//bi-directional many-to-many association to Pesqueiro
	@ManyToMany(mappedBy="peixes")
	private List<Pesqueiro> pesqueiros1;

	//bi-directional many-to-one association to Pesqueiro
	@OneToMany(mappedBy="peixe")
	private List<Pesqueiro> pesqueiros2;

	public Peixe() {
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

	public String getHistoria() {
		return this.historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Foto> getFotos1() {
		return this.fotos1;
	}

	public void setFotos1(List<Foto> fotos1) {
		this.fotos1 = fotos1;
	}

	public List<Foto> getFotos2() {
		return this.fotos2;
	}

	public void setFotos2(List<Foto> fotos2) {
		this.fotos2 = fotos2;
	}

	public List<Pesqueiro> getPesqueiros1() {
		return this.pesqueiros1;
	}

	public void setPesqueiros1(List<Pesqueiro> pesqueiros1) {
		this.pesqueiros1 = pesqueiros1;
	}

	public List<Pesqueiro> getPesqueiros2() {
		return this.pesqueiros2;
	}

	public void setPesqueiros2(List<Pesqueiro> pesqueiros2) {
		this.pesqueiros2 = pesqueiros2;
	}
	public String toString(){
		return getNome();
	}

}