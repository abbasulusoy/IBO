package ulusoy.at.wicket.template;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import ulusoy.at.wicket.panel.KontaktPanel;

public class FooterPanel extends Panel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public FooterPanel(String id) {
		super(id);
		 add(new Label("version", getString("version")));
		 add(new KontaktPanel("kontaktPanel"));
	}

}
