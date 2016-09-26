package ulusoy.at.wicket.service;

import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;




import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Account;

@Validated
public interface IAccountService{



	public void save(@Valid  Account account) throws ApplicationException;
	public void deleteWithId(@NotNull Long id)  throws ApplicationException;
	public void saveAndFlush(@NotNull Account account) throws ApplicationException;
	public void deleteObjekt(@NotNull Account account) throws ApplicationException;
	public Account findByUsername(@NotNull String name) throws ApplicationException;
	public List<Account> getAllAccounts() throws ApplicationException;
}
