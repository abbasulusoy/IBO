package ulusoy.at.wicket.pages.bestellung;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.component.ArtikelArtDropDownChoice;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.service.IBestellteArtikelService;
import ulusoy.at.wicket.service.IProduktService;

public class BestellteArtikelPanel extends Panel {


	@SpringBean
	private IProduktService produktService;

	@SpringBean
	private IBestellteArtikelService bestellteArtikelService;

	IModel<BestellteArtikel> bestellteArtikelModel;
	private static final long serialVersionUID = 1L;



	public BestellteArtikelPanel(String id,final IModel<Bestellung> bestellungModel)
	{
		super(id);
		this.bestellteArtikelModel=Model.of(new BestellteArtikel());
		initPage(bestellungModel,bestellteArtikelModel);
	}
	public BestellteArtikelPanel(String id,final IModel<Bestellung> bestellungModel,final IModel<BestellteArtikel> bestellteArtikelModel)
	{
		super(id);
		this.bestellteArtikelModel=bestellteArtikelModel;
		initPage(bestellungModel, this.bestellteArtikelModel);

	}

	public void initPage(final IModel<Bestellung> bestellungModel,final IModel<BestellteArtikel> bestellteArtikelModel)
	{



		final FeedbackPanel feedbackPanel=new FeedbackPanel("feeddbackPanel");
		final Form<BestellteArtikel> bestellteArtikelForm = new Form<>("bestellteArtikelForm", new CompoundPropertyModel<>(
				bestellteArtikelModel)
				);
		add(bestellteArtikelForm);





		RequiredTextField<?> name=new RequiredTextField<>("name",new PropertyModel<>(this.bestellteArtikelModel, "name"));

				RequiredTextField<?> preis=new RequiredTextField<>("preis",new PropertyModel<>(this.bestellteArtikelModel, "neuPreis"));
				RequiredTextField<?> menge=new RequiredTextField<>("menge",new PropertyModel<>(this.bestellteArtikelModel, "menge"));
				ArtikelArtDropDownChoice art=new ArtikelArtDropDownChoice("art");

				bestellteArtikelForm.add(art);
				bestellteArtikelForm.add(name);
				add(feedbackPanel);
				bestellteArtikelForm.add(preis);
				bestellteArtikelForm.add(menge);

				bestellteArtikelForm.add(new Button("speichern")
				{
					private static final long serialVersionUID = 1L;
					@Override
					public void onSubmit() {

						try {

							bestellteArtikelModel.getObject().setBestellung(bestellungModel.getObject());
							bestellteArtikelService.save(bestellteArtikelModel.getObject());

						} catch (Exception e) {
							e.printStackTrace();
						}
						BestellteArtikelPanel.this.bestellteArtikelModel.setObject(new BestellteArtikel());
					}
				});


	}
}
