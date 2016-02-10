package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IUserDao;
import de.christian.api.model.News;
import de.christian.api.model.Project;
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
	public User getById(final Long entityId) {
		// TODO Auto-generated method stub
		return dao.getById(entityId);
	}
	
	

}
