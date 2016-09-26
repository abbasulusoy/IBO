package ulusoy.at.wicket.component.suche.kunde;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;


import ulusoy.at.wicket.entity.model.KundenSuche;

public class KundeSearchPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public KundeSearchPanel(String id,final IModel<KundenSuche> kundenSucheModel) {
		super(id);
		final Form<KundenSuche> form=new Form<KundenSuche>("form",new CompoundPropertyModel<>(kundenSucheModel));
		form.add(new TextField<String>("vorname"));
		form.add(new TextField<String>("nachname"));
		form.add(new TextField<String>("firmaname"));
		form.add(new AjaxButton("sucheKunde")
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
