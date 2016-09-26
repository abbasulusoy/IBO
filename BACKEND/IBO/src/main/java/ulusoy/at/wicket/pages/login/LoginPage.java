package ulusoy.at.wicket.pages.login;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import ulusoy.at.wicket.behavior.RedStartBehavior;
import ulusoy.at.wicket.entity.Account;
import ulusoy.at.wicket.pages.HomePage;
import ulusoy.at.wicket.pages.account.CreateAccountPage;
import ulusoy.at.wicket.template.Template;

public class LoginPage extends Template {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public LoginPage()
	{
		FeedbackPanel feedbackPanel=new FeedbackPanel("feedbackPanel");
		add(feedbackPanel);
		final Form<Account> loginForm=new Form<Account>("loginForm",new CompoundPropertyModel<Account>(new Account()));
		add(loginForm);
		RequiredTextField<String> username=new RequiredTextField<String>("username");
		RequiredTextField<String> password=new RequiredTextField<String>("password");
		loginForm.add(username);
		username.add(new RedStartBehavior());
		password.add(new RedStartBehavior());
		loginForm.add(password);

		Button loginButton=new Button("loginButton")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {

				super.onSubmit();

				String username = loginForm.getModelObject().getUsername();
				String password = loginForm.getModelObject().getPassword();

				AuthenticatedWebSession session = AuthenticatedWebSession.get();
				if (session.signIn(username, password)) {
					setDefaultResponsePageIfNecessary();
				} else {
					error(getString("login.failed.badcredentials"));
				}
			}

			private void setDefaultResponsePageIfNecessary() {
				setResponsePage(HomePage.class);

			}
		};
		loginForm.add(loginButton);

		final Link<Void> neueAnmeldungLink=new Link<Void>("neueAnmeldung") {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(CreateAccountPage.class);

			}

		};
		add(neueAnmeldungLink);


	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
