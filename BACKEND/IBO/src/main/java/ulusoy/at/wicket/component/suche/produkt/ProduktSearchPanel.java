package ulusoy.at.wicket.component.suche.produkt;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import ulusoy.at.wicket.entity.model.ProduktSuche;

public class ProduktSearchPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private List<String> produktArte = Arrays.asList(new String[] {"OBST", "GEMUESE" });

	public ProduktSearchPanel(String id,final IModel<ProduktSuche> produktSucheModel) {
		super(id);
		final Form<ProduktSuche> form=new Form<ProduktSuche>("form",new CompoundPropertyModel<>(produktSucheModel));
		form.add(new TextField<String>("name"));
		form.add(new TextField<Double>("preis"));
		form.add(new TextField<Double>("preis2"));
		form.add(new DropDownChoice<>("art",new PropertyModel<>(produktSucheModel, "art"),produktArte));
		form.add(new AjaxButton("sucheProdukt")
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
