package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.Article;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.Tag;



public interface IProjectDao extends IGeneralDao<Project, Long> {
	public Set<Project> getAllProjects();
	public Project getByIdOverride(final long entityId);
	public Set<Project> getProjectsByTags(Set<Tag> tags);
	public void updateById(final Project project);
	public void deleteProjectArticleById(final long projectId, final long articleId);
	public void addProjectArticle(final long entityId, final Article article);
	public void deleteById(final long entityId);
	public Set<Project> getPaginatedProjectEntries(final int start, final int end);

}
