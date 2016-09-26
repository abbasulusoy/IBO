package ulusoy.at.wicket.pages.bestellung;


import java.util.Iterator;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.service.IBestellteArtikelService;

public class WarenkorbPanel extends Panel {


	Model<BestellteArtikel> bestellteArtikelModel;
	private static final long serialVersionUID = 1L;

	@SpringBean
	IBestellteArtikelService bestellteArtikelService;

	private  Double gesammtSumme=0.0;



	public WarenkorbPanel(String id,IModel<Bestellung> bestellungsModel) {
		super(id);

		initPage(id,bestellungsModel);
	}


	public void initPage(String id,final IModel<Bestellung> bestellungsModel)
	{
		 final Form<?> summeForm = new Form<>("summeForm");
		 final DataView<BestellteArtikel> warenkorb=new DataView<BestellteArtikel>("artikel",
					new  WarenkorbListDataProvider(bestellungsModel)) {
	            private static final long serialVersionUID = 1L;

	            @Override
	            protected void populateItem(final Item<BestellteArtikel> item) {
	            	item.add(new Label("name", new PropertyModel<>(item.getModel(), "name")));

	            	item.add(new Label("preis", new PropertyModel<>(item.getModel(), "neuPreis")));
	                item.add(new Label("menge", new PropertyModel<>(item.getModel(), "menge")));
	                item.add(new Label("art", new PropertyModel<>(item.getModel(), "art")));
	                item.add(new Label("summe", new PropertyModel<>(item.getModel(), "summe")));
	                item.add(new Link<BestellteArtikel>("delete")
	                		{
								private static final long serialVersionUID = 1L;

								@Override
								public void onClick() {
									try {

										bestellteArtikelService.deleteWithId(item.getModelObject().getId());

									} catch (ApplicationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

	                		});
	                item.add(new Link<BestellteArtikel>("edit")
	                		{
								private static final long serialVersionUID = 1L;

								@Override
								public void onClick() {
									try {

										setResponsePage(new EditBestellungPage(bestellungsModel,item.getModel()));
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

	                		});
	            }
	        };

	        summeForm.add(new Button("Rechnen")
	        {

				/**
				 *
				 */
				private static final long serialVersionUID = 1L;
				public void onSubmit() {
					gesammtSumme=0.0;
					Iterator<Item<BestellteArtikel>> aIterator = warenkorb.getItems();
		            while(aIterator.hasNext())
		            {
		            	gesammtSumme+=aIterator.next().getModelObject().getSumme();
		            }
		            if(bestellungsModel.getObject().getMehrwertSteuer()!=null && bestellungsModel.getObject().getMehrwertSteuer().equalsIgnoreCase("10%"))
		            {
		            	gesammtSumme=gesammtSumme +gesammtSumme * 0.1;
		            }
				};

	        }
	        );
	        add(new Label("gesammt",new PropertyModel<>(this, "gesammtSumme")));
	        add(summeForm);



	        add(warenkorb);
	}

}
