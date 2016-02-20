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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;


@SuppressWarnings("serial")
@Entity
@Table(name="project")
public class Project implements Model {
	
	@Id
	@Column(name="projectId")
	@GeneratedValue
	private Long projectId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="titleAlt")
	private String titleAlt;
	
	@Column(name="descriptionAlt")
	private String descriptionAlt;

	@Column(name="date")
	private String date;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="project", fetch=FetchType.LAZY)
    private Set<Article> articles = new HashSet<Article>();
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_tag", joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
	private Set<Tag> tags = new HashSet<Tag>();
	
	public Project(){
		
	}
	
	public Project(final String title, final String description){
		this.title = title;
		this.description = description;
	}
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(final Long projectId) {
		this.projectId = projectId;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
	
	public String getTitleAlt() {
		return titleAlt;
	}

	public void setTitleAlt(String titleAlt) {
		this.titleAlt = titleAlt;
	}

	public String getDescriptionAlt() {
		return descriptionAlt;
	}

	public void setDescriptionAlt(String descriptionAlt) {
		this.descriptionAlt = descriptionAlt;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}
	
	public void addArticle(final Article article){
		this.articles.add(article);
	}
	
	public void removeArticle(final Article article){
		this.articles.remove(article);
	}
	
	public void removeArticles(){
		this.articles.clear();
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(final Set<Article> articles) {
		this.articles = articles;
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
			"[Project:\n" 
			+ "-title | " + title +"\n"
			+ "-description | " + description +"\n"
			+"\n]";
		return temp;
		
	}


	
}
