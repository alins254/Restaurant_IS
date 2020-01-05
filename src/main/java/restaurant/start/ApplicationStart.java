package restaurant.start;

import restaurant.entity.User;
import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.Drinks;
import restaurant.entity.menu.Menu;
import restaurant.entity.orders.OrdersTable;
import restaurant.entity.personal.Invoice;
import restaurant.entity.personal.Waiter;
import restaurant.service.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationStart {

	public static void main(String[] args) {


//		UserService userService = new UserService();
//		User user = new User();
//		user.setAge(18);
//		user.setName("Tufisi");
//		System.out.println(userService.addUser(user));
		TestService.test();
		System.out.println("Success!");
	}
}
