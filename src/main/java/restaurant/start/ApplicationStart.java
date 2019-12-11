package restaurant.start;

import restaurant.entity.User;
import restaurant.entity.personal.Personal;
import restaurant.entity.*;
import restaurant.entity.personal.Waiter;
import restaurant.repository.*;
import restaurant.service.UserService;

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



		Personal p;
		Waiter w = new Waiter();
		System.out.println(w.getName());
		System.out.println(w.getDateOfEmployment());
		System.out.println(w.getInvoices());
		System.out.println(w.getSalary());

		w.setName("alabala");
		w.setSalary(5678.0);

		List l = new ArrayList<String>();
		l.add("inv1");
		l.add("inv2");
		l.add("inv3");
		l.add("inv4");

		w.setInvoices(l);

		System.out.println();

		System.out.println(w.getName());
		System.out.println(w.getDateOfEmployment());
		System.out.println(w.getInvoices());
		System.out.println(w.getSalary());


		System.out.println();

		Date d = new Date();
		System.out.println(d);

	}
}
