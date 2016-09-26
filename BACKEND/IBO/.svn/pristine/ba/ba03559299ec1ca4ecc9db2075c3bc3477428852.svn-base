package ulusoy.at.wicket.entity.model;


import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.jpa.repository.JpaRepository;

import ulusoy.at.wicket.dao.IBestellteArtikelDAO;
import ulusoy.at.wicket.entity.BestellteArtikel;

public class BestellteArtikelModel extends EntityModel<BestellteArtikel>{

	private static final long serialVersionUID = 1L;
	@SpringBean
	IBestellteArtikelDAO bestellteArtikelDAO;

	public BestellteArtikelModel(BestellteArtikel entity) {
		super(entity);

	}

	@Override
	protected JpaRepository<BestellteArtikel, Long> getRepository() {
		return this.bestellteArtikelDAO;
	}


}
