package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pesqueiro database table.
 * 
 */
@Entity
public class Pesqueiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String endereco;

	@Lob
	private String infoadc;

	@Lob
	private String mapa;

	private String materias;

	private String nome;

	private String previsao;

	private String site;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="pesqueiro")
	private List<Foto> fotos;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="pesqueiro")
	private List<Materia> materiasSet;

	//bi-directional many-to-many association to Peixe
	@ManyToMany
	@JoinTable(
		name="peixe_has_pesqueiro"
		, joinColumns={
			@JoinColumn(name="Pesqueiro_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Peixe_ID")
			}
		)
	private List<Peixe> peixes;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade;

	//bi-directional many-to-one association to Peixe
	@ManyToOne
	private Peixe peixe;

	//bi-directional many-to-many association to Lazer
	@ManyToMany
	@JoinTable(
		name="pesqueiro_has_lazer"
		, joinColumns={
			@JoinColumn(name="Pesqueiro_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Lazer_ID")
			}
		)
	private List<Lazer> lazers;

	//bi-directional many-to-one association to Visita
	@OneToMany(mappedBy="pesqueiro")
	private List<Visita> visitas;

	public Pesqueiro() {
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

	public String getInfoadc() {
		return this.infoadc;
	}

	public void setInfoadc(String infoadc) {
		this.infoadc = infoadc;
	}

	public String getMapa() {
		return this.mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getMaterias() {
		return this.materias;
	}

	public void setMaterias(String materias) {
		this.materias = materias;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrevisao() {
		return this.previsao;
	}

	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<Materia> getMateriasSet() {
		return this.materiasSet;
	}

	public void setMateriasSet(List<Materia> materiasSet) {
		this.materiasSet = materiasSet;
	}

	public List<Peixe> getPeixes() {
		return this.peixes;
	}

	public void setPeixes(List<Peixe> peixes) {
		this.peixes = peixes;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Peixe getPeixe() {
		return this.peixe;
	}

	public void setPeixe(Peixe peixe) {
		this.peixe = peixe;
	}

	public List<Lazer> getLazers() {
		return this.lazers;
	}

	public void setLazers(List<Lazer> lazers) {
		this.lazers = lazers;
	}

	public List<Visita> getVisitas() {
		return this.visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}
	public String toString(){
		return getNome();
	}

}