package restaurant.start;

import restaurant.entity.User;
import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.Drinks;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.orders.OrdersTable;
import restaurant.entity.personal.Invoice;
import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;
import restaurant.service.AdministratorService;
import restaurant.service.OrdersService;
import restaurant.service.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationStart {

	public static void main(String[] args) {

//		AdministratorService administratorService = new AdministratorService();
//		Personal p = administratorService.createNewPersonal("M", 32.0, "waiter");
//		administratorService.addNewUser("waiter123", "waiter123", p);
//		UserService userService = new UserService();
//		User user = new User();
//		user.setAge(18);
//		user.setName("Tufisi");
//		System.out.println(userService.addUser(user));
		TestService.test();
		System.out.println("Success!");

	}
}
