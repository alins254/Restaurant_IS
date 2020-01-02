package restaurant.repository;

import restaurant.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;


public class AdministratorRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restaurant");

    public ArrayList<Account> getAllUsers() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //accounts = (ArrayList<Account>) entityManager.createQuery("SELECT a FROM Personal a").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if(accounts == null)
            return new ArrayList<Account>();
        return accounts;
    }
}
