package ulusoy.at.wicket.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ulusoy.at.wicket.entity.Kunde;

@Transactional(readOnly = true)
public interface IKundeDAO extends JpaRepository<Kunde, Long> {

	public List<Kunde> findByKundeName(String name);

	Kunde findByKundeFirmanameOrderByKundeNameAsc(String firmaName);

	Page<Kunde> findByKundeNameStartsWithIgnoreCaseAndKundeNachnameStartsWithIgnoreCaseOrderByKundeNameAsc(String vorname,String nachname,Pageable pageable);

	Page<Kunde> findByKundeNachnameStartsWithIgnoreCaseOrderByKundeNameAsc(String nachname,Pageable pageable);

}
