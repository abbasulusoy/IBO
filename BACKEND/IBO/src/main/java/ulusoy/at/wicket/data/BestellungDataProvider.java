package ulusoy.at.wicket.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.model.BestellungModel;
import ulusoy.at.wicket.service.IBestellungService;

public class BestellungDataProvider implements IDataProvider<Bestellung>{



	private static final long serialVersionUID = 1L;

	@Inject
	private IBestellungService bestellungService;

	private List<Bestellung> bestellungen;

	public BestellungDataProvider()
	{
		Injector.get().inject(this);
	}

	@Override
	public void detach() {
		this.bestellungen=null;
	}

	@Override
	public Iterator<? extends Bestellung> iterator(long first, long count) {
		try {
			fillBestellungen();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		final List<Bestellung> bestellungen=new ArrayList<>(this.bestellungen);
        final int firstInt = Long.valueOf(first).intValue();
        final int countInt = Long.valueOf(count).intValue();

		return bestellungen.subList(firstInt,firstInt+countInt).iterator();
	}

	@Override
	public long size() {
		try {
			fillBestellungen();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.bestellungen.size();
	}
	public void fillBestellungen() throws ApplicationException
	{
		if(this.bestellungen==null)
		{
			this.bestellungen=this.bestellungService.getAllBestellungen();
		}
	}

	@Override
	public IModel<Bestellung> model(Bestellung object) {

		return new BestellungModel(object);
	}

}
