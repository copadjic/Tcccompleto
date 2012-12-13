package vaikemkejsf.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the galeriapeixe database table.
 * 
 */
@Entity
public class Galeriapeixe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tambacus;

	public Galeriapeixe() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTambacus() {
		return this.tambacus;
	}

	public void setTambacus(String tambacus) {
		this.tambacus = tambacus;
	}

}