package ulusoy.at.wicket.pages.produkt;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.data.ProduktDataProvider;
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.service.IProduktService;
import ulusoy.at.wicket.template.Template;
public class ProduktListPage extends Template{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@SpringBean
	private IProduktService produktService;

	public ProduktListPage() {


		final Link<Void> newProduktLink=new Link<Void>("newProduktLink") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(EditProduktPage.class);
			}

		};
		add(newProduktLink);
		initPage();
	}
	public void initPage()
	{
		final Form<?> produktForm = new Form<>("produktForm");
		add(produktForm);

		final DataView<Produkt> produkte= new DataView<Produkt>("produkte",
				new ProduktDataProvider()) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final Item<Produkt> item) {
				item.add(new Label("nummer", new PropertyModel<>(item.getModel(), "nummer")));
				item.add(new Label("name", new PropertyModel<>(item.getModel(), "name")));
				item.add(new Label("beschreibung", new PropertyModel<>(item.getModel(), "beschreibung")));
				item.add(new Label("art", new PropertyModel<>(item.getModel(), "art")));
				item.add(new Label("kommentar", new PropertyModel<>(item.getModel(), "kommentar")));
				item.add(new Label("land", new PropertyModel<>(item.getModel(), "land")));
				item.add(new Label("preis", new PropertyModel<>(item.getModel(), "preis")));
				item.add(new Link<Produkt>("delete")
						{
							private static final long serialVersionUID = 1L;
							@Override
							public void onClick() {
								try {
									produktService.deleteObjekt(item.getModelObject());
									info("Das Produkt wurde geloscht");
								} catch (ApplicationException e) {
									error("Es gibt ein Problem beim loeschen" + e .getMessage());
								}
							}
						});
				item.add(new Link<Produkt>("edit")
						{
							private static final long serialVersionUID = 1L;
							@Override
							public void onClick() {
									try {
										setResponsePage(new EditProduktPage(item.getModel()));
									} catch (ApplicationException e1) {
										// TODO Auto-generated catch block
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
		produktForm.add(produkte);
	}

}
