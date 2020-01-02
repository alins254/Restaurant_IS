package restaurant.entity.personal;

import restaurant.entity.Account;

import javax.persistence.*;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personal extends Observable {

    @Id
    private String id;

    @Column
    private String name;
    @Column
    private Date dateOfEmployment;
    @Column
    private Double salary;
    @Column
    private String type;

    @OneToOne
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

    public Personal(){
        dateOfEmployment = new Date();
    }

    public Personal(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public Double getSalary() {
        return salary;
    }

    public String getId() {

        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSalary(Double salary) {

        this.salary = salary;
    }

    public void setDateOfEmployment(Date d){
        this.dateOfEmployment = d;
    }

    public void setType(String type) {
        this.type = type;
    }

<<<<<<< HEAD
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
