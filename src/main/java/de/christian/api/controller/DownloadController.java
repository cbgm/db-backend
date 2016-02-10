package de.christian.api.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/download")
public class DownloadController {

	@RequestMapping(value = "/{file_name}", method = RequestMethod.GET, produces = "application/pdf")
	public @ResponseBody byte[] downloadPDFFile(HttpServletResponse response, @PathVariable("file_name") String fileName)
			throws IOException {

		File file = new File(".." + File.separator + "docroot" +File.separator +  fileName + ".pdf");

		response.setContentType("application/octet-stream");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition","attachment;filename=" + file.getName() + ".pdf");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentLength((int) file.length());
		return FileUtils.readFileToByteArray(file);
	}
}
