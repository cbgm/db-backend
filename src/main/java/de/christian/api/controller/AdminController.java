package de.christian.api.controller;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.christian.api.model.Article;
import de.christian.api.model.Gallery;
import de.christian.api.model.GuestbookEntry;
import de.christian.api.model.Image;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.Tag;
import de.christian.api.service.interfaces.IArticleService;
import de.christian.api.service.interfaces.IGalleryService;
import de.christian.api.service.interfaces.IGuestbookEntryService;
import de.christian.api.service.interfaces.IImageService;
import de.christian.api.service.interfaces.INewsService;
import de.christian.api.service.interfaces.IProjectService;
import de.christian.api.service.interfaces.ITagService;

@RestController
//@RequestMapping(value = "/admin")
public class AdminController extends ExtendedController {

	@Autowired
	private ApplicationContext appContext;

	private INewsService newsService;
	
	private IGuestbookEntryService gService;
	
	private IProjectService pService;
	
	private IArticleService aService;
	
	private ITagService tagService;
	
	private IImageService iservice;
	
	private IGalleryService galleryService;

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/news/{id}", method = RequestMethod.DELETE)  
	public ResponseEntity<String> deleteNewsEntryById(@RequestHeader(value = "referer", required = false) final String referer, @PathVariable("id") long id) {

		newsService = (INewsService) appContext.getBean("newsService");
		try {
			newsService.deleteById(id);

		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);	
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/news/add", method = RequestMethod.POST, consumes="application/json")
	public String addNewskEntry(@RequestHeader(value = "referer", required = false) final String referer, @RequestBody final News entry) {

		newsService = (INewsService) appContext.getBean("newsService");
		entry.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString());
		newsService.save(entry);
		return new String(HttpStatus.OK.toString());		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/news/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateNewsEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id, @RequestBody final News entry) {

		newsService = (INewsService) appContext.getBean("newsService");
		try {
			newsService.update(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/guestbook/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteGuestbookEntryById(@RequestHeader(value = "referer", required = false) final String referer, @PathVariable("id") long id) {

		gService = (IGuestbookEntryService) appContext.getBean("guestbookEntryService");
		try {
			gService.deleteById(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/guestbook/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateGuestbookEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id, @RequestBody final GuestbookEntry entry) {

		gService = (IGuestbookEntryService) appContext.getBean("guestbookEntryService");
		GuestbookEntry temp = entry;
		temp.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
		temp.setGuestbookId(id);
		try {
			gService.update(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/tags/add", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addTagEntry(@RequestHeader(value = "referer", required = false) final String referer, @RequestBody final Tag entry) {

		tagService = (ITagService) appContext.getBean("tagService");
		try {
			tagService.save(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/tags/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTagEntryById(@RequestHeader(value = "referer", required = false) final String referer, @PathVariable("id") long id) {

		tagService = (ITagService) appContext.getBean("tagService");
		try {
			tagService.deleteById(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/projects/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateProjectEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id, @RequestBody final Project entry) {

		pService = (IProjectService) appContext.getBean("projectService");
		try {
			pService.updateById(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/projects/add", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addProjectEntry(@RequestHeader(value = "referer", required = false) final String referer, @RequestBody final Project entry) {

		pService = (IProjectService) appContext.getBean("projectService");
		entry.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString());
		try {
			pService.save(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/projects/{pId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProject(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("pId") long pId) {

		pService = (IProjectService) appContext.getBean("projectService");
		try {
			pService.deleteById(pId);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/projects/{pId}/articles/{aId}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateProjectArticleById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("pId") long pId, @PathVariable("aId") long aId, @RequestBody final Article entry) {

		aService = (IArticleService) appContext.getBean("articleService");
		try {
			aService.updateById(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/projects/{pId}/articles/{aId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProjectArticleById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("pId") long pId, @PathVariable("aId") long aId) {

		pService = (IProjectService) appContext.getBean("projectService");
		try {
			pService.deleteProjectArticleById(pId, aId);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/projects/{pId}/articles/add", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addArticleEntry(@RequestHeader(value = "referer", required = false) final String referer, @PathVariable("pId") long pId, @RequestBody final Article entry) {

		pService = (IProjectService) appContext.getBean("projectService");
		entry.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString());
		try {
			pService.addProjectArticle(pId, entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/images/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteImage(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) {
		iservice = (IImageService) appContext.getBean("imageService");
		Image image = new Image();
		image.setImageId(id);
		try {
			iservice.delete(image);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="admin/images/upload", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> uploadImage (@RequestHeader(value = "referer", required = false) final String referer, @RequestBody final Image image) {
		iservice = (IImageService) appContext.getBean("imageService");
		try {
			iservice.save(image);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/admin/galleries/{id}", method = RequestMethod.DELETE)  
	public ResponseEntity<String> deleteGalleryEntryById(@RequestHeader(value = "referer", required = false) final String referer, @PathVariable("id") long id) {

		galleryService = (IGalleryService) appContext.getBean("galleryService");
		try {
			galleryService.deleteById(id);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/galleries/add", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> addGalleryEntry(@RequestHeader(value = "referer", required = false) final String referer, @RequestBody final Gallery entry) {

		galleryService = (IGalleryService) appContext.getBean("galleryService");
		try {
			galleryService.save(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
	@RequestMapping(value="/admin/galleries/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateGalleryEntryById(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id, @RequestBody final Gallery entry) {

		galleryService = (IGalleryService) appContext.getBean("galleryService");
		try {
			galleryService.update(entry);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
