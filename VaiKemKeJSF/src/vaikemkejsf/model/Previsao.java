package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the previsao database table.
 * 
 */
@Entity
public class Previsao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cidade;

	private String tipoprevisao;

	public Previsao() {
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

	public String getTipoprevisao() {
		return this.tipoprevisao;
	}

	public void setTipoprevisao(String tipoprevisao) {
		this.tipoprevisao = tipoprevisao;
	}

}