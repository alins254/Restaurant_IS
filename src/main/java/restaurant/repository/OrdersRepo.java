package restaurant.repository;

import restaurant.entity.orders.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OrdersRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restaurant");

    public String addNewOrder(Orders order){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Order was successfully added!";
    }

    public String removeOrder(String id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Orders order = em.find(Orders.class, id);
        em.getTransaction().begin();
        if(order == null){
            em.close();
            return "Order does not exist! Failed to remove order!";
        }
        em.remove(order);
        em.getTransaction().commit();
        em.close();
        return "Successfully removed order!";
    }

    public List<Orders> showAllOrders(){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery( "SELECT o FROM Orders o");
        return (List<Orders>) query.getResultList();
    }

}
