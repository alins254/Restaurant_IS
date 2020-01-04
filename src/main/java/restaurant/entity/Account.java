package restaurant.entity;

import restaurant.entity.personal.Personal;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    private String username;
    @Column
    private String password;

//    @OneToOne
//    @JoinColumn(name = "id")
    private String person;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {

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

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}