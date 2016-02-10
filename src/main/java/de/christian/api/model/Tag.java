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

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.gson.annotations.Expose;

@SuppressWarnings("serial")
@Entity
@Table(name="tag")
public class Tag implements Model {
	
	@Id
	@Column(name="tagId")
	@GeneratedValue
	private Long tagId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(mappedBy="tags")
	private Set<News> news = new HashSet<News>();
	
	@ManyToMany(mappedBy="tags")
	private Set<Project> projects = new HashSet<Project>();
//	
	@ManyToMany(mappedBy="tags")
	private Set<Article> articles = new HashSet<Article>();
	
	public Tag(){
		
	}
	
	public Tag(final String name){
		this.name = name;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(final Long tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	public Set<News> getNews() {
		return news;
	}
	
	public void addNews(final News news){
		this.news.add(news);
	}
	
	public void removeNews(final News news){
		this.news.remove(news);
	}

	public void setNews(final Set<News> news) {
		this.news = news;
	}
	
	public void removeNews(){
		this.news.clear();
	}
//	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	public Set<Project> getProjects() {
		return projects;
	}
	public void addProject(final Project project){
		this.projects.add(project);
	}
	
	public void removeProject(final Project project){
		this.projects.remove(project);
	}
	
	public void removeProjects(){
		this.projects.clear();
	}


	public void setProjects(final Set<Project> projects) {
		this.projects = projects;
	}
//	
//	public void addArticle(final Article article){
//		this.articles.add(article);
//	}
//	
//	public void removeArticle(final Article article){
//		this.articles.remove(article);
//	}
//	
//	public void removeArticle(){
//		this.articles.clear();
//	}
//	
//	public Set<Article> getArticles() {
//		return articles;
//	}
//
//	public void setArticles(final Set<Article> articles) {
//		this.articles = articles;
//	}

	
	public String toString(){
		String temp = 
			"[Tag:\n" 
			+ "-name | " + name +"\n"
			+"\n]";
		return temp;
		
	}
	
}
