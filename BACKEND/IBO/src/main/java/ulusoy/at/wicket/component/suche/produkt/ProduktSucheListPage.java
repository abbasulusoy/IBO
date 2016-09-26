package ulusoy.at.wicket.component.suche.produkt;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import ulusoy.at.wicket.data.ProduktSearchDataProvider;
import ulusoy.at.wicket.data.ProduktSortDataProvider;
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.entity.model.ProduktSuche;
import ulusoy.at.wicket.table.PanelColumn;
import ulusoy.at.wicket.template.Template;

public class ProduktSucheListPage extends Template {


	private static final long serialVersionUID = 1L;
	private final IModel<ProduktSuche> produktSucheModel;
	public ProduktSucheListPage()
	{
		final Link<Void> newProduktLink=new Link<Void>("newProduktLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(ulusoy.at.wicket.pages.produkt.EditProduktPage.class);
			}
		};
		add(newProduktLink);

		FeedbackPanel feedbackPanel=new FeedbackPanel("feedbackPanel");
		add(feedbackPanel);
		this.produktSucheModel=Model.of(new ProduktSuche());

        final PropertyColumn<Produkt, String> name = new PropertyColumn<>(new StringResourceModel(
                "name", null, new Object[0]),"name", "name");
        final PropertyColumn<Produkt, String> preis = new PropertyColumn<>(new StringResourceModel(
                "preis", null, new Object[0]), "preis");
        final PropertyColumn<Produkt, String> art = new PropertyColumn<>(new StringResourceModel(
                "art", null, new Object[0]), "art");
        final PanelColumn<Produkt, String> actionsColumn = new PanelColumn<Produkt, String>(
                Model.of(StringUtils.EMPTY)) {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getComponent(final String componentId, final IModel<Produkt> rowModel) {
                return new EditAbleProduktPropertyColumn(componentId, rowModel);
            }
        };

        final DataTable<Produkt, String> produkte = new DataTable<>("produkte",
                Arrays.asList(name, preis, art,actionsColumn), new ProduktSearchDataProvider(
                        this.produktSucheModel), 15);


        produkte.addTopToolbar(new HeadersToolbar(produkte, new ProduktSortDataProvider()) {
		});

        produkte.setOutputMarkupId(true);

        add(produkte);



        add(new ProduktSearchPanel("produktSearchPanel", this.produktSucheModel) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onSearchComplete(final AjaxRequestTarget target) {
                target.add(produkte);
            }
        });

	}

	   @Override
	    protected void onDetach() {
	        super.onDetach();
	        this.produktSucheModel.detach();
	    }

}
