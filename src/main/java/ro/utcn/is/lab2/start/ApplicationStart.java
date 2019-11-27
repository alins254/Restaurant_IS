package ro.utcn.is.lab2.start;

import java.util.UUID;

import ro.utcn.is.lab2.entity.*;
import ro.utcn.is.lab2.repository.*;
import ro.utcn.is.lab2.service.UserService;
import ro.utcn.is.lab2.view.*;

public class ApplicationStart {

	public static void main(String[] args) {
		 UserService userService = new UserService();
		 User user = new User();
		 user.setAge(18); 
		 user.setName("Tufisi");
		 System.out.println(userService.addUser(user));
		
	}
}
