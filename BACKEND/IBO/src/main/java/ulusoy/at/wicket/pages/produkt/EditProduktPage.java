package ulusoy.at.wicket.pages.produkt;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.component.suche.produkt.ProduktSucheListPage;
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.entity.model.ProduktModel;
import ulusoy.at.wicket.service.IProduktService;
import ulusoy.at.wicket.template.Template;

public class EditProduktPage extends Template{

	  private List<String> produktArte = Arrays.asList(new String[] {"OBST", "GEMUESE" });
	  public String selected = "";

	  List<String> choices = new ArrayList<String>();

	  public static final String PARAM_PRODUKT_ID = "produktId";

	private static final long serialVersionUID = 1L;



	@SpringBean
	private IProduktService produktService;

	public EditProduktPage(PageParameters parameters) throws ApplicationException
	{
		final org.apache.wicket.util.string.StringValue produktId = parameters.get(PARAM_PRODUKT_ID);
		final IModel<Produkt> produktModel = produktId.isEmpty() ? Model.of(new Produkt()) : new ProduktModel(
				produktId.toLongObject());
		initPage(produktModel,false);
	}
	public EditProduktPage() throws ApplicationException
	{
		initPage(Model.<Produkt> of(new Produkt()),true);
	}


	public EditProduktPage(final IModel<Produkt> produktModel) throws ApplicationException {
			initPage(produktModel,false);
	}

	private void initPage(final IModel<Produkt> produktModel,boolean newProdukt) throws ApplicationException {
		final Form<Produkt> editProduktForm = new Form<Produkt>("editProduktForm", new CompoundPropertyModel<>(
				produktModel));

		FeedbackPanel feedback=new FeedbackPanel("feedback");
		final RequiredTextField<String> nummer=new RequiredTextField<>("nummer");

		final RequiredTextField<String> name=new RequiredTextField<>("name");
		final TextField<String> preis=new TextField<>("preis");
		//final TextField<String> art=new TextField<>("art");



		final DropDownChoice<Object> land=new DropDownChoice<>("land",new PropertyModel<>(produktModel, "land"),getCountry());
		final DropDownChoice<Object> art=new DropDownChoice<>("art",new PropertyModel<>(produktModel, "art"),produktArte);

		final TextField<String> beschreibung=new TextField<>("beschreibung");
		final TextArea<String> kommentar=new TextArea<>("kommentar");

		Button speichernButton=new Button("speichernButton") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				super.onSubmit();
				try {
					produktService.save(produktModel.getObject());
					setResponsePage(ProduktSucheListPage.class);
					getSession().info("Das Produkt wurde gespeichert");
				} catch (ApplicationException e) {
					getSession().info("Es gibt ein Problem beim Produkt speichern");
					e.printStackTrace();
				}
			}
		};
		Button abbrechenButton=new Button("abbrechenButton") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				setResponsePage(ProduktListPage.class);
			}
		};

				editProduktForm.add(feedback);
				editProduktForm.add(nummer);
				editProduktForm.add(name);
				editProduktForm.add(art);
				editProduktForm.add(land);
				editProduktForm.add(beschreibung);
				editProduktForm.add(kommentar);
				//preis.add(new ValidationStyleBehavior());

				editProduktForm.add(preis);
				editProduktForm.add(speichernButton);
				editProduktForm.add(abbrechenButton);

				add(editProduktForm);
				 if(newProdukt)
				 {
					 CreateAutoCompleteFile();
				 }

	}
	public void CreateAutoCompleteFile() throws ApplicationException
	{
		FileOutputStream fop = null;
		File file;
		StringBuilder sb=new StringBuilder();

		sb.append("var availableProdukte= [");
		int i=0;
		for (Produkt produkt: produktService.getAllProdukte()){
			i++;
			sb.append("\"");
			sb.append(produkt.getName());
			sb.append("\"");
			if(i<produktService.getAllProdukte().size())
			sb.append(",");
		}



		sb.append("];");


		try {

			file = new File("C:/dev/workspace/IBO/src/main/resources/ulusoy/at/wicket/js/avaliableProdukte.js");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = sb.toString().getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> getCountry()
	{
		 Locale[] locales = Locale.getAvailableLocales();

	      for (final Locale locale : locales)
	      {
	          final String country = locale.getDisplayCountry();
	          if(!country.isEmpty())
	          {
	        	  choices.add(country);
	          }
	      }
	      Collections.sort(choices);
	      return choices;
	}


}
