package restaurant.repository;

import restaurant.entity.orders.OrdersTable;
import restaurant.service.OrdersService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrdersRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restaurant");

    public String addNewOrder(OrdersTable order){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Succes!";
    }

    public String removeOrder(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        OrdersTable order = em.find(OrdersTable.class, id);
        em.getTransaction().commit();
        if(order == null){
            em.close();
            return "Order does not exist!";
        }
        em.remove(order);
        return "Success!";
    }

    public List<OrdersTable> showAllOrders(){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery( "SELECT o FROM OrdersTable o");
        return (List<OrdersTable>) query.getResultList();
    }

}
