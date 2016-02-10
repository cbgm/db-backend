package de.christian.api.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IUserDao;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.User;



@Repository("userDao")
public class UserDaoImpl extends GeneralDaoImpl<User, Long> implements IUserDao {
	
	@SuppressWarnings("unchecked")
	public Set<User> getAllUsers() {
		String query = "FROM User";
		return new HashSet<User>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	public User getUserByName(final String name) {
		String query  = "FROM User WHERE name LIKE '" + name + "'";
		return (User) sessionFactory.getCurrentSession().createQuery(query);
	}

	@SuppressWarnings("unchecked")
	public Set<Project> getUserProjects(final User user) {
		String query ="SELECT p FROM User u LEFT JOIN u.projects p WHERE u.userId = " + user.getUserId();
		return new HashSet<Project>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	@SuppressWarnings("unchecked")
	public Set<News> getUserNews(final User user) {
		String query ="SELECT n FROM User u LEFT JOIN u.news n WHERE u.userId = " + user.getUserId();
		return new HashSet<News>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	@Override
	protected Class<User> getEntityClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
