package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dicas database table.
 * 
 */
@Entity
@Table(name="dicas")
public class Dica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String capa;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Lob
	private String descricao;

	@Lob
	private String titulo;

	public Dica() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCapa() {
		return this.capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
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

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}