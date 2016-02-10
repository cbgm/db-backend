package de.christian.api.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SuppressWarnings("serial")
@Entity
@Table(name="user")
public class User implements Model {

	@Id
	@GeneratedValue
	private Long userId;
	
	@Column(name="name" ,nullable=false,length=50)
	private String name;
	
	@Column(name="password",nullable=false,length=50)
	private String password;
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(
            name="user_project",
            joinColumns = @JoinColumn( name="userId"),
            inverseJoinColumns = @JoinColumn( name="projectId")
    )
	private Set<Project> projects = new HashSet<Project>();
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(
            name="user_news",
            joinColumns = @JoinColumn( name="userId"),
            inverseJoinColumns = @JoinColumn( name="newsId")
    )
	private Set<News> news = new HashSet<News>();

	public User(){
		
	}
	
	public User(String name, String passwordHash){
		this.name = name;
		this.password = passwordHash;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		this.password = hashedPassword;
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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(final Set<Project> projects) {
		this.projects = projects;
	}
	
	public void addNews(final News news){
		this.news.add(news);
	}
	
	public void removeNews(final News news){
		this.news.remove(news);
	}
	
	public void removeNews(){
		this.news.clear();
	}

	
	public Set<News> getNews() {
		return news;
	}

	public void setNews(final Set<News> news) {
		this.news = news;
	}
	
	public String toString(){
		String temp = 
			"[User:\n" 
			+ "-name | " + name +"\n"
			+ "-password | " + password
			+"\n]";
		return temp;
		
	}
	

}
