package restaurant.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections4.*;

import restaurant.entity.User;
import restaurant.messages.Messages;
import restaurant.repository.UserRepo;

public class  UserService {

	private UserRepo userRepo = new UserRepo();

	public String addUser(User user) {
		List<String> missingFields = new ArrayList<String>();
		if (user == null) {
			return "User " + Messages.DEFAULT_NULL_MESSAGE;
		}
		if (user.getAge() == null) {
			missingFields.add("age");
		}
		if (StringUtils.isEmpty(user.getName())) {
			missingFields.add("name");
		}
		if (CollectionUtils.isNotEmpty(missingFields)) {
			return "This field(s) are missing: " + missingFields.stream().collect(Collectors.joining(", "));
		}
		if (user.getAge() < 18) {
			return "Invalid age. Must be greater than 18";
		}

		user.setId(UUID.randomUUID().toString());
		user.setCreatedAt(new Date());
		userRepo.insert(user);
		return "OK. New user succesfully inserted.";

	}

}
