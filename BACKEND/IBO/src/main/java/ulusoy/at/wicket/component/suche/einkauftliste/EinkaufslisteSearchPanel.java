package ulusoy.at.wicket.component.suche.einkauftliste;



import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.yui.calendar.DateField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import ulusoy.at.wicket.entity.model.EinkaufListeModel;

public class EinkaufslisteSearchPanel extends Panel {

	private static final long serialVersionUID = 1L;
	public EinkaufslisteSearchPanel(String id,final IModel<EinkaufListeModel> einkaufListeModel) {
		super(id);

		final Form<EinkaufListeModel> form=new Form<EinkaufListeModel>("form",new CompoundPropertyModel<>(einkaufListeModel));


		DateField createdVon=new DateField("createdVon",new PropertyModel<Date>(einkaufListeModel, "createdVon"));
		DateField createdBis=new DateField("createdBis",new PropertyModel<Date>(einkaufListeModel, "createdBis"));
		form.add(createdVon);
		form.add(createdBis);

		form.add(new AjaxButton("sucheEinkaufsliste")
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
