package restaurant.service;

import restaurant.repository.LoginRepo;

public class LoginService {

    private LoginRepo repo; // = new LoginRepo();

    public LoginService(){};

    public String checkAccount(String username, String password){
        String role;
        if((role = Validator.loginValid(username,password)).equals("VALID")){
            //role = repo.checkAccount(username, password);
            return role;
        }else{
            return role;
        }
    }
}
