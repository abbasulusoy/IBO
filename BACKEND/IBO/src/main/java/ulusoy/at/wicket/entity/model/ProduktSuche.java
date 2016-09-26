package ulusoy.at.wicket.entity.model;

import java.io.Serializable;

public class ProduktSuche implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double preis;
	private String  art;
	private double preis2;

	public double getPreis2() {
		return preis2;
	}
	public void setPreis2(double preis2) {
		this.preis2 = preis2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}


}
