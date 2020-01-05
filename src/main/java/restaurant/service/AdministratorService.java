package restaurant.service;

import restaurant.entity.Account;
import restaurant.entity.personal.Chef;
import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;
import restaurant.repository.AdministratorRepo;

import java.util.ArrayList;
import java.util.UUID;

public class AdministratorService {

    private AdministratorRepo repo;

    public Personal createNewPersonal(String name, Double salary, String type){
        Personal p;
        if(type.toLowerCase().equals("waiter")){
            p = new Waiter(name, salary);
        }else if(type.toLowerCase().equals("chef")){
            p = new Chef(name, salary);
        }else
            return null;
        p.setId(UUID.randomUUID().toString());

        return p;
    }

    public String addNewUser(String username, String password, Personal personal){
        String message = Validator.loginValid(username, password);

        if(!message.equals("VALID"))
            return message;

        Account account = new Account(username, password);
        account.setPerson(personal.getId());
        return repo.addNewUser(account, personal);
    }

    public String removeUser(String username){
        String message = Validator.usernameValid(username);
        if(message.equals("")) {
            message = repo.removeUser(username);
            return message;
        }
        return message;
    }

    public ArrayList<Personal> showAllPersonal(){
        ArrayList<Personal> accounts = (ArrayList<Personal>) repo.showAllPersonal();
        if(accounts == null)
            return new ArrayList<Personal>();
        return accounts;
    }

}
