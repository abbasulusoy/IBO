package ulusoy.at.wicket.entity.model;

import java.io.Serializable;
import java.util.Date;

import ulusoy.at.wicket.entity.Kunde;



public class BestellSuche implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;

	private Date createdVon;
	private Date createdBis;
	private Kunde kunde;
	private String produktName;
	private String mehrwertSteuer;

	public String getMehrwertSteuer() {
		return mehrwertSteuer;
	}
	public void setMehrwertSteuer(String mehrwertSteuer) {
		this.mehrwertSteuer = mehrwertSteuer;
	}
	public Date getCreatedVon() {
		return createdVon;
	}
	public void setCreatedVon(Date createdVon) {
		this.createdVon = createdVon;
	}
	public Date getCreatedBis() {
		return createdBis;
	}
	public void setCreatedBis(Date createdBis) {
		this.createdBis = createdBis;
	}


	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public String getProduktName() {
		return produktName;
	}
	public void setProduktName(String produktName) {
		this.produktName = produktName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


}
