package ulusoy.at.wicket.component.suche.bestellung;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.pages.bestellung.EditBestellungPage;
import ulusoy.at.wicket.service.DocumentService;
import ulusoy.at.wicket.service.IBestellungService;
import ulusoy.at.wicket.table.AbstractColumnActionsPanel;


public class EditAbleBestellungPropertyColumn extends AbstractColumnActionsPanel<Bestellung>{


	private static final long serialVersionUID = 1L;


	@SpringBean
	private IBestellungService bestellungService;

	@Inject
	private DocumentService documentService;

	public EditAbleBestellungPropertyColumn(String id, final IModel<Bestellung> bestellModel) {
		super(id, bestellModel);
        final Link<Bestellung> editLink = new Link<Bestellung>("editLink", bestellModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                final PageParameters pageParameters = new PageParameters();
                pageParameters.add(EditBestellungPage.PARAM_BESTELLUNG_ID,getModel().getObject().getId());
                setResponsePage(EditBestellungPage.class, pageParameters);
            }
        };
        editLink.add(new ContextImage("editImage", "images/edit.jpg"));
        add(editLink);

        final Link<Bestellung> deleteLink = new Link<Bestellung>("deleteLink", bestellModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
             try {


            		  bestellungService.deleteObjekt(bestellModel.getObject());
            		  getSession().info("Der Bestellung " +bestellModel.getObject().getId()+  "wurde geloescht");
             }
             catch (ApplicationException e) {
				 getSession().info("Der Bestellung " +bestellModel.getObject().getId()+  "kann leider nicht geloescht werden" +e.getMessage());

			}

            }
        };
        deleteLink.add(new ContextImage("deleteImage", "images/delete.png"));
        add(deleteLink);

        final DownloadLink downloadLink = new DownloadLink("downloadLink", new AbstractReadOnlyModel<File>() {
            /**
		 *
		 */
		private static final long serialVersionUID = 1L;

			@Override
            public File getObject() {

				List<BestellteArtikel> produkte=bestellungService.getMeinBestellung(bestellModel.getObject());
				bestellModel.getObject().setProdukte(produkte);

                return EditAbleBestellungPropertyColumn.this.documentService.printBestellungToDocx(bestellModel.getObject());
            }

        }) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isVisible() {
                return bestellungService.exitst(bestellModel.getObject());
            }
        };
        downloadLink.add(new ContextImage("printImage", "images/print.png"));
        add(downloadLink);
	}








}
