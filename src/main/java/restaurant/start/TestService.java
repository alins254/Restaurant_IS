package restaurant.start;

import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Personal;
import restaurant.entity.stock.Stock;
import restaurant.repository.AdministratorRepo;
import restaurant.service.AdministratorService;
import restaurant.service.LoginService;

import java.sql.SQLOutput;
import java.util.UUID;

public class TestService {
    public static void test(){
        AdministratorService as = new AdministratorService();
        Personal p = as.createNewPersonal("abcd", 20.0d, "chef");
        as.addNewUser("chelner1", "chelner1", p);
        Personal p2 = as.createNewPersonal("Ospatar2", 30.0d, "waiter");
        as.addNewUser("1234567890", "12345678900", p2);
        as.showAllPersonal();
        System.out.println(new LoginService().checkAccount("chelner1","chelner1").getClass().getSimpleName());
        //System.out.println(as.removeUser("12345678"));
        //System.out.println(as.removeUser("ospatar1"));
        MenuItem m = as.addMenuItem("Castane",1.0f,"dishes",186);
        System.out.println(as.removeMenuItem(m));
        for(MenuItem m2:as.showAllMenuItems())
            System.out.println(m2.toString());
        for(Personal p3:as.showAllPersonal())
            System.out.println(p3.toString());
    }
}
