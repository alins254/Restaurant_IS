package restaurant.repository;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.orders.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class TableRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restaurant");

    public TableRepo(){};

    public String addOrder(Orders o){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        if(o != null)
            em.merge(o);
        else
            return "Failed";
        em.getTransaction().commit();
        em.close();
        return "Your order has been placed";
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
