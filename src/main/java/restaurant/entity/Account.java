package restaurant.entity;

<<<<<<< HEAD
import restaurant.entity.personal.Personal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class Account {
    @Id
    private String id;

    @Column
    private String username;
    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "person")
    private Personal person;

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
}
