package ulusoy.at.wicket.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.model.BestellteArtikelModel;
import ulusoy.at.wicket.service.IBestellteArtikelService;

public class EinkaufsListeDataProvider implements IDataProvider<BestellteArtikel>{



	private static final long serialVersionUID = 1L;

	@Inject
	private IBestellteArtikelService bestellteArtikelService;

	private List<BestellteArtikel> bestellteArtikels=new ArrayList<>();
	private Date date;
	public EinkaufsListeDataProvider(Date date)
	{
		Injector.get().inject(this);
		this.date=date;
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
	public void fillBestellteArtikels() throws ApplicationException, ParseException
	{
		 final Date todayDate = this.date;
         final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
         final String today = dateFormat.format(todayDate);

		if(this.bestellteArtikels==null)
		{
			this.bestellteArtikels=this.bestellteArtikelService.getBestellungvonDatum(dateFormat.parse(today));
		}
	}

	public Map<String, BestellteArtikel> createMyHashMap() throws ApplicationException, ParseException
	{

		Map<String, BestellteArtikel> myMap=new HashMap<String, BestellteArtikel>();

		 final Date todayDate = new Date();
         final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
         final String today = dateFormat.format(todayDate);

			Date fristTime=dateFormat.parse(today);


		this.bestellteArtikels=this.bestellteArtikelService.getBestellungvonDatum(fristTime);


		for (BestellteArtikel bestellteArtikel: bestellteArtikels) {
			String key=bestellteArtikel.getName()+"."+bestellteArtikel.getArt();
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
        	Entry<String, BestellteArtikel> entry =iterator.next();
            this.bestellteArtikels.add(entry.getValue());
         }

	}

	@Override
	public IModel<BestellteArtikel> model(BestellteArtikel object) {

		return new BestellteArtikelModel(object);
	}

}
