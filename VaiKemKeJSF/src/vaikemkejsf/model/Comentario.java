package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comentario database table.
 * 
 */
@Entity
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String comentario;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String nome;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="Materias_ID")
	private Materia materia;

	public Comentario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public String toString(){
		return getComentario();
	}
}