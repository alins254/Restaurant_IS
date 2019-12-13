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
=======
public class Account {
    private String username;
    private String role;

    public Account(String username, String role) {
        this.username = username;
        this.role = role;
>>>>>>> AdminService - Add/Remove/Show User
    }

    public String getUsername() {
        return username;
    }

<<<<<<< HEAD
    public String getPassword() {
        return password;
=======
    public String getRole() {
        return role;
>>>>>>> AdminService - Add/Remove/Show User
    }

    public void setUsername(String username) {
        this.username = username;
    }

<<<<<<< HEAD
    public void setPassword(String password) {
        this.password = password;
=======
    public void setRole(String role) {
        this.role = role;
>>>>>>> AdminService - Add/Remove/Show User
    }
}
