package ulusoy.at.wicket.pages.kunde;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import ulusoy.at.wicket.template.Template;

public class KundenListPage extends Template {
	private static final long serialVersionUID = 1L;
	public static final String PARAM_KUNDE_ID = "kundeId";

	public KundenListPage(final PageParameters parameters) {


        final Link<Void> editKundeLink=new Link<Void>("newKundeLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(EditKundePage.class);
			}

		};
		add(editKundeLink);
		add(new KundenListPanel("dataTablePanel"));
	}
}
