package ulusoy.at.wicket.pages.bestellung;


import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.data.BestellungDataProvider;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.service.IBestellteArtikelService;
import ulusoy.at.wicket.service.IBestellungService;
import ulusoy.at.wicket.template.Template;

public class BestellungListe extends Template {
	private static final long serialVersionUID = 1L;

	@SpringBean
	IBestellungService bestellungService;

	@SpringBean
	IBestellteArtikelService bestellteArtikelService;

	List<BestellteArtikel> bestellteArtikels=new ArrayList<>();

	public BestellungListe()
	{
		initPage();

	}
	public void initPage()
	{
		final Form<?> bestellungForm = new Form<>("bestellungForm");
		add(bestellungForm);

		final DataView<Bestellung> bestellungen= new DataView<Bestellung>("bestellungen",
				new BestellungDataProvider()) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final Item<Bestellung> item) {
				item.getModelObject().setProdukte(bestellteArtikelService.findByBestellung(item.getModelObject()));
				item.add(new Label("id", new PropertyModel<>(item.getModel(), "id")));
				item.add(new Label("kunde.fullname", new PropertyModel<>(item.getModel(), "kunde.fullName")));
				item.add(new Label("kunde.kundeFirmaname", new PropertyModel<>(item.getModel(), "kunde.kundeFirmaname")));

				item.add(new Label("mehrwertSteuerTotal",new PropertyModel<>(item.getModel(),"mehrwertSteuerTotalMit")));
				item.add(new Label("mehrwertSteuer10",new PropertyModel<>(item.getModel(),"mehrwertSteuer10")));
				item.add(new Label("total",new PropertyModel<>(item.getModel(),"total")));


				item.add(new Label("created",new PropertyModel<>(item.getModel(),"created")));
				item.add(new Link<Produkt>("edit")
						{
							private static final long serialVersionUID = 1L;
							@Override
							public void onClick() {
									setResponsePage(new EditBestellungPage(item.getModel()));
								try {
								} catch (Exception e) {
									error("Es gibt ein Problem beim editieren" +e.getMessage());
								}
							}

						});
				item.add(new Link<Produkt>("delete")
						{
							private static final long serialVersionUID = 1L;
							@Override
							public void onClick() {
									try {
										bestellungService.deleteObjekt(item.getModelObject());
									} catch (ApplicationException e1) {

										e1.printStackTrace();
									}
								try {
								} catch (Exception e) {
									error("Es gibt ein Problem beim editieren" +e.getMessage());
								}
							}

						});
			}


		};
		bestellungForm.add(bestellungen);
	}


}
