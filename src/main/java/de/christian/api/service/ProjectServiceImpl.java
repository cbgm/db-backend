package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IProjectDao;
import de.christian.api.model.Article;
import de.christian.api.model.Project;
import de.christian.api.model.Tag;
import de.christian.api.service.interfaces.IProjectService;


@Service("projectService")
public class ProjectServiceImpl implements IProjectService{

	@Autowired
	private IProjectDao dao;
	
	@Transactional
	public void save(Project entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	@Transactional
	public void update(Project entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Transactional
	public void delete(Project entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Transactional
	public Project getById(Long entityId) {
		// TODO Auto-generated method stub
		return dao.getById(entityId);
	}

	@Transactional
	public Set<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return dao.getAllProjects();
	}


	@Transactional
	public Set<Project> getProjectsByTags(Set<Tag> tags) {
		// TODO Auto-generated method stub
		return dao.getProjectsByTags(tags);
	}

	@Transactional
	public Project getByIdOverride(long entityId) {
		// TODO Auto-generated method stub
		return dao.getByIdOverride(entityId);
	}

	@Transactional
	public void addProjectArticle(long entityId, Article article) {
		dao.addProjectArticle(entityId, article);
		
	}

	@Transactional
	public void updateById(Project project) {
		dao.updateById(project);
	}
	
	@Transactional
	public void deleteById(long entityId) {
		dao.deleteById(entityId);
		
	}

	@Transactional
	public void deleteProjectArticleById(long projectId, long articleId) {
		dao.deleteProjectArticleById(projectId, articleId);
		
	}

	@Transactional
	public Set<Project> getPaginatedProjectEntries(int start, int end) {
		return dao.getPaginatedProjectEntries(start, end);
	}

}
