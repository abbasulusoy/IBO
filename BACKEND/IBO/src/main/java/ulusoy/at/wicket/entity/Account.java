package ulusoy.at.wicket.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;






@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Account extends Base implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	@ManyToMany(targetEntity =Rolle.class,fetch = FetchType.EAGER)
	private List<Rolle> rollen=new ArrayList<>();

	private String vorname;
	private String nachname;


	private String passwordWh;

	private Boolean enabled=false;

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
	@Override
	public void clearInternal() {
		setUsername(null);
		setPassword(null);
	}
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getPasswordWh() {
		return passwordWh;
	}
	public void setPasswordWh(String passwordWh) {
		this.passwordWh = passwordWh;
	}
    public List<Rolle> getRollen() {
		return rollen;
	}
	public void setRollen(List<Rolle> rollen) {
		this.rollen = rollen;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	@Transient
	public String getFullname()
	{
		return getVorname()+"" +getNachname();
	}

	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;

	}

}
