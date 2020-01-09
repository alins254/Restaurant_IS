package restaurant.service;

import restaurant.entity.Account;
import restaurant.entity.personal.Personal;
import restaurant.repository.LoginRepo;

public class LoginService {

    private LoginRepo repo = new LoginRepo();

    public LoginService(){};

    public Personal checkAccount(String username, String password) {
        Personal role = null;
        if (Validator.loginValid(username, password).equals("VALID")) {
            role = repo.checkAccount(new Account(username, password));
        }
        return role;
    }
}
