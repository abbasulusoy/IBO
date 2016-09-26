package ulusoy.at.wicket.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;



@Entity
public class Produkt extends Base {
	private static final long serialVersionUID = 1L;


	private String name;
	private String beschreibung;
	private String art;
	@Column(nullable=false)
	private String land;
	@NotNull
	@Column(precision=7,scale=3)
	private Double preis;
	private String kommentar;
	@Column(nullable=false)
	private String nummer;

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public Double getPreis() {
		return preis;
	}

	public void setPreis(Double preis) {
		this.preis = preis;
	}

	@Override
	public void clearInternal() {
		setName(null);
		setPreis(null);
		setLand(null);
		setArt(null);
		setBeschreibung(null);
		setNummer(null);
		setKommentar(null);
	}




}
