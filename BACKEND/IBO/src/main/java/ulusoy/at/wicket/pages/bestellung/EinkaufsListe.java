package ulusoy.at.wicket.pages.bestellung;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.data.EinkaufsListeDataProvider;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.service.DocumentService;
import ulusoy.at.wicket.service.IBestellungService;
import ulusoy.at.wicket.template.Template;

public class EinkaufsListe extends Template {
	private static final long serialVersionUID = 1L;

	@SpringBean
	IBestellungService bestellungService;

	private int i=0;
	@Inject
	private DocumentService documentService;

	private List<BestellteArtikel> bestellteArtikels;


	public List<BestellteArtikel> getBestellteArtikels() {
		return bestellteArtikels;
	}
	public void setBestellteArtikels(List<BestellteArtikel> bestellteArtikels) {
		this.bestellteArtikels = bestellteArtikels;
	}
	public EinkaufsListe()
	{
		initPage();
		bestellteArtikels=new ArrayList<>();

	}
	public void initPage()
	{
		final Form<String> bestellteArtikelForm = new Form<>("bestellungForm");
		bestellteArtikelForm.setOutputMarkupId(true);
		add(bestellteArtikelForm);


		final DataView<BestellteArtikel> bestellungen=new DataView<BestellteArtikel>("bestellungen",
				new EinkaufsListeDataProvider(new Date())) {

			private static final long serialVersionUID = 1L;


			@Override
			protected void populateItem(final Item<BestellteArtikel> item) {

				item.add(new Label("nummer", ++i));
				item.add(new Label("art", new PropertyModel<>(item.getModel(), "art")));
				item.add(new Label("menge", new PropertyModel<>(item.getModel(), "menge")));
				item.add(new Label("name", new PropertyModel<>(item.getModel(), "name")));

				bestellteArtikels.add(item.getModelObject());

			}

		};

		 final DownloadLink downloadLink = new DownloadLink("downloadLink", new AbstractReadOnlyModel<File>() {
	            /**
			 *
			 */

			private static final long serialVersionUID = 1L;

				@Override
	            public File getObject() {
	                return EinkaufsListe.this.documentService.printEinkaufListe(bestellteArtikels);
	            }

	        }) {
	            private static final long serialVersionUID = 1L;

	            @Override
	            public boolean isVisible() {
	                return bestellungen.getItems().hasNext();
	            }
	        };

	    add(downloadLink);
		bestellteArtikelForm.add(bestellungen);
	}

}



