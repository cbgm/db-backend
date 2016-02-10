package de.christian.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.christian.api.gsonstrategy.StrategyGetTags;
import de.christian.api.model.Tag;
import de.christian.api.service.interfaces.ITagService;


@RestController
@RequestMapping(value = "/tags")
public class TagController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;

	private ITagService tservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getTags(@RequestHeader(value = "referer", required = false) final String referer) {

		tservice = (ITagService) appContext.getBean("tagService");
		List<Tag> entries = new ArrayList<Tag>();
		try {
			entries.addAll(tservice.getAllTags());
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetTags()).create();
		String json = gson.toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
		
	}
}
