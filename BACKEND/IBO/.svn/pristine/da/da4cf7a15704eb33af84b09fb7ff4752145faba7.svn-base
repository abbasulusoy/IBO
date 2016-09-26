package ulusoy.at.wicket.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "rolle")
public class Rolle extends Base implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void clearInternal() {

	}
	private String name;

	@ManyToMany(mappedBy="rollen")
	private List<Account> accounts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isConditional() {
		return conditional;
	}

	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}
	private boolean conditional;



}
