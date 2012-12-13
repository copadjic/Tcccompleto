package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the visita database table.
 * 
 */
@Entity
public class Visita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataeHora;

	private String IPusuario;

	//bi-directional many-to-one association to Pesqueiro
	@ManyToOne
	private Pesqueiro pesqueiro;

	public Visita() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataeHora() {
		return this.dataeHora;
	}

	public void setDataeHora(Date dataeHora) {
		this.dataeHora = dataeHora;
	}

	public String getIPusuario() {
		return this.IPusuario;
	}

	public void setIPusuario(String IPusuario) {
		this.IPusuario = IPusuario;
	}

	public Pesqueiro getPesqueiro() {
		return this.pesqueiro;
	}

	public void setPesqueiro(Pesqueiro pesqueiro) {
		this.pesqueiro = pesqueiro;
	}

}