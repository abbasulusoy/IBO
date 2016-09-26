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
import ulusoy.at.wicket.entity.Produkt;
import ulusoy.at.wicket.entity.model.ProduktModel;
import ulusoy.at.wicket.service.IProduktService;

public class ProduktSortDataProvider extends SortableDataProvider<Produkt,String>{

	private static final long serialVersionUID = 1L;
	private List<Produkt> produktListe;
	private String filter;
	public ProduktSortDataProvider()
	{
		Injector.get().inject(this);
		//setSort("name",SortOrder.ASCENDING);
		setSort("art",SortOrder.ASCENDING);
		setSort("preis",SortOrder.ASCENDING);

	}
	@Inject
	private IProduktService produktService;

	@Override
	public long size() {
		fillList();
		return produktListe.size();
	}
	private List<Produkt> getFiltered(){
		if(produktListe!=null)
		{
			produktListe=filter();
		}
		return produktListe;
	}
	private List<Produkt> filter()
	{
		if(this.filter!=null)
		{
			String upper=filter.toUpperCase();
			Iterator<Produkt> it=produktListe.iterator();
			while(it.hasNext())
			{
				Produkt produkt=it.next();
				if(produkt.getName().toUpperCase().indexOf(upper)<0 &&produkt.getArt().toUpperCase().indexOf(upper)<0)
				{
					it.remove();
				}
			}
		}
		return produktListe;
	}
	@Override
	public Iterator<? extends Produkt> iterator(long first, long count) {
		fillList();
		List<Produkt> newList = new ArrayList<Produkt>(produktListe);
	    final int firstInt = Long.valueOf(first).intValue();
        final int countInt = Long.valueOf(count).intValue();

        toCompare(newList);

		return newList.subList(firstInt, firstInt + countInt).iterator();
	}
	private void toCompare(List<Produkt> list)
	{
		Collections.sort(list, new Comparator<Produkt>() {

			int dir=getSort().isAscending() ? 1 : -1;
			@Override
			public int compare(Produkt o1, Produkt o2) {
				if("name".equalsIgnoreCase(getSort().getProperty()))
				{
					return dir * (o1.getArt().compareToIgnoreCase(o2.getArt()));
				}
				if("art".equalsIgnoreCase(getSort().getProperty()))
				{
					return dir * (o1.getArt().compareToIgnoreCase(o2.getArt()));
				}
				else
				{
					return dir * (o1.getPreis().toString().compareToIgnoreCase(o2.getPreis().toString()));
				}

			}

		});
	}

	public void fillList()
	{
		if(produktListe==null)
		{
			produktListe=new ArrayList<>();
		}
		else
		{
			try {
				produktListe=produktService.getAllProdukte();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public IModel<Produkt> model(Produkt object) {

		return new ProduktModel(object);
	}





}
