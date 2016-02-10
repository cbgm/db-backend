package de.christian.api.service.interfaces;

import java.util.Set;

import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.User;



public interface IUserService extends IGeneralService<User, Long> {
	
	public Set<User> getAllUsers();
	public User getUserByName(final String name);
	public Set<Project> getUserProjects(final User user);
	public Set<News> getUserNews(final User user);
}
