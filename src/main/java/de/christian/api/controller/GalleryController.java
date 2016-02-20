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

import de.christian.api.gsonstrategy.StrategyGetGalleries;
import de.christian.api.gsonstrategy.StrategyGetNews;
import de.christian.api.model.Gallery;
import de.christian.api.model.News;
import de.christian.api.service.interfaces.IGalleryService;
import de.christian.api.service.interfaces.INewsService;

@RestController
@RequestMapping(value = "/galleries")
public class GalleryController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;

	private IGalleryService galleryService;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getGalleries(@RequestHeader(value = "referer", required = false) final String referer) {

		galleryService = (IGalleryService) appContext.getBean("galleryService");
		List<Gallery> entries = new ArrayList<Gallery>();
		try {
			entries.addAll(galleryService.getAllGalleries());
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetGalleries()).create();
		String json = gson.toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getGalleriesEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) {

		galleryService = (IGalleryService) appContext.getBean("galleryService");
		Gallery entry = null;
		try {
			entry = galleryService.getByIdOverride(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetGalleries()).create();
		String json = gson.toJson(entry);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
}
