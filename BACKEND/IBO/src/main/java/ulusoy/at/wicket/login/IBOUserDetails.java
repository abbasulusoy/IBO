package ulusoy.at.wicket.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ulusoy.at.wicket.entity.Account;

public class IBOUserDetails extends User {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final String name;
	private final Account account;

	public IBOUserDetails(final Account account,
			Collection<? extends GrantedAuthority> authorities) {
		super(account.getUsername(), account.getPassword(),true, true, true,
				true, authorities);
		this.name=account.getFullname();
		this.account=account;
	}
	public Account getAccount()
	{
		return this.account;
	}

	public String getName() {
		return this.name;
	}
}

