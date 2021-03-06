package ulusoy.at.wicket.entity;


import java.beans.Transient;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;



@Entity
public class Bestellung extends Base {

	private static final long serialVersionUID = 1L;



	@OneToMany(targetEntity=BestellteArtikel.class,mappedBy="bestellung",cascade={CascadeType.ALL})
	@OrderBy("Name ASC")
	private List<BestellteArtikel> produkte=new ArrayList<>();

	@ManyToOne
	//@JoinColumn(name="kunde_fk")
	private Kunde kunde;
	private Date bestelltDatum;

	private Double gesamtpreis;

	private String mehrwertSteuer;
	public Date getBestelltDatum() {
		return bestelltDatum;
	}

	public void setBestelltDatum(Date bestelltDatum) {
		this.bestelltDatum = bestelltDatum;
	}

	public Double getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(Double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	public List<BestellteArtikel> getProdukte() {
		return produkte;
	}

	public void setProdukte(List<BestellteArtikel> produkte) {
		this.produkte = produkte;
	}
	public String getMehrwertSteuer() {
		return mehrwertSteuer;
	}

	public void setMehrwertSteuer(String mehrwertSteuer) {
		this.mehrwertSteuer = mehrwertSteuer;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	@Transient
	public String getTotal()
	{
		double summe=0;
		final List<BestellteArtikel> produkte=getProdukte();
		final Iterator<BestellteArtikel> produktIter=produkte.iterator();
		while(produktIter.hasNext())
		{
			summe +=produktIter.next().getSumme();
		}

		return summe +"";
	}

	@Transient
	public String getMehrwertSteuerTotalMit()
	{
		DecimalFormat kommaFormat = new DecimalFormat("#0.00");
		Double summe=Double.parseDouble(getTotal());
		if(getMehrwertSteuer()!=null && getMehrwertSteuer().equalsIgnoreCase("10%"))
		{
			summe=summe + summe*0.1;
		}
		String mySumme=kommaFormat.format(summe);

		return mySumme;
	}

	@Transient
	public String getMehrwertSteuer10()
	{
		DecimalFormat kommaFormat = new DecimalFormat("#0.00");
		Double summe=Double.parseDouble(getTotal());
		if(getMehrwertSteuer()!=null && getMehrwertSteuer().equalsIgnoreCase("10%"))
		{
			summe=summe * 0.1;
		}
		else
		{
			summe=summe *0.0;
		}
		String mySumme=kommaFormat.format(summe);

		return mySumme;
	}

	@Override
	public void clearInternal() {


	}
}
