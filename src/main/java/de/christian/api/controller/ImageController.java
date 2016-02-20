package de.christian.api.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
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

import de.christian.api.gsonstrategy.StrategyGetImages;
import de.christian.api.gsonstrategy.StrategyGetNews;
import de.christian.api.model.GuestbookEntry;
import de.christian.api.model.Image;
import de.christian.api.service.interfaces.IGuestbookEntryService;
import de.christian.api.service.interfaces.IImageService;

@RestController
@RequestMapping(value="/images")
public class ImageController {
	
	@Autowired
	private ApplicationContext appContext;
	
	private IImageService iservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getImages(@RequestHeader(value = "referer", required = false) final String referer) {
		iservice = (IImageService) appContext.getBean("imageService");
		List<Image> entries = new ArrayList<Image>();
		try {
			entries.addAll(iservice.getAllImages());
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		Gson gson = new GsonBuilder().setExclusionStrategies(new StrategyGetImages()).create();
		String json = gson.toJson(entries);
		return new ResponseEntity<String>(json,HttpStatus.OK);
		
	}
	
//	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces="image/png")
//	public @ResponseBody byte[] getImageDataUrl(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) throws IOException {
//		iservice = (IImageService) appContext.getBean("imageService");
//		Image image = iservice.getByIdOverride(id);
//
//		if (image != null) {
//			String[] splittedUrl = image.getUrl().split(",");
//			String cleanBase64Image =  splittedUrl[splittedUrl.length-1];
//			byte[] imageData = Base64.decodeBase64(cleanBase64Image);
//			ByteArrayOutputStream bao = new ByteArrayOutputStream();
//			ByteArrayInputStream input = new ByteArrayInputStream(imageData);
//			input.close();
//			BufferedImage img = ImageIO.read(input);
//			ImageIO.write(img, "png", bao);
//			return bao.toByteArray();
//		}
//		return null;
//		
//
//	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces="image/png")
	public @ResponseBody byte[] getImageOriginalByName(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) throws IOException {
		iservice = (IImageService) appContext.getBean("imageService");
		Image image = iservice.getByIdOverride(id);

		String savePathOriginal = System.getProperty( "catalina.base") + File.separator + "img" +File.separator + image.getName();
		File file = new File(savePathOriginal);
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
		}
		
		
		if (img != null) {
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ImageIO.write(img, "png", bao);
			return bao.toByteArray();
		}
		return null;
		

	}

	@RequestMapping(value="/thumb/{id}", method = RequestMethod.GET, produces="image/png")
	public @ResponseBody byte[] getImageThumbByName(@RequestHeader(value = "referer", required = false) final String referer,  @PathVariable("id") long id) throws IOException {
		iservice = (IImageService) appContext.getBean("imageService");
		Image image = iservice.getByIdOverride(id);

		String savePathThumb = System.getProperty( "catalina.base") + File.separator + "img" +File.separator + "thumb" +File.separator +  image.getName();
		File file = new File(savePathThumb);
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
		}
		
		
		if (img != null) {
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ImageIO.write(img, "png", bao);
			return bao.toByteArray();
		}
		return null;
		

	}
	
}
