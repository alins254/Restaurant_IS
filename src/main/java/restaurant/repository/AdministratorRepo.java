package restaurant.repository;

import restaurant.entity.Account;
import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;

import javax.persistence.*;
import java.util.ArrayList;
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
        entityManager.merge(personal);
        entityManager.merge(account);
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
        em.getTransaction().commit();
        if(account == null){
            em.close();
            return "Username does not exist!";
        }
        em.remove(account);
        em.getTransaction().begin();
        Personal personal = em.find(Personal.class, account.getPerson());
        em.getTransaction().commit();
        em.remove(personal);
        return "Success!";
    }

    public List<Personal> showAllPersonal(){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("Select p FROM Personal p");
        return (List<Personal>) query.getResultList();
    }
}
