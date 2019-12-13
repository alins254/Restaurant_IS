package restaurant.service;

import restaurant.entity.personal.Personal;

public class Validator {

    public static String loginValid(String username, String password){
        String messages = new String("");
        messages+=usernameValid(username);
        messages+=passwordValid(password);
        if(messages.length()<1) messages+="VALID";

        return messages;
    }

    public static String usernameValid(String username){
        String messages = new String("");
        if(username.length()<8) messages+="username to short - ";
        if(username.length()>30) messages+="username to long - ";
        if(username.contains(" "))  messages+="username cannot contain spaces - ";
        return messages;
    }

    public static String passwordValid(String password){
        String messages = new String("");
        if(password.contains(" ")) messages+="password cannot contain spaces - ";
        if(password.length()<8) messages+="password to short - ";
        if(password.length()>30) messages+="password to long - ";
        return messages;
    }

    public static boolean existingAccountRole(Object role){
        if(role instanceof Personal)
            return true;
        return false;
    }





}
