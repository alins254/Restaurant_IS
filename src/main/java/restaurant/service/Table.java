package restaurant.service;

import javax.persistence.*;

import restaurant.entity.personal.Waiter;

//@Entity
public class Table {

//    @Id
    private String id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="waiter_id")
    private Waiter waiter;

    public Table(){}

    public Table(Waiter waiter){this.waiter = waiter;}

    public String getId(){return id;}

    public Waiter getPersonal(){return waiter;}

    public void setPersonal(Waiter personal) {this.waiter = personal;}
}
