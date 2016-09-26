package ulusoy.at.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.request.Response;



import ulusoy.at.wicket.entity.Base;

public class RedStartBehavior extends Behavior {

	/**
	 * Input Field with red start
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterRender(Component component) {
		@SuppressWarnings("unchecked")
		FormComponent<? extends Base> fc=(FormComponent<? extends Base>) component;

		if(!fc.isValid())
		{
			Response response=component.getResponse();
			response.write("<span style='color:red'>*</span>");

		}
		super.afterRender(component);
	}


}
