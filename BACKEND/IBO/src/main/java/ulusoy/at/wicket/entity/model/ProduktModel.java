package ulusoy.at.wicket.entity.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.jpa.repository.JpaRepository;

import ulusoy.at.wicket.dao.IProduktDAO;
import ulusoy.at.wicket.entity.Produkt;

public class ProduktModel extends EntityModel<Produkt> {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private IProduktDAO produktDAO;

	 public ProduktModel(Produkt produkt) {
		super(produkt);
	}


	 public ProduktModel(final Long  id) {
		super(id);
	}

	public ProduktModel(final IModel<Long> produktModel) {
		super(produktModel);
	}


	@Override
	protected JpaRepository<Produkt, Long> getRepository() {

		return this.produktDAO;
	}


}
