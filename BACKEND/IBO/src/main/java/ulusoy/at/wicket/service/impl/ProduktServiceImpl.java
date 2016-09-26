package ulusoy.at.wicket.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.dao.IProduktDAO;
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.service.IProduktService;

@Named
public class ProduktServiceImpl implements IProduktService{

	@Inject
	private IProduktDAO produktDAO;

	@Override
	public void save(Produkt produkt) throws ApplicationException {
		produktDAO.save(produkt);

	}

	@Override
	public void deleteWithId(Long id) throws ApplicationException {
		produktDAO.delete(id);
	}

	@Override
	public void saveAndFlush(Produkt produkt) throws ApplicationException {
		produktDAO.saveAndFlush(produkt);

	}

	@Override
	public void deleteObjekt(Produkt produkt) throws ApplicationException {
		produktDAO.delete(produkt);

	}

	@Override
	public Produkt searchName(String name) throws ApplicationException {

		return produktDAO.findByNameStartsWithIgnoreCase(name);
	}

	@Override
	public List<Produkt> getAllProdukte() throws ApplicationException {
		return produktDAO.findAll();
	}

	@Override
	public Page<Produkt> search(String name, double preis,double preis2, String art,
			Integer pageNum, Integer pageSize) {

		final PageRequest pr=new PageRequest(pageNum, pageSize,new Sort(Direction.ASC,"name"));
		if(StringUtils.isNotBlank(name))
		{
			final List<Produkt> produktListe=new ArrayList<Produkt>();
			try {
				CollectionUtils.addIgnoreNull(produktListe, searchName(name));
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new PageImpl<Produkt>(produktListe);
		}
		if(StringUtils.isNotBlank(art))
		{
			return this.produktDAO.findByArt(art,pr);
		}
		if(preis !=0 && preis2!=0 &&StringUtils.isBlank(art) && StringUtils.isBlank(name))
		{
			return this.produktDAO.findByPreisBetween(preis, preis2, pr);
		}
		if(preis ==0)
		{
			return this.produktDAO.findAll(pr);
		}
		if(StringUtils.isBlank(art))
		{
			return this.produktDAO.findAll(pr);
		}
		return this.produktDAO.findByNameAndPreisAndArt(name, preis, art,pr);

	}



}
