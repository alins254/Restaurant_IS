package restaurant.repository;

import restaurant.entity.Account;
import restaurant.entity.personal.Personal;

import javax.persistence.*;
import java.util.*;

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
        Query q = em.createQuery("SELECT p FROM Personal p WHERE ACCOUNT_ID = " + account.getUsername());
        em.getTransaction().commit();
        Personal person = (Personal) q.getResultList().get(0);
        em.close();
        if(person == null)
             return null;
        return person;
    }
}
