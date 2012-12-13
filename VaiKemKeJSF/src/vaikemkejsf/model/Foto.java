package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String endereco;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="Materias_ID")
	private Materia materia;

	//bi-directional many-to-one association to Peixe
	@ManyToOne
	private Peixe peixe;

	//bi-directional many-to-one association to Pesqueiro
	@ManyToOne
	private Pesqueiro pesqueiro;

	//bi-directional many-to-many association to Peixe
	@ManyToMany(mappedBy="fotos2")
	private List<Peixe> peixes;

	public Foto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Peixe getPeixe() {
		return this.peixe;
	}

	public void setPeixe(Peixe peixe) {
		this.peixe = peixe;
	}

	public Pesqueiro getPesqueiro() {
		return this.pesqueiro;
	}

	public void setPesqueiro(Pesqueiro pesqueiro) {
		this.pesqueiro = pesqueiro;
	}

	public List<Peixe> getPeixes() {
		return this.peixes;
	}

	public void setPeixes(List<Peixe> peixes) {
		this.peixes = peixes;
	}

}