package ulusoy.at.wicket.component.suche.bestellung;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import ulusoy.at.wicket.data.BestellSearchDataProvider;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.model.BestellSuche;
import ulusoy.at.wicket.pages.bestellung.EditBestellungPage;
import ulusoy.at.wicket.pages.bestellung.EinkaufsListeSuche;
import ulusoy.at.wicket.table.PanelColumn;
import ulusoy.at.wicket.template.Template;

public class BestellungSucheListPage extends Template {


	private static final long serialVersionUID = 1L;
	private final IModel<BestellSuche> bestellSucheModel;

	public BestellungSucheListPage()
	{
		add(new ContextImage("space", "images/search_button.png"));
		final Link<Void> newBestellungLink=new Link<Void>("newBestellungLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new EditBestellungPage());

			}

		};
		newBestellungLink.add(new ContextImage("bestellungImage", "images/bestellung.jpg"));

		add(newBestellungLink);


		final Link<Void> einkaufsListeLink=new Link<Void>("einkaufsListeLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new EinkaufsListeSuche());

			}

		};
		einkaufsListeLink.add(new ContextImage("einkaufsImage", "images/einkaufsliste.jpg"));
		add(einkaufsListeLink);

		FeedbackPanel feedbackPanel=new FeedbackPanel("feedbackPanel");
		add(feedbackPanel);
		this.bestellSucheModel=Model.of(new BestellSuche());

		final PropertyColumn<Bestellung, String> created = new PropertyColumn<>(new StringResourceModel(
                "created", null, new Object[0]), "created");
		final PropertyColumn<Bestellung, String> bestellungId = new PropertyColumn<>(new StringResourceModel(
                "id", null, new Object[0]), "id");
        final PropertyColumn<Bestellung, String> kundeFullname = new PropertyColumn<>(new StringResourceModel(
                "kunde.fullname", null, new Object[0]), "kunde.fullName");
        final PropertyColumn<Bestellung, String> kundefirmaname = new PropertyColumn<>(new StringResourceModel(
                "kunde.kundeFirmaname", null, new Object[0]), "kunde.kundeFirmaname");

        final PropertyColumn<Bestellung, String> mehrwertSteuer = new PropertyColumn<>(new StringResourceModel(
                "mehrwertSteuer", null, new Object[0]), "mehrwertSteuer");

        final PanelColumn<Bestellung, String> actionsColumn = new PanelColumn<Bestellung, String>(
                Model.of(StringUtils.EMPTY)) {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getComponent(final String componentId, final IModel<Bestellung> rowModel) {
                return new EditAbleBestellungPropertyColumn(componentId, rowModel);
            }
        };

        final DataTable<Bestellung, String> bestellungen= new DataTable<>("allebestellungen",
                Arrays.asList(bestellungId,created,kundeFullname,kundefirmaname,mehrwertSteuer,actionsColumn), new BestellSearchDataProvider(
                        this.bestellSucheModel), 50);

        bestellungen.setOutputMarkupId(true);

        add(bestellungen);



        add(new BestellungSearchPanel("bestellungSearchPanel", this.bestellSucheModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onSearchComplete(final AjaxRequestTarget target) {
                target.add(bestellungen);
            }
        });

	}

	   @Override
	    protected void onDetach() {
	        super.onDetach();
	        this.bestellSucheModel.detach();
	    }
}
