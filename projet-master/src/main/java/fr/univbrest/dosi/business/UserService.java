package fr.univbrest.dosi.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.User;

@Service
public class UserService {

	private final Map<String, User> mapBouchonUser;

	public UserService() {
		mapBouchonUser = new HashMap<String, User>();
		mapBouchonUser.put("eljarroudi", new User("eljarroudi", "1234", Arrays.asList("Admin")));
		mapBouchonUser.put("haifa", new User("haifa", "1234", Arrays.asList("visiteur")));
		mapBouchonUser.put("Yanick", new User("Yanick", "1234", Arrays.asList("Prof")));
	}

	/**
	 * @param login
	 * @param pwd
	 * @return
	 */
	public User authentifier(final String login, final String pwd) {
		final User user = mapBouchonUser.get(login);
		if (user != null && user.getPwd().equals(pwd)) {
			return user;
		}
		return null;
	}

}
