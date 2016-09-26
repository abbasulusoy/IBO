package ulusoy.at.wicket.template;

import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {


	private static final long serialVersionUID = 1L;

	public HeaderPanel(String id) {
		super(id);
		add(new ContextImage("logo", "images/logo.png"));
		add(new NavigationPanel("navigation"));
	}

}
