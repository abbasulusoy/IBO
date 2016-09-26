package ulusoy.at.wicket;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ulusoy.at.wicket.pages.HomePage;
import ulusoy.at.wicket.pages.login.LoginPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 * @see ulusoy.at.wicket.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		getApplicationSettings().setPageExpiredErrorPage(getHomePage());

		// add your configuration here
		/*
		switch (getConfigurationType())
		{
			case DEVELOPMENT:
			{
				getRequestLoggerSettings().setRequestLoggerEnabled(true);
				getResourceSettings().setResourcePollFrequency(Duration.ONE_SECOND);
				getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_EXCEPTION_PAGE);
				getResourceSettings().setJavaScriptCompressor(null);
				getMarkupSettings().setStripWicketTags(true);
				getDebugSettings().setComponentUseCheck(true);
				getDebugSettings().setAjaxDebugModeEnabled(true);
				getDebugSettings().setDevelopmentUtilitiesEnabled(true);
				getRequestCycleSettings().addResponseFilter(EmptySrcAttributeCheckFilter.INSTANCE);
				break;

			}

			case DEPLOYMENT:
			{
				getMarkupSettings().setCompressWhitespace(true);
				getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
				getResourceSettings().setJavaScriptCompressor(new DefaultJavaScriptCompressor());
				getMarkupSettings().setStripWicketTags(false);
				getDebugSettings().setAjaxDebugModeEnabled(false);
				getDebugSettings().setComponentUseCheck(false);
				getDebugSettings().setDevelopmentUtilitiesEnabled(false);
				break;
			}

		}
		*/
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {

		return WicketApplicationWebSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {

		return LoginPage.class;
	}

}
