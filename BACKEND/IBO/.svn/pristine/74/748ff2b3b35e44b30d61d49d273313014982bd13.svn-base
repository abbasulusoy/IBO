package ulusoy.at.wicket.data;
import java.util.Iterator;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.model.BestellSuche;
import ulusoy.at.wicket.entity.model.BestellungModel;
import ulusoy.at.wicket.service.IBestellungService;

public class BestellSearchDataProvider implements IDataProvider<Bestellung>{

	private static final long serialVersionUID = 1L;

	private IModel<BestellSuche> bestellSucheModel;

	@SpringBean
	private IBestellungService bestellungService;

	public BestellSearchDataProvider(final IModel<BestellSuche> bestellSucheModel)
	{
		Injector.get().inject(this);
		this.bestellSucheModel=bestellSucheModel;
	}
	@Override
	public void detach() {
		if(this.bestellSucheModel!=null)
		{
			this.bestellSucheModel.detach();
		}
	}

	@Override
	public Iterator<? extends Bestellung> iterator(long first, long count) {

		return this.bestellungService.search(this.bestellSucheModel.getObject().getId(),this.bestellSucheModel.getObject().getKunde(),this.bestellSucheModel.getObject().getCreatedVon(),this.bestellSucheModel.getObject().getCreatedBis(),this.bestellSucheModel.getObject().getMehrwertSteuer(),(int) Math.ceil(first/count), (int) count).iterator();
	}

	@Override
	public long size() {

		return this.bestellungService.search(this.bestellSucheModel.getObject().getId(),this.bestellSucheModel.getObject().getKunde(),this.bestellSucheModel.getObject().getCreatedVon(),this.bestellSucheModel.getObject().getCreatedBis(),this.bestellSucheModel.getObject().getMehrwertSteuer(), 0, 1).getTotalElements();
	}

	@Override
	public IModel<Bestellung> model(Bestellung object) {

		return new BestellungModel(object);
	}

	public void setBestellSucheModel(IModel<BestellSuche> bestellSucheModel) {
		this.bestellSucheModel = bestellSucheModel;
	}

}
