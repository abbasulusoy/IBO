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
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.entity.model.ProduktModel;
import ulusoy.at.wicket.service.IProduktService;

public class ProduktDataProvider implements IDataProvider<Produkt>{



	private static final long serialVersionUID = 1L;

	@Inject
	private IProduktService produktService;

	IModel <Bestellung> bestellungsModel;
	private List<Produkt> produkte;

	public ProduktDataProvider()
	{
		Injector.get().inject(this);
	}
	public ProduktDataProvider(IModel<Bestellung> bestellungsModel)
	{
		Injector.get().inject(this);
		this.bestellungsModel=bestellungsModel;
	}

	@Override
	public void detach() {
		if(bestellungsModel !=null)
		{
			this.bestellungsModel.detach();
		}
		this.produkte=null;
	}

	@Override
	public Iterator<? extends Produkt> iterator(long first, long count) {
		try {
			fillProdukte();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final List<Produkt> produkte=new ArrayList<>(this.produkte);
        final int firstInt = Long.valueOf(first).intValue();
        final int countInt = Long.valueOf(count).intValue();

		return produkte.subList(firstInt,firstInt+countInt).iterator();
	}

	@Override
	public long size() {
		try {
			fillProdukte();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.produkte.size();
	}
	public void fillProdukte() throws ApplicationException
	{
		if(this.produkte==null)
		{
			this.produkte=this.produktService.getAllProdukte();
		}
	}

	@Override
	public IModel<Produkt> model(Produkt object) {

		return new ProduktModel(object);
	}

}
