package ulusoy.at.wicket.service.impl;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.dao.IBestellungDAO;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.service.IBestellteArtikelService;
import ulusoy.at.wicket.service.IBestellungService;

@Named
public class BestellungServiceImpl implements IBestellungService{

	@Inject
	private IBestellungDAO bestellungDao;

	@Inject
	private IBestellteArtikelService bestellteArtikelService;

	@Override
	public void save(Bestellung bestellung) throws ApplicationException {
		bestellungDao.save(bestellung);

	}

	@Override
	public void deleteWithId(Long id) throws ApplicationException {
		bestellungDao.delete(id);
	}

	@Override
	public void saveAndFlush(Bestellung bestellung) throws ApplicationException {
		bestellungDao.saveAndFlush(bestellung);

	}

	@Override
	public void deleteObjekt(Bestellung bestellung) throws ApplicationException {
		bestellungDao.delete(bestellung);
	}

	@Override
	public List<Bestellung> getAllBestellungen() throws ApplicationException {
		return bestellungDao.findAll();
	}

	@Override
	public Boolean exitst(Bestellung bestellung) {
		if(bestellung==null || bestellung.getId()==null)
		{
			return false;
		}
		return this.bestellungDao.exists(bestellung.getId());
	}

	@Override
	public List<BestellteArtikel> getMeinBestellung(Bestellung bestellung) {
		return bestellteArtikelService.findByBestellung(bestellung);
	}



	@Override
	public Page<Bestellung> search(Long id, Kunde kunde, Date createdVon,
			Date createdBis, String steuer, Integer pageNum, Integer pageSize) {
		if(id!=null && id!=0)
		{
			//return bestellungDao.findById(id, pr);
			return new PageImpl<Bestellung>(bestellungDao.findById(id));
		}
		if(kunde!=null)
		{
			//return bestellungDao.findByKunde(kunde, pr);
			return new PageImpl<Bestellung>( bestellungDao.findByKunde(kunde));
		}


		if(createdVon!=null &&createdBis!=null)
		{
			//return bestellungDao.findByCreatedBetween(createdVon, createdBis, pr);
			return new PageImpl<>(bestellungDao.findByCreatedBetween(createdVon, createdBis));
		}
		if(StringUtils.isNotBlank(steuer))
		{
			return new PageImpl<>(bestellungDao.findByMehrwertSteuer(steuer));
		}
		return  new PageImpl<Bestellung>(bestellungDao.findAll());
	}





}
