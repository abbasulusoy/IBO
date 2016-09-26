package ulusoy.at.wicket.pages.bestellung;

import org.apache.wicket.markup.html.link.Link;
import ulusoy.at.wicket.template.Template;

public class BestellungPage extends Template {
	private static final long serialVersionUID = 1L;



	public BestellungPage()
	{
		initPage();

	}
	public void initPage()
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
				setResponsePage(new BestellungListe());

			}

		};
		add(bestellungenListeLink);

		final Link<Void> einkaufsListeLink=new Link<Void>("einkaufsListeLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new EinkaufsListeSuche());

			}

		};
		add(einkaufsListeLink);
	}
}
