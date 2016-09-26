package ulusoy.at.wicket.component.suche.bestellung;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.googlecode.wicket.jquery.ui.form.RadioChoice;

import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.entity.model.AvailableKundeModel;
import ulusoy.at.wicket.entity.model.BestellSuche;

public class BestellungSearchPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private List<String> steuerArt = Arrays.asList(new String[] {"10%", "keine" });

	public BestellungSearchPanel(String id,final IModel<BestellSuche> bestellSucheModel) {
		super(id);

		final Form<BestellSuche> form=new Form<BestellSuche>("form",new CompoundPropertyModel<>(bestellSucheModel));
		form.add(new TextField<>("id"));
		final DropDownChoice<Kunde> kundeChoice = new DropDownChoice<Kunde>("kundenAuswahl", new PropertyModel<Kunde>(bestellSucheModel,"kunde"), new AvailableKundeModel(), new IChoiceRenderer<Kunde>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object getDisplayValue(final Kunde object) {
                return object.getFullName() + " Firma: "+object.getKundeFirmaname();
            };

            @Override
            public String getIdValue(Kunde object, int index) {

            	return object.getId()+"";
            }
        });
		form.add(kundeChoice);
		DateField createdVon=new DateField("createdVon",new PropertyModel<Date>(bestellSucheModel, "createdVon"));
		DateField createdBis=new DateField("createdBis",new PropertyModel<Date>(bestellSucheModel, "createdBis"));
		form.add(new RadioChoice<String>("mehrwertSteuer",new PropertyModel<String>(bestellSucheModel, "mehrwertSteuer"),steuerArt));

		form.add(createdVon);
		form.add(createdBis);

		form.add(new AjaxButton("sucheBestellung")
		{
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				onSearchComplete(target);
			}

		});
		add(form);
	}
	public void onSearchComplete(final AjaxRequestTarget target)
	{

	}

}
