package restaurant.start;

import restaurant.entity.menu.MenuItem;

import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;
import restaurant.service.AdministratorService;
import restaurant.service.OrdersService;

import java.util.ArrayList;

public class ApplicationStart {

	public static void main(String[] args) {

//		AdministratorService administratorService = new AdministratorService();
//		Personal p = administratorService.createNewPersonal("M", 32.0, "waiter");
//		UserService userService = new UserService();
//		User user = new User();
//		user.setAge(18);
//		user.setName("Tufisi");
//		System.out.println(userService.addUser(user));
		TestService.test();

	}
}
