package ulusoy.at.wicket.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class BestellteArtikel extends Base {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Double neuPreis;

	@NotNull
	private Integer menge;

	@ManyToOne
	@NotNull
	@JoinColumn(name="bestellung_id")
	private Bestellung bestellung;

	@NotNull
	private String name;

	private String art;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

	public Double getNeuPreis() {
		return neuPreis;
	}

	public void setNeuPreis(Double neuPreis) {
		this.neuPreis = neuPreis;
	}

	public Integer getMenge() {
		return menge;
	}

	public void setMenge(Integer menge) {
		this.menge = menge;
	}

	@Transient
	public Double getSumme()
	{
		return menge * neuPreis;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	@Override
	public void clearInternal() {
		// TODO Auto-generated method stub

	}




}
