package restaurant.start;

import restaurant.entity.User;
import restaurant.entity.*;
import restaurant.repository.*;
import restaurant.service.UserService;
//import ro.utcn.is.lab2.view.*;

public class ApplicationStart {

	public static void main(String[] args) {
		 UserService userService = new UserService();
		 User user = new User();
		 user.setAge(18);
		 user.setName("Tufisi");
		 System.out.println(userService.addUser(user));
		
	}
}
