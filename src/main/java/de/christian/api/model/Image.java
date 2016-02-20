package de.christian.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="image")
public class Image {
	

	@Id
	@Column(name="imageId")
	@GeneratedValue
	private Long imageId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dataUrl")
	private String dataUrl;

	@ManyToMany(mappedBy="images")
	private Set<Gallery> galleries = new HashSet<Gallery>();

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "images")
	public Set<Gallery> getGalleries() {
		return galleries;
	}
	
	public void addGallery(final Gallery gallery){
		this.galleries.add(gallery);
	}
	
	public void removeGallery(final Gallery gallery){
		this.galleries.remove(gallery);
	}

	public void setGalleries(final Set<Gallery> galleries) {
		this.galleries = galleries;
	}
	
	public void removeGalleries(){
		this.galleries.clear();
	}

}
