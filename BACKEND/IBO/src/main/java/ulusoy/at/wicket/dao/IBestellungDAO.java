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
import ulusoy.at.wicket.entity.Kunde;

@Transactional(readOnly = true)
public interface IBestellungDAO extends JpaRepository<Bestellung, Long> {

	@Query("select b from Bestellung b where b.id=?1 and b.mehrwertSteuer=?2")
	List<BestellteArtikel> getProduktByBestellungInZehnProzent(Long id,String mehrwertSteuer);

	Page<Bestellung> findByKunde(Kunde kunde,Pageable pageable);
	List<Bestellung> findByKunde(Kunde kunde);
	Page<Bestellung> findById(Long id,Pageable pageable);
	List<Bestellung> findById(Long id);
	Page<Bestellung> findByMehrwertSteuer(String steuer,Pageable pageable);
	List<Bestellung> findByMehrwertSteuer(String steuer);
	Page<Bestellung> findByCreatedBetween(Date createdVon,Date createdBis,Pageable pageable);
	List<Bestellung> findByCreatedBetween(Date createdVon,Date createdBis);
	Page<Bestellung> findByCreatedBetweenAndKunde(Date createdVon,Date createdBis,Kunde kunde,Pageable pageable);
	Page<Bestellung> findByCreatedBetweenAndKundeAndMehrwertSteuer(Date createdVon,Date createdBis,Kunde kunde,String mehrwertSteuer,Pageable pageable);


}
