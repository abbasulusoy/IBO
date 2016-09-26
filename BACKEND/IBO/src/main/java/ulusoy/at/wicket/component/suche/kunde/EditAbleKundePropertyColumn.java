package ulusoy.at.wicket.component.suche.kunde;

import java.util.List;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.pages.kunde.EditKundePage;
import ulusoy.at.wicket.service.IBestellungService;
import ulusoy.at.wicket.service.IKundeService;
import ulusoy.at.wicket.table.AbstractColumnActionsPanel;


public class EditAbleKundePropertyColumn extends AbstractColumnActionsPanel<Kunde>{


	private static final long serialVersionUID = 1L;

	@SpringBean
	private IKundeService kundeService;

	@SpringBean
	private IBestellungService bestellungService;

	public EditAbleKundePropertyColumn(String id, final IModel<Kunde> kundeModel) {
		super(id, kundeModel);
        final Link<Kunde> editLink = new Link<Kunde>("editLink", kundeModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                final PageParameters pageParameters = new PageParameters();
                pageParameters.add(EditKundePage.PARAM_KUNDE_ID,getModel().getObject().getId());
                setResponsePage(EditKundePage.class, pageParameters);
            }
        };

        add(editLink);

        final Link<Kunde> deleteLink = new Link<Kunde>("deleteLink", kundeModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
             try {
            	  if(!hatKundeBestellung(kundeModel.getObject()))
            	  {
            		  kundeService.deleteObjekt(kundeModel.getObject());
            		  getSession().info("Der Kunde " +kundeModel.getObject().getFullName()+  "wurde geloescht");
            	  }
            	  else
            		  getSession().info("Der Kunde " +kundeModel.getObject().getFullName()+  " kann nicht  geloescht , weil der eine Bestellung hat");
            	  }
             catch (ApplicationException e) {
				 getSession().info("Der Kunde " +kundeModel.getObject().getFullName()+  "kann leider nicht geloescht werden" +e.getMessage());

			}

            }
        };

        add(deleteLink);
	}

	private boolean hatKundeBestellung(Kunde kunde) throws ApplicationException
	{
		 boolean kundeHatBestellung=false;

		 for(Bestellung bestellung: getBestellungen())
		 {
			 if(bestellung.getKunde().getId()==kunde.getId())
			 {
				 kundeHatBestellung=true;
			 }
		 }

		 return kundeHatBestellung;

	}
	private List<Bestellung> getBestellungen() throws ApplicationException
	{
		return bestellungService.getAllBestellungen();
	}






}
