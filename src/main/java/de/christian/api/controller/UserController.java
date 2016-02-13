package de.christian.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.christian.api.gsonstrategy.StrategyGetNews;
import de.christian.api.gsonstrategy.StrategyGetTags;
import de.christian.api.gsonstrategy.StrategyGetUsers;
import de.christian.api.model.News;
import de.christian.api.model.Tag;
import de.christian.api.model.User;
import de.christian.api.service.interfaces.IGalleryService;
import de.christian.api.service.interfaces.INewsService;
import de.christian.api.service.interfaces.ITagService;
import de.christian.api.service.interfaces.IUserService;


@RestController
@RequestMapping(value = "/users")
public class UserController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;

	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getUsers(@RequestHeader(value = "referer", required = false) final String referer) {

		userService = (IUserService) appContext.getBean("userService");
		List<User> entries = new ArrayList<User>(userService.getAllUsers());

		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetUsers()).create();
		String json = gson.toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestHeader(value = "referer", required = false) final String referer, final User entry, @RequestParam(required = false, value = "masterkey") String masterkey) {
		userService = (IUserService) appContext.getBean("userService");
		try {
			userService.registerUser(entry, masterkey);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> getUserEntryByName(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("name") String username) {

		userService = (IUserService) appContext.getBean("userService");
		User entry = null;
		try {
			entry = userService.getUserByName(username);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetUsers()).create();
		String json = gson.toJson(entry);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
}
