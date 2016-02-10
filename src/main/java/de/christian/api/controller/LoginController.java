package de.christian.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.christian.api.model.User;
import de.christian.api.service.interfaces.IUserService;

@RestController
@RequestMapping(value= "/login-check")
public class LoginController {

	@Autowired
	private ApplicationContext appContext;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> checkUserLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		if (!(auth instanceof AnonymousAuthenticationToken)) { 
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}
}
