package ulusoy.at.wicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import ulusoy.at.wicket.entity.Kunde;


public class TestHomePage
{


	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("kunde");

		EntityManager em=emf.createEntityManager();

		Kunde k=new Kunde();
		k.setKundeName("KPC");
		em.persist(k);

		System.out.println("Im Persistenzkontext enthalten" +em.contains(k));
	}
}
