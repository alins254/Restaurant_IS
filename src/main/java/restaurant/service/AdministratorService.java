package restaurant.service;

import restaurant.entity.Account;
import restaurant.repository.AdministratorRepo;

import java.util.ArrayList;

public class AdministratorService {

    private AdministratorRepo repo;

    public String addNewUser(String username, String password, Object role){
        String message = Validator.loginValid(username, password);

        if(!message.equals("VALID"))
            return message;

        if(!Validator.existingAccountRole(role))
            return "Invalid Role";

        //return repo.addNewUser(username, password, role);
        return "";
    }

    public String removeUser(String username){
        String message = Validator.usernameValid(username);
        if(message.equals("")) {
            //message = repo.removeUser(username);
            return message;
        }
        return message;
    }

    public ArrayList<Account> showAllUser(){
        ArrayList<Account> accounts = repo.getAllUsers();
        if(accounts == null)
            return new ArrayList<Account>();
        return accounts;
    }

}
