package ulusoy.at.wicket.template;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import ulusoy.at.wicket.component.suche.bestellung.BestellungSucheListPage;
import ulusoy.at.wicket.component.suche.kunde.KundeSucheListPage;
import ulusoy.at.wicket.component.suche.produkt.ProduktSucheListPage;
import ulusoy.at.wicket.pages.HomePage;
import ulusoy.at.wicket.pages.KontaktPage;



public class NavigationPanel extends Panel{


	private static final long serialVersionUID = 1L;

	public NavigationPanel(String id) {
		super(id);



        final Link<Void> bestellungLink=new Link<Void>("bestellungLink") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(BestellungSucheListPage.class);

			}

		};
		add(bestellungLink);

		final Link<Void> kundenLink=new Link<Void>("kundenLink") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				//setResponsePage(KundenListPage.class);
				setResponsePage(KundeSucheListPage.class);
			}

		};
		add(kundenLink);


		final Link<Void> produktLink=new Link<Void>("produktLink") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(ProduktSucheListPage.class);

			}

		};
		add(produktLink);

//		final Link<Void> anmeldenLink=new Link<Void>("anmeldenLink") {
//
//			/**
//			 *
//			 */
//			private static final long serialVersionUID = 1L;
//			@Override
//			public void onClick() {
//				setResponsePage(CreateAccountPage.class);
//
//			}
//
//		};
//		add(anmeldenLink);
		
		final Link<Void> homeLink=new Link<Void>("homeLink") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);

			}

		};

		add(homeLink);
		

		final Link<Void> kontaktLink=new Link<Void>("kontaktLink") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(KontaktPage.class);

			}

		};

		add(kontaktLink);
/**
		final Link<Void> testPageLink=new Link<Void>("testPageLink") {


			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(TestPage.class);

			}

		};
		add(testPageLink);
**/
	}

}
