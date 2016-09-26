package ulusoy.at.wicket.component.suche.produkt;

import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.pages.produkt.EditProduktPage;
import ulusoy.at.wicket.service.IProduktService;
import ulusoy.at.wicket.table.AbstractColumnActionsPanel;


public class EditAbleProduktPropertyColumn extends AbstractColumnActionsPanel<Produkt>{


	private static final long serialVersionUID = 1L;

	@SpringBean
	private IProduktService ProduktService;




	public EditAbleProduktPropertyColumn(String id, final IModel<Produkt> ProduktModel) {
		super(id, ProduktModel);
        final Link<Produkt> editLink = new Link<Produkt>("editLink", ProduktModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                final PageParameters pageParameters = new PageParameters();
                pageParameters.add(EditProduktPage.PARAM_PRODUKT_ID,getModel().getObject().getId());
                setResponsePage(EditProduktPage.class, pageParameters);
            }
        };
        editLink.add(new ContextImage("editImage","images/edit.png"));
        add(editLink);

        final Link<Produkt> deleteLink = new Link<Produkt>("deleteLink", ProduktModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
             try {

            		  ProduktService.deleteObjekt(ProduktModel.getObject());
            		  getSession().info("Der Produkt " +ProduktModel.getObject().getName()+  "wurde geloescht");
             }
             catch (ApplicationException e) {
				 getSession().info("Der Produkt " +ProduktModel.getObject().getName()+"kann leider nicht geloescht werden" +e.getMessage());

			}

            }
        };
        deleteLink.add(new ContextImage("deleteImage","images/delete.png"));
        add(deleteLink);
	}









}
