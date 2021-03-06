package ulusoy.at.wicket.template;

import java.io.Serializable;

import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptContentHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import ulusoy.at.wicket.css.CSS;
import ulusoy.at.wicket.js.JS;

public class Template  extends WebPage implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Template()
	{

		add(new HeaderPanel("header"));
		add(new FooterPanel("footer"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {

//		response.render(CssContentHeaderItem.forReference(new CssResourceReference(CSS.class, CSS.STYLE)));
		response.render(CssContentHeaderItem.forReference(new CssResourceReference(CSS.class, CSS.BOOTSTRAP_CSS)));
		response.render(CssContentHeaderItem.forReference(new CssResourceReference(CSS.class, CSS.jqueryUIAutoComplete)));

		response.render(JavaScriptContentHeaderItem.forReference(new JavaScriptResourceReference(JS.class,JS.produkte)));
		response.render(JavaScriptContentHeaderItem.forReference(new JavaScriptResourceReference(JS.class,JS.myjquery)));
		response.render(JavaScriptContentHeaderItem.forReference(new JavaScriptResourceReference(JS.class,JS.jquery_1_10_1)));
		response.render(JavaScriptContentHeaderItem.forReference(new JavaScriptResourceReference(JS.class,JS.BOOTSTRAP_JS)));
		response.render(JavaScriptContentHeaderItem.forReference(new JavaScriptResourceReference(JS.class,JS.jqueryUIJS)));
		response.render(JavaScriptContentHeaderItem.forReference(new JavaScriptResourceReference(JS.class,JS.slides)));


	}
}
