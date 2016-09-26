package ulusoy.at.wicket.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.dao.IROLLEDAO;
import ulusoy.at.wicket.entity.Rolle;
import ulusoy.at.wicket.service.IROLLEService;

@Named
public class RollenServiceImpl implements IROLLEService
{
	@Inject
	private IROLLEDAO rolledao;

	@Override
	public void save(Rolle rolle) throws ApplicationException {
		rolledao.save(rolle);
	}

	@Override
	public void deleteWithId(Long id) throws ApplicationException {
		rolledao.delete(id);
	}

	@Override
	public void saveAndFlush(Rolle rolle) throws ApplicationException {
		rolledao.saveAndFlush(rolle);
	}

	@Override
	public void deleteObjekt(Rolle rolle) throws ApplicationException {
		rolledao.delete(rolle);
	}

	@Override
	public Rolle findByName(String name) throws ApplicationException {
		return rolledao.findByName(name);
	}

	@Override
	public List<Rolle> getAllRollen() throws ApplicationException {
		return rolledao.findAll();
	}
	@Override
	public void flush()
	{
		rolledao.flush();
	}



}
