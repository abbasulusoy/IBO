package ulusoy.at.wicket.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ulusoy.at.wicket.WicketApplicationWebSession;
import ulusoy.at.wicket.template.Template;

public class HomePage extends Template {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		 add(new Label("userfullname",WicketApplicationWebSession.get().getUserDetails() !=null?WicketApplicationWebSession.get().getUserDetails().getName():"")
	    	{
				private static final long serialVersionUID = 1L;

				@Override
	            public boolean isVisible() {
	                return WicketApplicationWebSession.get().isSignedIn();
	            }
	    	}
	    	);
	    	 add(new Label("role",WicketApplicationWebSession.get().getUserDetails() !=null?WicketApplicationWebSession.get().getUserDetails().getAccount().getRollen().get(0).getName():"role")
	      	{
	  			private static final long serialVersionUID = 1L;

	  			@Override
	              public boolean isVisible() {
	                  return WicketApplicationWebSession.get().isSignedIn();
	              }
	      	});

		add(new ContextImage("image1", "images/armut.jpg"));
		add(new ContextImage("image2", "images/elma.jpg"));
		add(new ContextImage("image3", "images/karpuz.jpg"));
		add(new ContextImage("image4", "images/muz.jpg"));
		add(new ContextImage("image5", "images/image5.jpg"));
		add(new ContextImage("image6", "images/obst.jpg"));

		//Sprach Umstellung in Wicket
		//getSession().setLocale(new Locale("tr"));

    }
}
