package ulusoy.at.wicket.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Produkt;

@Validated
public interface IProduktService{

	public void save(@Valid  Produkt produkt) throws ApplicationException;
	public void deleteWithId(@NotNull Long id)  throws ApplicationException;
	public void saveAndFlush(@NotNull Produkt produkt) throws ApplicationException;
	public void deleteObjekt(@NotNull Produkt produkt) throws ApplicationException;
	public Produkt searchName(@NotNull String name) throws ApplicationException;
	public List<Produkt> getAllProdukte() throws ApplicationException;
	public Page<Produkt> search(String name,double preis,double preis2,String art,Integer pageNum,Integer pageSize);
}
