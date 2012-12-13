package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the integrantes database table.
 * 
 */
@Entity
@Table(name="integrantes")
public class Integrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cidade;

	private String contato;

	private String facebook;

	private String foto;

	private String nome;

	private String profissao;

	private String tipoPescaria;

	public Integrante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
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

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTipoPescaria() {
		return this.tipoPescaria;
	}

	public void setTipoPescaria(String tipoPescaria) {
		this.tipoPescaria = tipoPescaria;
	}

}