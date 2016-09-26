package ulusoy.at.wicket.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;




import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Kunde;

@Validated
public interface IKundeService{

	public void save(@Valid  Kunde kunde) throws ApplicationException;
	public void deleteWithId(@NotNull Long id)  throws ApplicationException;
	public void saveAndFlush(@NotNull Kunde kunde) throws ApplicationException;
	public void deleteObjekt(@NotNull Kunde kunde) throws ApplicationException;
	public List<Kunde> searchName(@NotNull String name) throws ApplicationException;
	public List<Kunde> getAllKunde() throws ApplicationException;
	public Kunde findById(Long id);
	public Kunde findByKundeFirmaname(String firmaName);
	public Page<Kunde> search(String firmaname,String vorname,String nachname,Integer pageNum,Integer pageSize);

}
