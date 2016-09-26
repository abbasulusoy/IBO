package ulusoy.at.wicket.pages.bestellung;


import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;


import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.component.suche.einkauftliste.EinkaufslisteSearchPanel;
import ulusoy.at.wicket.data.EinkaufsSearchListeDataProvider;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.model.EinkaufListeModel;
import ulusoy.at.wicket.service.DocumentService;
import ulusoy.at.wicket.service.IBestellungService;
import ulusoy.at.wicket.template.Template;

public class EinkaufsListeSuche extends Template {
	private static final long serialVersionUID = 1L;

	@SpringBean
	IBestellungService bestellungService;

	@Inject
	private DocumentService documentService;

	private List<BestellteArtikel> bestellteArtikels;

	private Model<EinkaufListeModel> einkaufslisteModel;

	public List<BestellteArtikel> getBestellteArtikels() {
		return bestellteArtikels;
	}
	public void setBestellteArtikels(List<BestellteArtikel> bestellteArtikels) {
		this.bestellteArtikels = bestellteArtikels;
	}
	public EinkaufsListeSuche()
	{
		initPage();
		bestellteArtikels=new ArrayList<>();

	}
	public void initPage()
	{
		this.einkaufslisteModel=Model.of(new EinkaufListeModel());

		final PropertyColumn<BestellteArtikel, String> name = new PropertyColumn<>(new StringResourceModel(
				"name", null, new Object[0]), "name");
		final PropertyColumn<BestellteArtikel, String> art = new PropertyColumn<>(new StringResourceModel(
				"art", null, new Object[0]), "art");
		final PropertyColumn<BestellteArtikel, String> menge= new PropertyColumn<>(new StringResourceModel(
				"menge", null, new Object[0]), "menge");
		/**
		final PanelColumn<Kunde, String> actionsColumn = new PanelColumn<Kunde, String>(
				Model.of(StringUtils.EMPTY)) {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getComponent(final String componentId, final IModel<Kunde> rowModel) {
				return new EditAblePropertyColumn(componentId, rowModel);
			}
		};
		**/
		final EinkaufsSearchListeDataProvider einkaufListe=new EinkaufsSearchListeDataProvider(
				this.einkaufslisteModel);
		final DataTable<BestellteArtikel, String> artikels = new DataTable<>("artikels",
				Arrays.asList(menge, art, name), einkaufListe, 15);

		artikels.setOutputMarkupId(true);

		add(artikels);

		add(new EinkaufslisteSearchPanel("einkaufsSearchPanel",this.einkaufslisteModel ) {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSearchComplete(final AjaxRequestTarget target) {
				target.add(artikels);
			}
		});

		 final DownloadLink downloadLink = new DownloadLink("downloadLink", new AbstractReadOnlyModel<File>() {
	         
			private static final long serialVersionUID = 1L;

				@Override
	            public File getObject() {
					try {
						einkaufListe.getMyEinkaufsListe();
					} catch (ApplicationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bestellteArtikels.addAll(einkaufListe.getBestellteArtikels());
	                return EinkaufsListeSuche.this.documentService.printEinkaufListe(bestellteArtikels);
	            }

	        }) {
	            private static final long serialVersionUID = 1L;

	            @Override
	            public boolean isVisible() {
	                return true;
	            	//return artikels.getItems().hasNext();
	            }
	        };

	    add(downloadLink);

	}

}



