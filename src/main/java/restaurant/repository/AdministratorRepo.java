package restaurant.repository;

import restaurant.entity.Account;
import restaurant.entity.User;
import restaurant.entity.menu.Menu;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Personal;
import restaurant.entity.stock.Stock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public String addNewUser(Account account, Personal personal){
        /**
         * Pentru fiecare metoda se instantiaza un entiy manager din EMF-ul de mai sus.
         */
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /**
         * Denota ca incepe o operatie pe baza de date
         */
        entityManager.getTransaction().begin();
        /**
         * Declaram operatia sau operatiile ce se vor face pe BD.
         */
        Account acc = entityManager.find(Account.class, account.getUsername());
        if(acc != null)
            return "Username already exists!";
        entityManager.merge(account);
        entityManager.merge(personal);
        /**
         * Executam operatia.
         */
        entityManager.getTransaction().commit();
        /**
         * Inchidem EM-ul. Ca la operatii pe fisiere, il deschizi, il citesti si in final il inchizi.
         */
        entityManager.close();
        return "Success!";
    }

    public String removeUser(String username){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Account account = em.find(Account.class, username);
        if(account == null){
            em.close();
            return "Username does not exist!";
        }
        em.remove(account);
        em.getTransaction().commit();
        em.close();
        return "Success!";
    }

    public ArrayList<Personal> showAllPersonal(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT p FROM Personal p");
        em.getTransaction().commit();
        //em.close();
        return (ArrayList<Personal>) query.getResultList();
    }

    public MenuItem addMenuItem(Stock s, MenuItem m){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        MenuItem menuItem = entityManager.find(MenuItem.class, s.getId());
        if(menuItem != null)
            return null;
        entityManager.merge(s);
        entityManager.merge(m);
        entityManager.getTransaction().commit();
        entityManager.close();
        return m;
    }

    public String removeMenuItem(MenuItem m){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        MenuItem menuItem = null;
        menuItem = em.find(MenuItem.class, m.getId());
        if(menuItem == null){
            em.close();
            return "Menu item does not exist!";
        }
        em.remove(menuItem.getStock());
        em.getTransaction().commit();
        em.close();
        return "Success!";
    }

    public ArrayList<MenuItem> showAllMenuItems(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT m FROM Menu m");
        em.getTransaction().commit();
        ArrayList<MenuItem> m = (ArrayList<MenuItem>) query.getResultList();
        em.close();
        return m;
    }
}
