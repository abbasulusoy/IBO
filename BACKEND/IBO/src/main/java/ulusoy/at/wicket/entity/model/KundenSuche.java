package ulusoy.at.wicket.entity.model;

import java.io.Serializable;

public class KundenSuche implements Serializable {

	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String firmaname;
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getFirmaname() {
		return firmaname;
	}
	public void setFirmaname(String firmaname) {
		this.firmaname = firmaname;
	}



}
