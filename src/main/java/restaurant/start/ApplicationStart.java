package restaurant.start;

import restaurant.entity.personal.Personal;
import restaurant.service.AdministratorService;
import restaurant.service.EmailService;
//import restaurant.service.UserService;

import java.util.List;

public class ApplicationStart {

	public static void main(String[] args) {


//		UserService userService = new UserService();
//		User user = new User();
//		user.setAge(18);
//		user.setName("Tufisi");
//		System.out.println(userService.addUser(user));

		EmailService emailService = new EmailService();
		emailService.sendEmail("yourmail@youremail", "is", "is");

		AdministratorService administratorService = new AdministratorService();
//		Personal p = administratorService.createNewPersonal("M", 32.0, "waiter");
//		administratorService.addNewUser("waiter123", "waiter123", p);
//
//		Personal p2 = administratorService.createNewPersonal("M1", 92.0, "chef");
//		administratorService.addNewUser("chef123456", "chef123456", p2);

		List<Personal> personal = administratorService.showAllPersonal();
		personal.forEach(s -> System.out.println(s.getName() + ", " + s.getType() + ", " + s.getId()));
		System.out.println(personal.size());
	}
}
