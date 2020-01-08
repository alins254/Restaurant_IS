package restaurant.entity;

import javafx.scene.Parent;
import restaurant.entity.personal.Personal;

import javax.persistence.*;

@Entity(name = "accounts")
public class Account {

    @Id
    private String username;
    @Column
    private String password;

    //@OneToOne(fetch=FetchType.LAZY, targetEntity = Parent.class)
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Personal person;

    public Account(){};

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personal getPerson() {
        return person;
    }

    public void setPerson(Personal person) {
        this.person = person;
    }
}