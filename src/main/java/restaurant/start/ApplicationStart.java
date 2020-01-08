package restaurant.start;

import restaurant.entity.User;
import restaurant.entity.menu.Dishes;
import restaurant.entity.menu.Drinks;
import restaurant.entity.menu.Menu;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.orders.Orders;
import restaurant.entity.personal.Chef;
import restaurant.entity.personal.Invoice;
import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;
import restaurant.service.TableService;
import restaurant.service.UserService;

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


		//TestService.test();


        System.out.println("test");
/*
        Waiter w = new Waiter();
		Chef c = new Chef();

        Drinks dr = new Drinks("cola", new Float(14));
        Dishes dishes = new Dishes("car", 16.0f);

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(dr);
        items.add(dishes);


		Orders o = new Orders("masa1", w, items);
		o.setId("unu");
		o.setTotalPrice(43.0f);
		ArrayList<Orders> com = new ArrayList<Orders>();
		ArrayList<Orders> com2 = new ArrayList<Orders>();
		System.out.println(c.getOrders());
		com.add(o);
		com2.add(o);
		c.setOrders(com);
		w.setOrders(com2);
		System.out.println(c.getOrders());
        System.out.println(w.getOrders());
		c.addObserver(w);
		c.orderPrepared();
		System.out.println(c.getOrders());

		Table t = new Table();
		TableService ts = new TableService(t);
		ts.setTable(t);
		System.out.println(ts.getTable().getOccupied());

		ts.addObserver(w);
		ts.addObserver(c);


		ts.orderFood(o);
		System.out.println(ts.getTable().getOccupied());
		ts.leaveTable();
		System.out.println(ts.getTable().getOccupied());
		t.setWaiter(w);
		ArrayList<Table> list = new ArrayList<Table>();
		list.add(t);
		w.setTables(list);
		ArrayList<Orders> list2 = new ArrayList<Orders>();
		list2.add(o);
		o.setTable("masa1");

		w.setTables(list);
		w.setOrders(list2);

 */

        
	}
}
