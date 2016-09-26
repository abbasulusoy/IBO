package ulusoy.at.wicket.entity.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.service.IKundeService;



public class AvailableKundeModel extends LoadableDetachableModel<List<Kunde>>{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private IKundeService kundeService;

	public AvailableKundeModel() {
		Injector.get().inject(this);
	}

	@Override
	protected List<Kunde> load() {

		List<Kunde> kundenListe=new ArrayList<Kunde>();

		try {
			kundenListe=kundeService.getAllKunde();

		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kundenListe;
	}







}
