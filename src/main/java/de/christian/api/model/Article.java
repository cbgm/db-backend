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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@SuppressWarnings("serial")
@Entity
@Table(name="article")
public class Article implements Model{
	
	@Id
	@Column(name="articleId")
	@GeneratedValue
	private Long articleId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="date")
	private String date;
	
	@ManyToOne
    @JoinColumn(name="projectId")
    private Project project;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
	private Set<Tag> tags = new HashSet<Tag>();
	
	public Article(){
		
	}

	public Article(final String content){
		this.content = content;
	}
	
	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(final Long articleId) {
		this.articleId = articleId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(final Project project) {
		this.project = project;
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
			"[Article:\n" 
			+ "-content | " + content +"\n"
			+"\n]";
		return temp;
		
	}
	
}
