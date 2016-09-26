package ulusoy.at.wicket.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ulusoy.at.wicket.entity.Produkt;

@Transactional(readOnly = true)
public interface IProduktDAO extends JpaRepository<Produkt, Long> {

	public Produkt findByNameStartsWithIgnoreCase(String name);

	//where p.preis  < preis
	public Page<Produkt> findByPreisLessThan(Double preis,Pageable pageable);
	//where p.preis > preis
	public Page<Produkt> findByPreisGreaterThan(Double preis,Pageable pageable);
	//where p.preis between 1? and ?2
	public Page<Produkt> findByPreisBetween(double preis,double preis2,Pageable pageable);
	//where p.name like ?1
	public Page<Produkt> findByNameLike(String name,Pageable pageable);
	//where p.name ?1 and p.preis ?2 and p.art ?3
	public Page<Produkt> findByNameAndPreisAndArt(String Name,double Preis,String art,Pageable pageable);
	//where p.name ?1 or p.preis ?2 or p.art ?3
	public Page<Produkt> findByNameOrPreisOrArt(String Name,double Preis,String art,Pageable pageable);
	//where p.name <> ?1
	public Page<Produkt> findByNameNot(String name,Pageable pageable);
	//where p.name is null
	public Page<Produkt> findByNameIsNull(Pageable pageable);
	//where p.name is not null
	public Page<Produkt> findByNameIsNotNull(Pageable pageable);

	public Page<Produkt> findByArt(String art,Pageable pageable);

	 //http://static.springsource.org/spring-data/jpa/docs/1.0.0.M1/reference/html/
}
