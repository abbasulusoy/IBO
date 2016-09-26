package ulusoy.at.wicket.service;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;

@Validated
public interface IBestellteArtikelService{

	public void save(@Valid  BestellteArtikel bestellteArtikel) throws ApplicationException;
	public void deleteWithId(@NotNull Long id)  throws ApplicationException;
	public void saveAndFlush(@NotNull BestellteArtikel bestellteArtikel) throws ApplicationException;
	public void deleteObjekt(@NotNull BestellteArtikel artikel) throws ApplicationException;
	public List<BestellteArtikel> findByBestellung(Bestellung bestellung);
	//public List<BestellteArtikel> getAllBestellteArtikel(Bestellung bestellung) throws ApplicationException;
	//public List<BestellteArtikel> getAllBestellteArtikelOrderByBestellung();
	public List<BestellteArtikel> getAllBestellteArtikels();
	public List<BestellteArtikel> getBestellungvonDatum(Date date);
	public List<BestellteArtikel> findByCreatedDateFromTo(Date von, Date bis);
}
