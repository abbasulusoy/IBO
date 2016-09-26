package ulusoy.at.wicket.service;



import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;


import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.Kunde;

@Validated
public interface IBestellungService{

	public void save(@Valid  Bestellung bestellung) throws ApplicationException;
	public void deleteWithId(@NotNull Long id)  throws ApplicationException;
	public void saveAndFlush(@NotNull Bestellung bestellung) throws ApplicationException;
	public void deleteObjekt(@NotNull Bestellung bestellung) throws ApplicationException;
	public List<Bestellung> getAllBestellungen() throws ApplicationException;
	public Boolean exitst(Bestellung bestellung);
	public List<BestellteArtikel> getMeinBestellung(Bestellung bestellung);
	public Page<Bestellung> search(Long id,Kunde kunde,Date createdVon,Date createdBis,String steuer,Integer pageNum,Integer pageSize);

}
