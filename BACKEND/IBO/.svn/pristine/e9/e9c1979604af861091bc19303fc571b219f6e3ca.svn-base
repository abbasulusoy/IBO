package ulusoy.at.wicket;


import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import ulusoy.at.wicket.login.IBOUserDetails;



public class WicketApplicationWebSession extends AuthenticatedWebSession{

	private static final long serialVersionUID = 1L;
	@SpringBean(name = "authenticationManager")
	private AuthenticationManager authenticationManager;

	public WicketApplicationWebSession(final Request request) {
		super(request);
		injectDependencies();
		ensureDependenciesNotNull();

	}

	private void ensureDependenciesNotNull() {
		if (this.authenticationManager == null) {
			throw new IllegalStateException("An authenticationManager is required.");
		}
	}

	private void injectDependencies() {
		Injector.get().inject(this);
	}

	@Override
	public boolean authenticate(final String username, final String password) {
		boolean authenticated = false;
		try {
			final Authentication authentication = this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			authenticated = authentication.isAuthenticated();
		} catch (final AuthenticationException e) {
			// logger.warn(String.format("User '%s' failed to login. Reason: %s",
			// username, e.getMessage()));
			e.printStackTrace();
			authenticated = false;
		}
		return authenticated;
	}

	@Override
	public void signOut() {
		super.signOut();
		SecurityContextHolder.getContext().setAuthentication(null);
	}

	@Override
	public Roles getRoles() {
		final Roles roles = new Roles();
		getRolesIfSignedIn(roles);
		return roles;
	}

	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	private void getRolesIfSignedIn(final Roles roles) {
		if (isSignedIn()) {
			addRolesFromAuthentication(roles, getAuthentication());
		}
	}

	private void addRolesFromAuthentication(final Roles roles, final Authentication authentication) {
		for (final GrantedAuthority authority : authentication.getAuthorities()) {
			roles.add(authority.getAuthority());
		}
	}

	public IBOUserDetails getUserDetails() {
		if (isSignedIn()) {
			try
			{
				final Object principal = getAuthentication().getPrincipal();
				if (IBOUserDetails.class.isAssignableFrom(principal.getClass())) {
					return (IBOUserDetails) getAuthentication().getPrincipal();
				}
			}
			catch (Exception e) {

			}

		}
		return null;
	}

	public static WicketApplicationWebSession get() {
		return (WicketApplicationWebSession) Session.get();
	}



}
