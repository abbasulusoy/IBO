package ulusoy.at.wicket.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



import ulusoy.at.wicket.dao.IAccountDAO;
import ulusoy.at.wicket.entity.Account;
import ulusoy.at.wicket.entity.Rolle;
import ulusoy.at.wicket.login.IBOUserDetails;



@Named(value = "loginService")
public class KundeLoginService implements UserDetailsService {

	@Autowired
	private IAccountDAO accountDAO;

	public KundeLoginService ()
	{

	}


	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Account account=new Account();
		account=accountDAO.findByUsername(username);

		if(account==null)
		{
			throw new UsernameNotFoundException("Account" +username + "not found");
		}
		return new IBOUserDetails(account,getAuthoritiesForUser(account)) ;
	}



	public Collection<? extends GrantedAuthority> getAuthoritiesForUser(final Account account) {
		final Set<GrantedAuthority> toRet = new HashSet<GrantedAuthority>();
		if (account !=null) {
			for (final Rolle rolle: account.getRollen()) {
				toRet.add(new SimpleGrantedAuthority(rolle.getName()));
			}
		}
		return toRet;
	}


	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}


	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}




}
