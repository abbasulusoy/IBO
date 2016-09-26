package ulusoy.at.wicket.data;
import java.util.Iterator;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.entity.model.ProduktModel;
import ulusoy.at.wicket.entity.model.ProduktSuche;
import ulusoy.at.wicket.service.IProduktService;

public class ProduktSearchDataProvider implements IDataProvider<Produkt>{

	private static final long serialVersionUID = 1L;

	private IModel<ProduktSuche> produktSucheModel;

	@SpringBean
	private IProduktService produktService;

	public ProduktSearchDataProvider(final IModel<ProduktSuche> produktSucheModel)
	{
		Injector.get().inject(this);
		this.produktSucheModel=produktSucheModel;
	}
	@Override
	public void detach() {
		if(this.produktSucheModel!=null)
		{
			this.produktSucheModel.detach();
		}
	}

	@Override
	public Iterator<? extends Produkt> iterator(long first, long count) {


		return this.produktService.search(this.produktSucheModel.getObject().getName(),this.produktSucheModel.getObject().getPreis(), this.produktSucheModel.getObject().getPreis2(),this.produktSucheModel.getObject().getArt(), (int) Math.ceil(first/count), (int) count).iterator();
	}

	@Override
	public long size() {
		return this.produktService.search(this.produktSucheModel.getObject().getName(), this.produktSucheModel.getObject().getPreis(),this.produktSucheModel.getObject().getPreis2(), this.produktSucheModel.getObject().getArt(), 0, 1).getTotalElements();
	}

	@Override
	public IModel<Produkt> model(Produkt object) {

		return new ProduktModel(object);
	}
	public void setKundenSucheModel(IModel<ProduktSuche> produktSucheModel) {
		this.produktSucheModel = produktSucheModel;
	}

}
