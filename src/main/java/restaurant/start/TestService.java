package restaurant.start;

import restaurant.entity.personal.Personal;
import restaurant.service.AdministratorService;

public class TestService {
    public static void test(){
        AdministratorService as = new AdministratorService();
        Personal p = as.createNewPersonal("abc", 20.0d, "chef");
        as.addNewUser("1234567895", "123456789", p);
        as.showAllPersonal();
    }
}
