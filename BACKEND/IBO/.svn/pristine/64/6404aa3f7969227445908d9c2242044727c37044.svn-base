package ulusoy.at.wicket.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ulusoy.at.wicket.entity.Account;

@Transactional(readOnly = true)
public interface IAccountDAO extends JpaRepository<Account, Long> {

	public Account findByUsername(String username);

}
