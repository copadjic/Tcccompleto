package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name="materias")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	private String descricao;

	private String fotoCapa;

	@Lob
	private String titulo;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="materia", fetch=FetchType.EAGER)
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="materia")
	private List<Foto> fotos;

	//bi-directional many-to-one association to Pesqueiro
	@ManyToOne
	private Pesqueiro pesqueiro;

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoCapa() {
		return this.fotoCapa;
	}

	public void setFotoCapa(String fotoCapa) {
		this.fotoCapa = fotoCapa;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Pesqueiro getPesqueiro() {
		return this.pesqueiro;
	}

	public void setPesqueiro(Pesqueiro pesqueiro) {
		this.pesqueiro = pesqueiro;
	}
}