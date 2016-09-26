package ulusoy.at.wicket.service.impl;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.dao.IBestellteArtikelDAO;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.service.IBestellteArtikelService;


@Named
public class BestellteArtikelServiceImpl implements IBestellteArtikelService{

	@Inject
	private IBestellteArtikelDAO  bestellteArtikelDAO;

	@Override
	public void save(BestellteArtikel bestellteArtikel)
			throws ApplicationException {
		bestellteArtikelDAO.save(bestellteArtikel);

	}

	@Override
	public void deleteWithId(Long id) throws ApplicationException {
		bestellteArtikelDAO.delete(id);

	}

	@Override
	public void saveAndFlush(BestellteArtikel bestellteArtikel)
			throws ApplicationException {
		bestellteArtikelDAO.saveAndFlush(bestellteArtikel);

	}

	@Override
	public void deleteObjekt(BestellteArtikel artikel)
			throws ApplicationException {
		bestellteArtikelDAO.delete(artikel);

	}
	/**
	@Override
	public List<BestellteArtikel> getAllBestellteArtikel(Bestellung bestellung)
			throws ApplicationException {

		return bestellteArtikelDAO.findByBestellung(bestellung.getId());
	}

	@Override
	public List<BestellteArtikel> getAllBestellteArtikelOrderByBestellung() {

		return bestellteArtikelDAO.findAllOrderByBestellung();
	}
 **/



	@Override
	public List<BestellteArtikel> findByBestellung(Bestellung bestellung) {

		return bestellteArtikelDAO.findByBestellung(bestellung);
	}

	@Override
	public List<BestellteArtikel> getBestellungvonDatum(Date date) {

		return bestellteArtikelDAO.getBestellungvonDatum(date);
	}


	@Override
	public List<BestellteArtikel> getAllBestellteArtikels() {

		return bestellteArtikelDAO.findAll();
	}


	public Page<BestellteArtikel> search(Date von, Date bis,Integer pageNum,Integer pageSize) {

		final List<BestellteArtikel> bestellteArtikelListe=new ArrayList<BestellteArtikel>();
		if(StringUtils.isNotBlank(von.toString())&& StringUtils.isBlank(bis.toString()))
		{
			CollectionUtils.addIgnoreNull(bestellteArtikelListe, getBestellungvonDatum(von));
			return new PageImpl<BestellteArtikel>(bestellteArtikelListe);
		}
		CollectionUtils.addIgnoreNull(bestellteArtikelListe, findByCreatedDateFromTo(von,bis));

		return new PageImpl<BestellteArtikel>(bestellteArtikelListe);
	}

	@Override
	public List<BestellteArtikel> findByCreatedDateFromTo(Date von, Date bis) {

		return this.bestellteArtikelDAO.findByCreatedBetween(von, bis);
	}

}
