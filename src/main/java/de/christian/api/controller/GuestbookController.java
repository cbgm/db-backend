package de.christian.api.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
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

import de.christian.api.model.GuestbookEntry;
import de.christian.api.service.interfaces.IGuestbookEntryService;

@RestController
@RequestMapping(value = "/guestbook")
public class GuestbookController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;
	
	private IGuestbookEntryService gservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getGuestbook(@RequestHeader(value = "referer", required = false) final String referer) {

		gservice = (IGuestbookEntryService) appContext.getBean("guestbookEntryService");
		List<GuestbookEntry> entries = new ArrayList<GuestbookEntry>();
		try {
			entries.addAll(gservice.getAllGuestbookEntries());
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		String json = new Gson().toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}

	@RequestMapping(value="/add", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody  
	public String addGuestbookEntry(@RequestHeader(value = "referer", required = false) final String referer, @RequestBody final GuestbookEntry entry) {

		gservice = (IGuestbookEntryService) appContext.getBean("guestbookEntryService");
		entry.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString());
		entry.setContent(Jsoup.parse(entry.getContent()).text());
		entry.setAuthor(Jsoup.parse(entry.getAuthor()).text());
		gservice.save(entry);
		return new String(HttpStatus.OK.toString());
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getGuestbookEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) {

		gservice = (IGuestbookEntryService) appContext.getBean("guestbookEntryService");
		GuestbookEntry entry = null;
		try {
			entry = gservice.getById(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		String json = new Gson().toJson(entry);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}


	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<String> getGuestbookPage(@RequestHeader(value = "referer", required = false) final String referer, final Integer start, final Integer end) {

		gservice = (IGuestbookEntryService) appContext.getBean("guestbookEntryService");
		List<GuestbookEntry> entries = new ArrayList<GuestbookEntry>();
		try {
			entries.addAll(gservice.getPaginatedGuestbookEntries(start, end));
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		String json = new Gson().toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
}
