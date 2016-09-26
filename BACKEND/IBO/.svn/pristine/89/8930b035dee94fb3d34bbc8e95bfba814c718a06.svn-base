package ulusoy.at.wicket.pages.bestellung;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import ulusoy.at.wicket.dao.IBestellteArtikelDAO;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.model.BestellteArtikelModel;





public class WarenkorbListDataProvider implements IDataProvider<BestellteArtikel> {
	private static final long serialVersionUID = 1L;


	IModel<Bestellung> bestellungModel;
	@Inject
	private IBestellteArtikelDAO bestellteArtikelDAO;

	private List<BestellteArtikel> artikelsListe;

	public WarenkorbListDataProvider()
	{
		Injector.get().inject(this);
	}
	public WarenkorbListDataProvider(final IModel<Bestellung> bestellungModel) {

		Injector.get().inject(this);
		this.bestellungModel=bestellungModel;
	}

	@Override
	public void detach() {
		if (this.bestellungModel != null) {
			this.bestellungModel.detach();
		}
		this.artikelsListe = null;

	}

	@Override
	public Iterator<? extends BestellteArtikel> iterator(final long first, final long count) {
		fillArtikel();
		final List<BestellteArtikel> artikelList = new ArrayList<BestellteArtikel>(this.artikelsListe);
		return artikelList.subList((int) Math.ceil(first / count), (int) count).iterator();

	}
	public String getGesammt()
	{
		Double summe=0.0;
		if(artikelsListe !=null)
		{
			for (BestellteArtikel artikel : artikelsListe) {
				summe +=artikel.getSumme();
			}
		}
		return summe +"";

	}
	@Override
	public long size() {
		fillArtikel();
		return artikelsListe.size();
	}
	public void fillArtikel() {
		if (this.bestellungModel.getObject() == null || this.bestellungModel.getObject().getId() == null) {
			this.artikelsListe = new ArrayList<>();
		}
		if (this.artikelsListe == null) {
			this.artikelsListe= this.bestellteArtikelDAO.findByBestellung(bestellungModel.getObject());
		}
	}

	@Override
	public IModel<BestellteArtikel> model(BestellteArtikel object) {
		return new BestellteArtikelModel(object);
	}






}
