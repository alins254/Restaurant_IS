package restaurant.start;

import restaurant.entity.User;
import restaurant.service.UserService;

public class ApplicationStart {

	public static void main(String[] args) {
		UserService userService = new UserService();
		User user = new User();
		user.setAge(18);
		user.setName("Tufisi");
		System.out.println(userService.addUser(user));
	}
}
