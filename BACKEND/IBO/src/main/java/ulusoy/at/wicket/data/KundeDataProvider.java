package ulusoy.at.wicket.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;

import ulusoy.at.wicket.ApplicationException;
import ulusoy.at.wicket.entity.Kunde;
import ulusoy.at.wicket.entity.model.KundeModel;
import ulusoy.at.wicket.service.IKundeService;

public class KundeDataProvider extends SortableDataProvider<Kunde,String>{

	private static final long serialVersionUID = 1L;
	private List<Kunde> kundenListe;
	private String filter;
	public KundeDataProvider()
	{
		Injector.get().inject(this);
		setSort("kundeName",SortOrder.ASCENDING);
		setSort("kundeEmail",SortOrder.ASCENDING);
		setSort("kundeNachname",SortOrder.ASCENDING);

	}
	@Inject
	private IKundeService kundeService;

	@Override
	public long size() {
		fillList();
		return kundenListe.size();
	}
	private List<Kunde> getFiltered(){
		if(kundenListe!=null)
		{
			kundenListe=filter();
		}
		return kundenListe;
	}
	private List<Kunde> filter()
	{
		if(this.filter!=null)
		{
			String upper=filter.toUpperCase();
			Iterator<Kunde> it=kundenListe.iterator();
			while(it.hasNext())
			{
				Kunde kunde=it.next();
				if(kunde.getKundeName().toUpperCase().indexOf(upper)<0 &&kunde.getKundeEmailadresse().toUpperCase().indexOf(upper)<0)
				{
					it.remove();
				}
			}
		}
		return kundenListe;
	}
	@Override
	public Iterator<? extends Kunde> iterator(long first, long count) {
		fillList();
		List<Kunde> newList = new ArrayList<Kunde>(kundenListe);
	    final int firstInt = Long.valueOf(first).intValue();
        final int countInt = Long.valueOf(count).intValue();

        toCompare(newList);

		return newList.subList(firstInt, firstInt + countInt).iterator();
	}
	private void toCompare(List<Kunde> list)
	{
		Collections.sort(list, new Comparator<Kunde>() {

			int dir=getSort().isAscending() ? 1 : -1;
			@Override
			public int compare(Kunde o1, Kunde o2) {
				if("kundeName".equalsIgnoreCase(getSort().getProperty()))
				{
					return dir * (o1.getKundeName().compareToIgnoreCase(o2.getKundeName()));
				}
				if("kundeNachname".equalsIgnoreCase(getSort().getProperty()))
				{
					return dir * (o1.getKundeNachname().compareToIgnoreCase(o2.getKundeNachname()));
				}
				else
				{
					return dir * (o1.getKundeEmailadresse().compareToIgnoreCase(o2.getKundeEmailadresse()));
				}

			}

		});
	}

	public void fillList()
	{
		if(kundenListe==null)
		{
			kundenListe=new ArrayList<>();
		}
		else
		{
			try {
				kundenListe=kundeService.getAllKunde();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public IModel<Kunde> model(Kunde object) {

		return new KundeModel(object);
	}





}
