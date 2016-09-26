package ulusoy.at.wicket.entity;

import java.beans.Transient;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Kunde extends Base {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String kundeName;
	private String kundeNachname;
	private Date   kundeGeburtsdatum;
	private String kundeAdresse;
	private String kundeOrt;
	private String kundePLZ;
	private String kundeTelnummer;
	private String kundeEmailadresse;
	private String kundeFirmaname;
	private String kundeLogo;
	 @OneToMany(mappedBy = "kunde", targetEntity = Bestellung.class)
	private List<Bestellung> bestellung;


	/**
	 * Getter und Setter
	 * @return
	 */

	public String getKundeName() {
		return kundeName;
	}
	public List<Bestellung> getBestellung() {
		return bestellung;
	}
	public void setBestellung(List<Bestellung> bestellung) {
		this.bestellung = bestellung;
	}
	public void setKundeName(String kundeName) {
		this.kundeName = kundeName;
	}
	public String getKundeNachname() {
		return kundeNachname;
	}
	public void setKundeNachname(String kundeNachname) {
		this.kundeNachname = kundeNachname;
	}
	public Date getKundeGeburtsdatum() {
		return kundeGeburtsdatum;
	}
	public void setKundeGeburtsdatum(Date kundeGeburtsdatum) {
		this.kundeGeburtsdatum = kundeGeburtsdatum;
	}
	public String getKundeAdresse() {
		return kundeAdresse;
	}
	public void setKundeAdresse(String kundeAdresse) {
		this.kundeAdresse = kundeAdresse;
	}
	public String getKundeOrt() {
		return kundeOrt;
	}
	public void setKundeOrt(String kundeOrt) {
		this.kundeOrt = kundeOrt;
	}
	public String getKundePLZ() {
		return kundePLZ;
	}
	public void setKundePLZ(String kundePLZ) {
		this.kundePLZ = kundePLZ;
	}
	public String getKundeTelnummer() {
		return kundeTelnummer;
	}
	public void setKundeTelnummer(String kundeTelnummer) {
		this.kundeTelnummer = kundeTelnummer;
	}
	public String getKundeEmailadresse() {
		return kundeEmailadresse;
	}
	public void setKundeEmailadresse(String kundeEmailadresse) {
		this.kundeEmailadresse = kundeEmailadresse;
	}
	public String getKundeFirmaname() {
		return kundeFirmaname;
	}
	public void setKundeFirmaname(String kundeFirmaname) {
		this.kundeFirmaname = kundeFirmaname;
	}
	public String getKundeLogo() {
		return kundeLogo;
	}
	public void setKundeLogo(String kundeLogo) {
		this.kundeLogo = kundeLogo;
	}
	@Override
	public void clearInternal() {
		setKundeAdresse(null);
		setKundeEmailadresse(null);
		setKundeFirmaname(null);
		setKundeGeburtsdatum(null);
		setKundeLogo(null);
		setKundeNachname(null);
		setKundeName(null);
		setKundeOrt(null);
		setKundePLZ(null);
		setKundeTelnummer(null);

	}
	@Transient
	public String getFullName()
	{
		return getKundeName() + "  "+getKundeNachname();
	}




}
