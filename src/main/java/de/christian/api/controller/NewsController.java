package de.christian.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.christian.api.gsonstrategy.StrategyGetNews;
import de.christian.api.model.News;
import de.christian.api.service.interfaces.INewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;

	private INewsService newsService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<String> getNewsPage(@RequestHeader(value = "referer", required = false) final String referer, final Integer start, final Integer end) {

		newsService = (INewsService) appContext.getBean("newsService");
		List<News> entries = new ArrayList<News>();
		try {
			entries.addAll(newsService.getPaginatedNewsEntries(start, end));
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetNews()).create();
		String json = gson.toJson(entries);

		return new ResponseEntity<String>(json,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getNews(@RequestHeader(value = "referer", required = false) final String referer) {

		newsService = (INewsService) appContext.getBean("newsService");
		List<News> entries = new ArrayList<News>();
		try {
			entries.addAll(newsService.getAllNews());
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetNews()).create();
		String json = gson.toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getNewsEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) {

		newsService = (INewsService) appContext.getBean("newsService");
		News entry = null;
		try {
			entry = newsService.getByIdOverride(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetNews()).create();
		String json = gson.toJson(entry);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
}
