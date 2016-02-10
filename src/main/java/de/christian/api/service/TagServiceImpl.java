package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.ITagDao;
import de.christian.api.model.Tag;
import de.christian.api.service.interfaces.ITagService;



@Service("tagService")
public class TagServiceImpl implements ITagService {
	
	@Autowired
	private ITagDao dao;

	@Transactional
	public void save(Tag entity) {
		dao.save(entity);
		
	}

	@Transactional
	public void update(Tag entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Transactional
	public void delete(Tag entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Transactional
	public Tag getById(Long entityId) {
		// TODO Auto-generated method stub
		return dao.getById(entityId);
	}

	@Transactional
	public Set<Tag> getAllTags() {
		// TODO Auto-generated method stub
		return dao.getAllTags();
	}

	@Transactional
	public void deleteById(long entityId) {
		dao.deleteById(entityId);
		
	}
}
