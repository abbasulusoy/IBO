package ulusoy.at.wicket.pages.account;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.wicket.Localizer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;

import com.googlecode.wicket.jquery.ui.form.button.Button;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Account;
import ulusoy.at.wicket.entity.Rolle;
import ulusoy.at.wicket.pages.HomePage;
import ulusoy.at.wicket.service.IAccountService;
import ulusoy.at.wicket.service.IROLLEService;
import ulusoy.at.wicket.template.Template;


public class CreateAccountPage extends Template{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private IAccountService accountService;

	@SpringBean
	private IROLLEService rollenService;


	private List<Rolle> rollenType=new ArrayList<>();
	final Form<Account> accountForm;
	

	public CreateAccountPage() throws ApplicationException
	{
		 accountForm=new Form<Account>("accountForm",new CompoundPropertyModel<>(new Account()));

		add(new FeedbackPanel("feedback"));

		RequiredTextField<String> username=new RequiredTextField<>("username");
		username.add(new StringValidator(5, 10));
		RequiredTextField<String> password=new RequiredTextField<>("password");
		RequiredTextField<String> passwordWh=new RequiredTextField<>("passwordWh");

		  final CheckBoxMultipleChoice<Rolle> rollenTypes = new CheckBoxMultipleChoice<Rolle>("rollen",
	                new PropertyModel<List<Rolle>>(accountForm.getModelObject(), "rollen"),  getRollen(),
	                new IChoiceRenderer<Rolle>() {

	                    private static final long serialVersionUID = 1L;

	                    @Override
	                    public Object getDisplayValue(final Rolle object) {
	                        return Localizer.get().getString("rollen.name."+object.getName(), CreateAccountPage.this);
	                    }

	                    @Override
	                    public String getIdValue(final Rolle object, final int index) {
	                        return object.getName();
	                    }

	                });
		  rollenTypes.add(new AjaxFormChoiceComponentUpdatingBehavior() {
	            private static final long serialVersionUID = 1L;

	            @Override
	            protected void onUpdate(final AjaxRequestTarget target) {

	            }

	        });
	    add(rollenTypes);

		accountForm.add(username);
		accountForm.add(password);
		accountForm.add(passwordWh);
		accountForm.add(rollenTypes);

		accountForm.add(new Button("speichern")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				try {
					accountForm.getModelObject().setEnabled(true);
					accountService.saveAndFlush(accountForm.getModelObject());
					info("ein Account wurde mit der Username "+accountForm.getModelObject().getUsername() +"angelegt");

				} catch (ApplicationException e) {
					error("Es ist ein Problem getreten um ein Account anzulegen");
					e.printStackTrace();
				}
			}
		});
		accountForm.add(new Button("abbrechen")
		{
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				super.onSubmit();
				setResponsePage(HomePage.class);
			}
		});

		accountForm.add(new EqualPasswordInputValidator(password,passwordWh));
		add(accountForm);


	}
	public List<Rolle> getRollen() throws ApplicationException {
		List<Rolle> rollenList=rollenService.getAllRollen();
		for(Rolle r:rollenList)
		{
			rollenType.add(r);
		}
		return rollenType;
	}
	public List<String> createListRollenName() throws ApplicationException
	{
		List<String> listOfRollenNamen=new ArrayList<String>();
		for(Rolle r:getRollen())
		{
			listOfRollenNamen.add(r.getName());

		}
		Collections.sort(listOfRollenNamen,new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2) {

				return o1.compareTo(o2);
			}

		}
		);
		return listOfRollenNamen;
	}
	public List<Rolle> getRollenType() {
		return rollenType;
	}
	public void setRollenType(List<Rolle> rollenType) {
		this.rollenType = rollenType;
	}


}
