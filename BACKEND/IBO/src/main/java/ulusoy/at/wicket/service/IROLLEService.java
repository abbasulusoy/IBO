package ulusoy.at.wicket.service;

import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Rolle;

@Validated
public interface IROLLEService{

	public void save(@Valid  Rolle rolle) throws ApplicationException;
	public void deleteWithId(@NotNull Long id)  throws ApplicationException;
	public void saveAndFlush(@NotNull Rolle rolle) throws ApplicationException;
	public void deleteObjekt(@NotNull Rolle  rolle) throws ApplicationException;
	public Rolle findByName(@NotNull String name) throws ApplicationException;
	public List<Rolle> getAllRollen() throws ApplicationException;
	public void flush() throws ApplicationException;
}
