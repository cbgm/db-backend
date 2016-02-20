package de.christian.api.dao;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;






import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import de.christian.api.dao.interfaces.IImageDao;
import de.christian.api.model.Image;




@Repository("imageDao")
public class ImageDaoImpl extends GeneralDaoImpl<Image, Long> implements IImageDao{

	@Override
	protected Class<Image> getEntityClass() {
		// TODO Auto-generated method stub
		return Image.class;
	}

	public Set<Image> getAllImages() {
		String query = "FROM Image i";
		return new HashSet<Image>(sessionFactory.getCurrentSession().createQuery(query).list());
	}

	public Image getByIdOverride(long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Image where imageId=:id");
		q.setParameter("id", entityId);
		Image image = (Image) q.uniqueResult();
		return image;
	}

	@Override
	public void save (final Image image) {
		Image temp = image;
		///save image on Server
		String savePathOriginal = System.getProperty( "catalina.base") + File.separator + "img" +File.separator +  image.getName();
		String savePathThumb = System.getProperty( "catalina.base") + File.separator + "img" +File.separator + "thumb" +File.separator +  image.getName();
		File originalFile = new File(savePathOriginal);
		File thumbFile = new File(savePathThumb);
		
		
		try {
			//save original
			String[] splittedUrl = image.getDataUrl().split(",");
			String cleanBase64Image =  splittedUrl[splittedUrl.length-1];
			byte[] imageData = Base64.decodeBase64(cleanBase64Image);
			ByteArrayInputStream input = new ByteArrayInputStream(imageData);
			input.close();
			BufferedImage img = ImageIO.read(input);
			ImageIO.write(img, "png", originalFile);
			
			//convert original and save thumb
			int type = img.getType() == 0? BufferedImage.TYPE_INT_ARGB : img.getType();
			BufferedImage resizeImageJpg = resizeImage(img, type);
			ImageIO.write(resizeImageJpg, "png", thumbFile);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		//reaplace url after success and save image ref
//		temp.setName(nameSplit[0]);
		temp.setDataUrl("");
		super.save(temp);
	}

	@Override
	public void delete (final Image image) {
		Image temp = image;
		String savePathOriginal = System.getProperty( "catalina.base") + File.separator + "img" +File.separator +  image.getName();
		String savePathThumb = System.getProperty( "catalina.base") + File.separator + "img" +File.separator + "thumb" +File.separator +  image.getName();
		//delete original
		File file = new File(savePathOriginal);
		file.delete();
		//delete thumb
		file = new File(savePathThumb);
		file.delete();
		//delete database item
		super.delete(temp);
	}

	 private BufferedImage resizeImage(BufferedImage originalImage, int type){
		int width = 100;
		int height = 100;
		int fHeight = 100;
		int fWidth = 100;
		//Work out the resized width/height
		if (originalImage.getHeight() > height || originalImage.getWidth() > width) {
			fHeight = height;
			int wid = width;
			float sum = (float)originalImage.getWidth() / (float)originalImage.getHeight();
			fWidth = Math.round(fHeight * sum);
			if (fWidth > wid) {
				//rezise again for the width this time
				fHeight = Math.round(wid/sum);
				fWidth = wid;
			}
		}

		BufferedImage resizedImage = new BufferedImage(fWidth, fHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, fWidth, fHeight, null);
		g.dispose();
		return resizedImage;
	}
}

