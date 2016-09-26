package ulusoy.at.wicket.entity.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.jpa.repository.JpaRepository;

import ulusoy.at.wicket.dao.IBestellungDAO;
import ulusoy.at.wicket.entity.Bestellung;

public class BestellungModel extends EntityModel<Bestellung> {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private IBestellungDAO bestellungDAO;

	 public BestellungModel(Bestellung bestellung) {
		super(bestellung);
	}


	 public BestellungModel(final Long  id) {
		super(id);
	}

	public BestellungModel(final IModel<Long> bestellungModel) {
		super(bestellungModel);
	}


	@Override
	protected JpaRepository<Bestellung, Long> getRepository() {

		return this.bestellungDAO;
	}


}
