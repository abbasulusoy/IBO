package ulusoy.at.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;


class ValidationStyleBehavior extends Behavior {

	private static final long serialVersionUID = 1L;

	public void onComponentTag(final Component component,
			final ComponentTag tag) {
			FormComponent comp = (FormComponent) component;
		if (comp.isValid() && comp.getConvertedInput() != null) {
			tag.getAttributes().put("class", "valid");
		} else if (!comp.isValid()) {
			tag.getAttributes().put("class", "invalid");
		}
	}
};


