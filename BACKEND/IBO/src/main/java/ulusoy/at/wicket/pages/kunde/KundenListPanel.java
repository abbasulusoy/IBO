package ulusoy.at.wicket.pages.kunde;

import java.util.ArrayList;
import java.util.List;



import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


import ulusoy.at.wicket.data.KundeDataProvider;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.pages.bestellung.ArtikelListActionColumnPanel;

import ulusoy.at.wicket.table.PanelColumn;




public class KundenListPanel extends Panel {

	private static final long serialVersionUID = 1L;


    KundeDataProvider kundeDataProvider;

    private IModel<Kunde> newKundeModel;

	public KundenListPanel(String id) {
		super(id);

		final KundeDataProvider kundeDataProvider=new KundeDataProvider();
		List<IColumn<Kunde,String>> columns=new ArrayList<IColumn<Kunde,String>>();
		columns.add(new TextFilteredPropertyColumn<Kunde,String,String>(Model.of("Name"),"kundeName","kundeName"));
		columns.add(new TextFilteredPropertyColumn<Kunde,String, String>(Model.of("Email"), "kundeEmailadresse","kundeEmailadresse"));
		columns.add(new TextFilteredPropertyColumn<Kunde,String, String>(Model.of("Nachname"),"kundeNachname","kundeNachname"));
		columns.add(new PropertyColumn<Kunde, String>(Model.of("Telefon"),"kundeTelnummer"));
		columns.add(new PanelColumn<Kunde,String>(Model.of(StringUtils.EMPTY))
		{
			private static final long serialVersionUID = 1L;
			@Override
			public Component getComponent(String componentId, final IModel<Kunde> rowModel) {
				return new ArtikelListActionColumnPanel(componentId,rowModel,KundenListPanel.this.newKundeModel) {

					private static final long serialVersionUID = 1L;
					@Override
					public boolean isVisible() {
						return editOK();

					};
				};


			};
		}

        );

		DefaultDataTable<Kunde,String>  dataTable = new DefaultDataTable<Kunde,String>("dataTable",columns,kundeDataProvider,10);
		
		add(dataTable);
		}

	private boolean editOK()
	{
		return true;
	}

}
