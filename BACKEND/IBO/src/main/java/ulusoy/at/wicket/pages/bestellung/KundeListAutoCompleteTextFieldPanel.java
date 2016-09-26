package ulusoy.at.wicket.pages.bestellung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.service.IKundeService;

public class KundeListAutoCompleteTextFieldPanel extends Panel {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private IKundeService kundeService;

	public KundeListAutoCompleteTextFieldPanel(String id,final IModel<Kunde> kundenModell,final Form<Bestellung> bestellungForm)
	{
		super(id);
		initPage(kundenModell,bestellungForm);
	}
	public void initPage(final IModel<Kunde> kundenModel,final Form<Bestellung> bestellungForm )
	{


		final AutoCompleteTextField<String> name = new AutoCompleteTextField<String>("kundeName",new Model<String>(""))
				{

			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<String> getChoices(String input)
			{
				if (Strings.isEmpty(input))
				{
					return Collections.EMPTY_LIST.iterator();
				}

				List<String> choices = new ArrayList<String>(10);

				List<Kunde> kunden = null;
				try {
					kunden = kundeService.getAllKunde();
				} catch (ApplicationException e) {

					e.printStackTrace();
				}

				for (Kunde kunde: kunden) {


					final String kundeName= kunde.getKundeName();

					if (kundeName.toUpperCase().startsWith(input.toUpperCase()))
					{
						choices.add(kundeName);
						if (choices.size() == 10)
						{
							break;
						}
					}
				}
				return choices.iterator();
			}
				};
				bestellungForm.add(name);

				name.add(new AjaxFormSubmitBehavior(bestellungForm, "onchange")
				{

					private static final long serialVersionUID = 1L;

					protected void onSubmit(AjaxRequestTarget target)
					{

						target.getComponents();
					}

					@Override
					protected void onError(AjaxRequestTarget target)
					{
					}
				});

	}

}
