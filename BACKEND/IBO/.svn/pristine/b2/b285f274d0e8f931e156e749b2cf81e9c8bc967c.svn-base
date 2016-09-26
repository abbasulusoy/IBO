package ulusoy.at.wicket.test;

import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

import ulusoy.at.wicket.behavior.RedStartBehavior;
import ulusoy.at.wicket.entity.Account;
import ulusoy.at.wicket.template.Template;


public class TestPage extends Template{

	private static final long serialVersionUID = 1L;

	private TextField<String> username;
    private TextField<String> password;
    private TextField<String> passwordWh;
    private Form<Account> accountForm;
    private CheckBox enabled;

	public TestPage()
	{
		FeedbackPanel feeedback=new FeedbackPanel("feedback");
		add(feeedback);

		IModel<Account> model;
        model=Model.<Account> of(new Account());
        accountForm=new Form<Account>("accountForm",new CompoundPropertyModel<Account>(model));
        enabled=new CheckBox("enabled")
        {

			private static final long serialVersionUID = 1L;
			protected boolean wantOnSelectionChangedNotifications() {
      		  return true;
      	  };
      	  public void onSelectionChanged() {
      		  updateValidation();
      	  }


        }
        ;
        username=new TextField<String>("username");
        password=new TextField<String>("password");
        passwordWh=new TextField<String>("passwordWh");

        updateValidation();

        accountForm.visitChildren(FormComponent.class,new IVisitor<FormComponent<Account>, Account>() {

			@Override
			public void component(FormComponent<Account> component, IVisit<Account> visit) {
				component.add(new RedStartBehavior());
			}

		});

        accountForm.add(enabled);
        accountForm.add(username);
        //username.add(new RedStartBehavior());
        accountForm.add(password);
        //password.add(new RedStartBehavior());
        accountForm.add(passwordWh);
        //passwordWh.add(new RedStartBehavior());

        add(accountForm);

	}

	private void updateValidation() {
		Boolean required=accountForm.getModelObject().isEnabled();
		username.setRequired(required);
		password.setRequired(required);
		passwordWh.setRequired(required);
	};




}
