package ulusoy.at.wicket.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.dao.IAccountDAO;
import ulusoy.at.wicket.entity.Account;
import ulusoy.at.wicket.service.IAccountService;

@Named
public class AccountServiceImpl implements IAccountService
{
	@Inject
	private IAccountDAO accountDAO;

	@Override
	public void save(Account account) throws ApplicationException {
		accountDAO.save(account);

	}

	@Override
	public void deleteWithId(Long id) throws ApplicationException {
		accountDAO.delete(id);

	}

	@Override
	public void saveAndFlush(Account account) throws ApplicationException {
		accountDAO.saveAndFlush(account);
	}

	@Override
	public void deleteObjekt(Account account) throws ApplicationException {
	 accountDAO.delete(account);
	}

	@Override
	public Account findByUsername(String name) throws ApplicationException {
		Account account=null;
		if(name !=null)
		{
			account=accountDAO.findByUsername(name);
		}
		return account;
	}

	@Override
	public List<Account> getAllAccounts() throws ApplicationException {

		return accountDAO.findAll();
	}


}
