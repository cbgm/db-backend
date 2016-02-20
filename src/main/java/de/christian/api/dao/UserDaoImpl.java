package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IUserDao;
import de.christian.api.model.Article;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.Role;
import de.christian.api.model.SimpleUserObject;
import de.christian.api.model.Tag;
import de.christian.api.model.User;



@Repository("userDao")
public class UserDaoImpl extends GeneralDaoImpl<User, Long> implements IUserDao {
	
	@SuppressWarnings("unchecked")
	public Set<User> getAllUsers() {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM User u ORDER BY u.username ASC");
		ArrayList<User> array = new ArrayList<User>(q.list());

		for (User u: array) {
			ArrayList<Role> roles =  new  ArrayList<Role>(u.getRoles());
			u.setRoles(new HashSet<Role>(roles));
		}
		return new HashSet<User>(array);
	}

	public User getUserByName(final String name) {
		Query query= sessionFactory.getCurrentSession().createQuery("FROM User WHERE username LIKE '" + name + "'");
		User user = (User) query.uniqueResult();
		ArrayList<Role> roles =  new  ArrayList<Role>(user.getRoles());
		user.setRoles(new HashSet<Role>(roles));
		return user;
	}

	@SuppressWarnings("unchecked")
	public Set<Project> getUserProjects(final User user) {
		return null;
//		String query ="SELECT p FROM User u LEFT JOIN u.projects p WHERE u.username = " + user.getUserId();
//		return new HashSet<Project>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	@SuppressWarnings("unchecked")
	public Set<News> getUserNews(final User user) {
		return null;
//		String query ="SELECT n FROM User u LEFT JOIN u.news n WHERE u.username = " + user.getUserId();
//		return new HashSet<News>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	@Override
	protected Class<User> getEntityClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

	public void deleteByName(final String name) {
		Query q= sessionFactory.getCurrentSession().createQuery("from User WHERE username LIKE '" + name + "'");
		User user = (User) q.uniqueResult();
		ArrayList<Role> roles =  new  ArrayList<Role>(user.getRoles());

		for(Role role : roles) {
			this.sessionFactory.getCurrentSession().delete(role);
		}
		
		this.sessionFactory.getCurrentSession().delete(user);
	}

	public void registerUser(final User user, final String masterkey) {
		// TODO Auto-generated method stub
		if (masterkey == "bergmann2016christian") {
			this.sessionFactory.getCurrentSession().save(user);
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateByName(final String name, final SimpleUserObject entry) {
		Query query= sessionFactory.getCurrentSession().createQuery("FROM User WHERE username LIKE '" + name + "'");
		User user = (User) query.uniqueResult();
		user.setPassword(entry.getPassword());
		this.sessionFactory.getCurrentSession().update(user);
		query= sessionFactory.getCurrentSession().createQuery("FROM Role WHERE username LIKE '" + name + "'");
		Role role = (Role) query.uniqueResult();
		role.setRole(entry.getRole());
		this.sessionFactory.getCurrentSession().update(role);
	}
	
	public void save(final SimpleUserObject entitiy) {
		User temp = new User();
		temp.setPassword(entitiy.getPassword());
		temp.setUsername(entitiy.getUsername());
		Role role = new Role();
		role.setRole(entitiy.getRole());
		role.setUser(temp);
		ArrayList<Role> roles =  new  ArrayList<Role>();
		roles.add(role);
		temp.setRoles(new HashSet<Role>(roles));
		this.sessionFactory.getCurrentSession().save(temp);
	}

}
