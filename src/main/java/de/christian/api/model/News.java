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
@Table(name="news")
public class News implements Model {
	
	@Id
	@Column(name="newsId")
	@GeneratedValue
	private Long newsId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="date")
	private String date;
	
//	@ManyToMany(cascade = { CascadeType.PERSIST },fetch =FetchType.EAGER)
//    @JoinTable(name="news_tag", joinColumns={@JoinColumn(name="newsId")},inverseJoinColumns={@JoinColumn(name="tagId")})
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_tag", joinColumns = @JoinColumn(name = "newsId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
	private Set<Tag> tags = new HashSet<Tag>();
	
	
	public News(){
		
	}

	public News(final String title, final String content, final String date){
		this.content = content;
		this.title = title;
		this.date = date;
	}
	
	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(final Long newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}
	

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}
	
	public void addTag(final Tag tag){
		this.tags.add(tag);
	}
	
	public void removeTags(){
		this.tags.clear();
	}
	
	public void removeTag(final Tag tag){
		this.tags.remove(tag);
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(final Set<Tag> tags) {
		this.tags = tags;
	}
	
	public String toString(){
		String temp = 
			"[News:\n" 
			+ "-title | " + title +"\n"
			+ "-content | " + content +"\n"
			+"\n]";
		return temp;
		
	}
}
