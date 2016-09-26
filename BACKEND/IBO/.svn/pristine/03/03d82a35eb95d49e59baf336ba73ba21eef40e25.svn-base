package ulusoy.at.wicket.data;
import java.util.Iterator;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.entity.model.KundeModel;
import ulusoy.at.wicket.entity.model.KundenSuche;
import ulusoy.at.wicket.service.IKundeService;

public class KundeSearchDataProvider implements IDataProvider<Kunde>{

	private static final long serialVersionUID = 1L;

	private IModel<KundenSuche> kundenSucheModel;

	@SpringBean
	private IKundeService kundeService;

	public KundeSearchDataProvider(final IModel<KundenSuche> kundenSucheModel)
	{
		Injector.get().inject(this);
		this.kundenSucheModel=kundenSucheModel;
	}
	@Override
	public void detach() {
		if(this.kundenSucheModel!=null)
		{
			this.kundenSucheModel.detach();
		}
	}

	@Override
	public Iterator<? extends Kunde> iterator(long first, long count) {

		return this.kundeService.search(this.kundenSucheModel.getObject().getFirmaname(),this.kundenSucheModel.getObject().getVorname(), this.kundenSucheModel.getObject().getNachname(), (int) Math.ceil(first/count), (int) count).iterator();
	}

	@Override
	public long size() {
		return this.kundeService.search(this.kundenSucheModel.getObject().getFirmaname(),this.kundenSucheModel.getObject().getVorname(), this.kundenSucheModel.getObject().getNachname(), 0, 1).getTotalElements();
	}

	@Override
	public IModel<Kunde> model(Kunde object) {

		return new KundeModel(object);
	}
	public void setKundenSucheModel(IModel<KundenSuche> kundenSucheModel) {
		this.kundenSucheModel = kundenSucheModel;
	}

}
