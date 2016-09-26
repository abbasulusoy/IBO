package ulusoy.at.wicket.component.suche.einkauftliste;
import java.util.Arrays;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import ulusoy.at.wicket.data.BestellSearchDataProvider;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.model.BestellSuche;
import ulusoy.at.wicket.pages.bestellung.EditBestellungPage;
import ulusoy.at.wicket.pages.bestellung.EinkaufsListe;
import ulusoy.at.wicket.template.Template;

public class EinkaufslistSucheErgebnisPage extends Template {


	private static final long serialVersionUID = 1L;
	private final IModel<BestellSuche> bestellSucheModel;

	public EinkaufslistSucheErgebnisPage()
	{
		final Link<Void> newBestellungLink=new Link<Void>("newBestellungLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new EditBestellungPage());

			}

		};
		add(newBestellungLink);

		final Link<Void> bestellungenListeLink=new Link<Void>("bestellungenListeLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new EinkaufslistSucheErgebnisPage());

			}

		};
		add(bestellungenListeLink);

		final Link<Void> einkaufsListeLink=new Link<Void>("einkaufsListeLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new EinkaufsListe());

			}

		};
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



        final DataTable<Bestellung, String> bestellungen= new DataTable<>("bestellungen",
                Arrays.asList(bestellungId,created,kundeFullname,kundefirmaname,mehrwertSteuer), new BestellSearchDataProvider(
                        this.bestellSucheModel), 15);

        bestellungen.setOutputMarkupId(true);

        add(bestellungen);


/**
        add(new EinkaufslisteSearchPanel("bestellungSearchPanel", this.bestellSucheModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onSearchComplete(final AjaxRequestTarget target) {
                target.add(bestellungen);
            }
        });

	*/
	}

	   @Override
	    protected void onDetach() {
	        super.onDetach();
	        this.bestellSucheModel.detach();
	    }

}
