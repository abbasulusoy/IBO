package ulusoy.at.wicket.pages.bestellung;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.service.IKundeService;




public abstract class ArtikelListActionColumnPanel extends AbtractArtikelListActionColumnPanel<Kunde>{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private IKundeService kundeService;
	public ArtikelListActionColumnPanel(String id,final IModel<Kunde> kundeModel,
			final IModel<Kunde> selectedKundeModel) {
		super(id, selectedKundeModel);

				final Link<Kunde> deleteKundeLink=new Link<Kunde>("deleteKundeLink",kundeModel)
						{

					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {

						try {
							kundeService.deleteObjekt(kundeModel.getObject());
						} catch (ApplicationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

		};
		add(deleteKundeLink);
	}
}
