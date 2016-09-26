package ulusoy.at.wicket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class meinKundeEntity {

	@Id
	@GeneratedValue(generator="mySeq")
	@SequenceGenerator(name="mySeq", sequenceName="MY_SEQ",allocationSize=100, initialValue=1)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
