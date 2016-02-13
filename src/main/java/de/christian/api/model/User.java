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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SuppressWarnings("serial")
@Entity
@Table(name="user")
public class User implements Model {

	@Id
	@Column(name="username" ,nullable=false,length=50)
	private String username;
	
	@Column(name="password",nullable=false,length=50)
	private String password;
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(
            name="user_project",
            joinColumns = @JoinColumn( name="username"),
            inverseJoinColumns = @JoinColumn( name="projectId")
    )
	private Set<Project> projects = new HashSet<Project>();
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(
            name="user_news",
            joinColumns = @JoinColumn( name="username"),
            inverseJoinColumns = @JoinColumn( name="newsId")
    )
	private Set<News> news = new HashSet<News>();

	@OneToMany(cascade = CascadeType.ALL ,mappedBy="user", fetch=FetchType.LAZY)
    private Set<Role> roles = new HashSet<Role>();

	public User(){
		
	}
	
	public User(String username, String passwordHash){
		this.username = username;
		this.password = passwordHash;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
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

	public void addRoles(final Role roles){
		this.roles.add(roles);
	}
	
	public void removeRole(final Role role){
		this.roles.remove(role);
	}
	
	public void removeRoles(){
		this.news.clear();
	}

	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(final Set<Role> roles) {
		this.roles = roles;
	}

	public String toString(){
		String temp = 
			"[User:\n" 
			+ "-name | " + username +"\n"
			+ "-password | " + password
			+"\n]";
		return temp;
		
	}
	

}
