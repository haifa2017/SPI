package fr.univbrest.dosi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.User;
import fr.univbrest.dosi.business.UserService;

@Controller
@RestController
@RequestMapping("/login")
public class UserControll {
	UserService userService;
	@Autowired
	public UserControll(UserService userService) {
		this.userService = userService;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/auth")
    public void Authentifier (final HttpServletRequest request, @RequestBody final @Qualifier("") User user ) {
		final User users = userService.authentifier(user.getUsername(),user.getPwd());
    	if (users!=null) {
    		request.getSession().setAttribute("user", user.getUsername());
    	}
    	else {
    		request.getSession().removeAttribute("user");
    	}
    }
	
}
