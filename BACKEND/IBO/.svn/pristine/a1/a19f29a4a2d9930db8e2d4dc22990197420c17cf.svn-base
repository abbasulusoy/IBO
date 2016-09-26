package ulusoy.at.wicket.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Base extends AbtractBase implements Serializable{
	private static final long serialVersionUID = 1L;


	public Base()
	{
		super();
		setDefaultTimestamps();

	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Version
	private Long version;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy/mm/dd h:mm:ss")
	@Column(columnDefinition="DATE DEFAULT CURRENT_DATE", insertable=false,updatable=false)
	private Date created;
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition="DATE DEFAULT CURRENT_DATE", insertable=true,updatable=true)
	@DateTimeFormat(pattern=" yyyy/mm/dd h:mm:ss ")
	private Date modified;



	protected void setDefaultTimestamps() {
		//setCreated(new Date());
		//setModified(new Date());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public void clear()
	{
		setModified(null);
		setCreated(null);
		setVersion(0);
		setId(null);
	}
	public abstract void clearInternal();





}
