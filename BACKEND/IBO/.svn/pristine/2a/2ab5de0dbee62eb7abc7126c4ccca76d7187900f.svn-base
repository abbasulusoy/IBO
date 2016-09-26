package ulusoy.at.wicket.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;

@Transactional(readOnly = true)
public interface IBestellteArtikelDAO extends JpaRepository<BestellteArtikel, Long> {

	//public List<BestellteArtikel> findByBestellung(Long bestellungId);
	//public List<BestellteArtikel> findAllOrderByBestellung();
	public List<BestellteArtikel> findByBestellung(Bestellung bestellung);

	public List<BestellteArtikel> findByCreated(Date date);

	//oderwww
	@Query("select b from BestellteArtikel b where b.created=?1")
	public List<BestellteArtikel> getBestellungvonDatum(Date date);

	public List<BestellteArtikel> findByCreatedBetween(Date von,Date bis);

	//oder
	@Query("select b from BestellteArtikel b where b.created between ?1 and ?2")
	public Page<BestellteArtikel> getBestelleArtikelZwischen(Date von,Date bis,Pageable pageable);


}
