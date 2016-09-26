package ulusoy.at.wicket.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ulusoy.at.wicket.entity.Rolle;

@Transactional(readOnly = true)
public interface IROLLEDAO extends JpaRepository<Rolle, Long> {

	public Rolle findByName(String name);

}
