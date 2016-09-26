package ulusoy.at.wicket.entity.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.jpa.repository.JpaRepository;

import ulusoy.at.wicket.dao.IKundeDAO;
import ulusoy.at.wicket.entity.Kunde;

public class KundeModel extends EntityModel<Kunde> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@SpringBean
	private IKundeDAO kundenDao;

	public KundeModel(IModel<Long> kundeModel) {
		super(kundeModel);

	}

	public KundeModel(Kunde kunde)
	{
		super(kunde);
	}

	public KundeModel(Long id)
	{
		super(id);
	}

	@Override
	protected JpaRepository<Kunde, Long> getRepository() {
		return this.kundenDao;
	}



}
