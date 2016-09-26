package ulusoy.at.wicket.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.model.BestellteArtikelModel;
import ulusoy.at.wicket.entity.model.EinkaufListeModel;
import ulusoy.at.wicket.service.IBestellteArtikelService;

public class EinkaufsSearchListeDataProvider implements IDataProvider<BestellteArtikel>{



	private static final long serialVersionUID = 1L;

	@Inject
	private IBestellteArtikelService bestellteArtikelService;

	private List<BestellteArtikel> bestellteArtikels=new ArrayList<>();
	public List<BestellteArtikel> getBestellteArtikels() {
		return bestellteArtikels;
	}

	public void setBestellteArtikels(List<BestellteArtikel> bestellteArtikels) {
		this.bestellteArtikels = bestellteArtikels;
	}

	private final Model<EinkaufListeModel> einkaufslisteModel;
	public EinkaufsSearchListeDataProvider(Model<EinkaufListeModel> einkaufslisteModel)
	{
		Injector.get().inject(this);
		this.einkaufslisteModel=einkaufslisteModel;
	}

	@Override
	public void detach() {

	}


	@Override
	public Iterator<? extends BestellteArtikel> iterator(long first, long count) {
		try {
			getMyEinkaufsListe();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final List<BestellteArtikel> bestellteArtikelsvonDatum=new ArrayList<BestellteArtikel>(this.bestellteArtikels);
        final int firstInt = Long.valueOf(first).intValue();
        final int countInt = Long.valueOf(count).intValue();

		return bestellteArtikelsvonDatum.subList(firstInt,firstInt+countInt).iterator();
	}

	@Override
	public long size() {
		try {
			getMyEinkaufsListe();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.bestellteArtikels.size();
	}


	public Map<String, BestellteArtikel> createMyHashMap() throws ApplicationException, ParseException
	{

		Map<String, BestellteArtikel> myMap=new HashMap<String, BestellteArtikel>();
		if(einkaufslisteModel.getObject().getCreatedBis()==null)
		{
			this.bestellteArtikels=this.bestellteArtikelService.getBestellungvonDatum(einkaufslisteModel.getObject().getCreatedVon());
		}
		else
		{
			this.bestellteArtikels=this.bestellteArtikelService.findByCreatedDateFromTo(einkaufslisteModel.getObject().getCreatedVon(), einkaufslisteModel.getObject().getCreatedBis());
		}

		for (BestellteArtikel bestellteArtikel: bestellteArtikels) {
			String name=bestellteArtikel.getName().toLowerCase();
			String key=name+"."+bestellteArtikel.getArt();
			if(!myMap.containsKey(key))
	    	   {
				myMap.put(key, bestellteArtikel);
	    	   }
	    	   else
	    	   {
	    		   bestellteArtikel.setMenge(myMap.get(key).getMenge()+bestellteArtikel.getMenge());
	    		   myMap.put(key,bestellteArtikel);
	    	   }

		}
		return myMap;
	}
	public void getMyEinkaufsListe() throws ApplicationException, ParseException
	{
		Map<String, BestellteArtikel> myMap=createMyHashMap();
		this.bestellteArtikels=new ArrayList<>();
		 Iterator<Entry<String, BestellteArtikel>> iterator= myMap.entrySet().iterator();
         while(iterator.hasNext())
         {
        	Entry<String,BestellteArtikel> entry =iterator.next();
            this.bestellteArtikels.add(entry.getValue());
         }

	}

	@Override
	public IModel<BestellteArtikel> model(BestellteArtikel object) {

		return new BestellteArtikelModel(object);
	}

}
