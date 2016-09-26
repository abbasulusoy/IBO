package ulusoy.at.wicket.entity.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.jpa.repository.JpaRepository;

import ulusoy.at.wicket.dao.IAccountDAO;
import ulusoy.at.wicket.entity.Account;

public class AccountModel extends EntityModel<Account> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@SpringBean
	private IAccountDAO accountDAO;

	public AccountModel(IModel<Long> accountModel) {
		super(accountModel);

	}

	public AccountModel(Account  account)
	{
		super(account);
	}

	public AccountModel(Long id)
	{
		super(id);
	}

	@Override
	protected JpaRepository<Account, Long> getRepository() {
		return this.accountDAO;
	}



}
