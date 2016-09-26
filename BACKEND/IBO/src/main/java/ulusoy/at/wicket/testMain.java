package ulusoy.at.wicket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Produkt;

public class testMain {

	public static void main(String[] args) {

		Produkt p1=new Produkt();
		p1.setName("Elma");

		Produkt p2=new Produkt();
		p2.setName("Armut");

		Produkt p3=new Produkt();
		p3.setName("Hiyar");

		List<Produkt> produkte=new ArrayList<>();
		produkte.add(p1);
		produkte.add(p2);
		produkte.add(p3);

		BestellteArtikel bestellteArtikel=new BestellteArtikel();
		bestellteArtikel.setName(p1.getName());
		bestellteArtikel.setMenge(3);


		BestellteArtikel bestellteArtikel1=new BestellteArtikel();
		bestellteArtikel1.setName(p1.getName());
		bestellteArtikel1.setMenge(7);

		BestellteArtikel bestellteArtikel2=new BestellteArtikel();
		bestellteArtikel2.setName(p2.getName());
		bestellteArtikel2.setMenge(5);


		BestellteArtikel bestellteArtikel3=new BestellteArtikel();
		bestellteArtikel3.setName(p2.getName());
		bestellteArtikel3.setMenge(1);

		List<BestellteArtikel> bestellteArtikels=new ArrayList<>();
		bestellteArtikels.add(bestellteArtikel);
		bestellteArtikels.add(bestellteArtikel1);
		bestellteArtikels.add(bestellteArtikel2);
		bestellteArtikels.add(bestellteArtikel3);





       Map<String,Integer> map=  new HashMap<String,Integer>();


       for (BestellteArtikel bestellArtikel : bestellteArtikels) {
    	   if(!map.containsKey(bestellArtikel.getName()))
    	   {
    	   map.put(bestellArtikel.getName(), bestellArtikel.getMenge());
    	   }
    	   else
    	   {
    		   map.put(bestellArtikel.getName(),map.get(bestellArtikel.getName())+bestellArtikel.getMenge());
    	   }
       }


        Iterator<Entry<String,Integer>> iterator= map.entrySet().iterator();
           while(iterator.hasNext())
           {
               Entry<String,Integer> entry =iterator.next();
               System.out.println(" entries= "+entry.getKey() +" entries= "+entry.getValue());
           }



	}
}
