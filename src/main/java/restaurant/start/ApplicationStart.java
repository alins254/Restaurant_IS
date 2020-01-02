package restaurant.start;

import restaurant.entity.User;
import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.Drinks;
import restaurant.entity.menu.Menu;
import restaurant.entity.orders.Orders;
import restaurant.entity.personal.Invoice;
import restaurant.entity.personal.Waiter;
import restaurant.service.UserService;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationStart {

	public static void main(String[] args) {

		/*
		UserService userService = new UserService();
		User user = new User();
		user.setAge(18);
		user.setName("Tufisi");
		System.out.println(userService.addUser(user));
		 */


		Waiter w = new Waiter("John", 500.0);
		Dishes di1 = new Dishes("cartofi",new Float(18.5));
		Drinks dr1 = new Drinks("cola", new Float(3.75));
		List it = new ArrayList<Menu>();
		it.add(di1);
		it.add(dr1);
		it.add(dr1);
		Orders o = new Orders(new String("1"), w, it);
		Invoice i = new Invoice();
		System.out.println(i.calculateTotal(o));
		i.generate(o);


	}
}
