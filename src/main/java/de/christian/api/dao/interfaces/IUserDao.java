package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.SimpleUserObject;
import de.christian.api.model.User;



public interface IUserDao extends IGeneralDao<User, Long> {
	
	public Set<User> getAllUsers();
	public User getUser();
	public User getUserByName(final String name);
	public Set<Project> getUserProjects(final User user);
	public Set<News> getUserNews(final User user);
	public void deleteByName(final String name);
	public void updateByName(final String name, final SimpleUserObject user);
	public void registerUser(final User user, final String masterkey);
	public void save(SimpleUserObject entry);

}
