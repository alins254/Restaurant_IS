package restaurant.service;

import restaurant.entity.Account;
import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.Drinks;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Chef;
import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;
import restaurant.entity.stock.Stock;
import restaurant.repository.AdministratorRepo;

import java.util.ArrayList;
import java.util.UUID;

public class AdministratorService {
    private AdministratorRepo repo = new AdministratorRepo();

    public Personal createNewPersonal(String name, Double salary, String type){
        Personal p;
        if(type.toLowerCase().equals("waiter")){
            p = new Waiter(name, salary);
            p.setType("waiter");
        }else if(type.toLowerCase().equals("chef")){
            p = new Chef(name, salary);
            p.setType("chef");
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

        account.setPerson(personal);
        personal.setAccount(account);

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
        ArrayList<Personal> accounts = repo.showAllPersonal();
        if(accounts == null)
            return new ArrayList<Personal>();
        return accounts;
    }

    public MenuItem addMenuItem(String name, Float price, String type, Integer pieces){
        MenuItem m;
        if(type.toLowerCase().equals("drinks")){
            m = new Drinks(name, price);
            m.setType("drinks");
        }else if(type.toLowerCase().equals("dishes")){
            m = new Dishes(name, price);
            m.setType("dishes");
        }else{
            return null;
        }

        Stock s = new Stock(pieces);
        s.setMenuItem(m);
        s.setId(UUID.randomUUID().toString());
        m.setId(UUID.randomUUID().toString());
        m.setStock(s);
        return repo.addMenuItem(s, m);
    }

    public String removeMenuItem(MenuItem m){
        return repo.removeMenuItem(m);
    }

    public ArrayList<MenuItem> showAllMenuItems(){
        ArrayList<MenuItem> accounts = repo.showAllMenuItems();
        if(accounts == null)
            return new ArrayList<MenuItem>();
        return accounts;
    }

    public String modifyStock(MenuItem m, Integer pieces){
        //return repo.modifyStock(m.getStock().getId(), pieces);
        return "";
    }

}
