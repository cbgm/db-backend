package de.christian.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;




@SuppressWarnings("serial")
@Entity
@Table(name="gallery")
public class Gallery implements Model {
	
	@Id
	@Column(name="galleryId")
	@GeneratedValue
	private Long galleryId;
	
	@Column(name="name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gallery_image", joinColumns = @JoinColumn(name = "galleryId"),
            inverseJoinColumns = @JoinColumn(name = "imageId"))
	private Set<Image> images = new HashSet<Image>();
	
	
	public Gallery(){
		
	}

	public Gallery(final String name){
		this.name = name;
	}

	public Long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(final Long galleryId) {
		this.galleryId = galleryId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void addImage(final Image image){
		this.images.add(image);
	}
	
	public void removeImages(){
		this.images.clear();
	}
	
	public void removeImage(final Image image){
		this.images.remove(image);
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(final Set<Image> images) {
		this.images = images;
	}
	
	
}
