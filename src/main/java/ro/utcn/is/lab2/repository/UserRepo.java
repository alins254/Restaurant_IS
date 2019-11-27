package ro.utcn.is.lab2.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ro.utcn.is.lab2.entity.User;

public class UserRepo {

	/**
	 * Cream un entity manager factory cu denumirea <persistence-unit> din persistence.xml (--> a se vedea randul 6).
	 */
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.IS"); 
	
    
	public void insert(User user) {
		/**
		 * Pentru fiecare metoda se instantiaza un entiy manager din EMF-ul de mai sus.
		 */
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		/**
		 * Denota ca ca incepe o operatie pe baza de date
		 */
		entityManager.getTransaction().begin();
		/**
		 * Declaram operatia sau operatiile ce se vor face pe BD.
		 */
		entityManager.merge(user);
		/**
		 * Executam operatia.
		 */
		entityManager.getTransaction().commit();
		/**
		 * Inchidem EM-ul. Ca la operatii pe fisiere, il deschizi, il citesti si in final il inchizi.
		 */
		entityManager.close();
	}
	
	public User findUserById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
		return user;
	}
}
