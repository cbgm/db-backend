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

import de.christian.api.gsonstrategy.StrategyGetArticle;
import de.christian.api.gsonstrategy.StrategyGetNews;
import de.christian.api.gsonstrategy.StrategyGetProjects;
import de.christian.api.model.Article;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.service.interfaces.IArticleService;
import de.christian.api.service.interfaces.INewsService;
import de.christian.api.service.interfaces.IProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;

	private IProjectService pService;
	
	private IArticleService aService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<String> getProjectsPage(@RequestHeader(value = "referer", required = false) final String referer, final Integer start, final Integer end) {

		pService = (IProjectService) appContext.getBean("projectService");
		List<Project> entries = new ArrayList<Project>();
		try {
			entries.addAll(pService.getPaginatedProjectEntries(start, end));
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetProjects()).create();
		String json = gson.toJson(entries);

		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getProjects(@RequestHeader(value = "referer", required = false) final String referer) {

		pService = (IProjectService) appContext.getBean("projectService");
		List<Project> entries = new ArrayList<Project>();
		try {
			entries.addAll(pService.getAllProjects());
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetProjects()).create();
		String json = gson.toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getProjectEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) {

		pService = (IProjectService) appContext.getBean("projectService");
		Project entry = null;
		try {
			entry = pService.getByIdOverride(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetProjects()).create();
		String json = gson.toJson(entry);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{pId}/articles/{aId}", method = RequestMethod.GET)
	public ResponseEntity<String> getProjectArticle(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("pId") long pId, @PathVariable("aId") long aId) {

		aService = (IArticleService) appContext.getBean("articleService");
		Article entry = null;
		try {
			entry = aService.getByIdOverride(aId);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetArticle()).create();
		String json = gson.toJson(entry);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
}
