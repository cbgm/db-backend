package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IUserDao;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.SimpleUserObject;
import de.christian.api.model.User;
import de.christian.api.service.interfaces.IUserService;



@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	
	@Transactional
	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}
	
	@Transactional
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return dao.getUserByName(name);
	}
	
	@Transactional
	public Set<Project> getUserProjects(User user) {
		// TODO Auto-generated method stub
		return dao.getUserProjects(user);
	}
	
	@Transactional
	public Set<News> getUserNews(User user) {
		// TODO Auto-generated method stub
		return dao.getUserNews(user);
	}
	
	@Transactional
	public void save(final User entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}
	
	@Transactional
	public void update(final User entity) {
		dao.update(entity);
		
	}

	@Transactional
	public void delete(final User entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Transactional
	public User getByName(final String name) {
		// TODO Auto-generated method stub
		return dao.getUserByName(name);
	}

	@Transactional
	public void deleteByName(final String name) {
		// TODO Auto-generated method stub
		dao.deleteByName(name);
	}

	@Transactional
	public void registerUser(final User user, final String masterkey) {
		// TODO Auto-generated method stub
		dao.registerUser(user, masterkey);
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void updateByName(final String name, final SimpleUserObject entry) {
		// TODO Auto-generated method stub
		dao.updateByName(name, entry);
	}

	public User getById(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void save(SimpleUserObject entry) {
		dao.save(entry);
		
	}
}
