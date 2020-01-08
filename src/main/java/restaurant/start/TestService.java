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
        Personal p = as.createNewPersonal("abc", 20.0d, "chef");
        as.addNewUser("12345678", "123456789", p);
        Personal p2 = as.createNewPersonal("Os patar", 30.0d, "waiter");
        as.addNewUser("ospatar1", "ospatar1", p2);
        as.showAllPersonal();
        System.out.println(new LoginService().checkAccount("12345678","123456789").getClass().getSimpleName());
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
