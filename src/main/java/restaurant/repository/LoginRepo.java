package restaurant.repository;

import restaurant.entity.Account;
import restaurant.entity.personal.Personal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LoginRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restaurant");

    public LoginRepo() {
        //empty
    }

    public Personal checkAccount(Account account){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Account toFind = em.find(Account.class, account.getUsername());
        em.getTransaction().commit();
        if(toFind == null){
            em.close();
            return null;
        }
        if(!toFind.getPassword().equals(account.getPassword())){
            em.close();
            return null;
        }
        em.getTransaction().begin();
        Personal person = em.find(Personal.class, toFind.getPerson());
        em.getTransaction().commit();
        em.close();
        if(person == null)
             return null;
        return person;
    }
}
