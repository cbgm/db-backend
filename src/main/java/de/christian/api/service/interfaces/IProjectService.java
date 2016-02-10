package de.christian.api.service.interfaces;

import java.util.Set;

import de.christian.api.model.Article;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.Tag;


public interface IProjectService extends IGeneralService<Project, Long> {
	public Set<Project> getAllProjects();
	public Project getByIdOverride(final long entityId);
	public void updateById(final Project project);
	public void deleteProjectArticleById(final long projectId, final long articleId);
	public void addProjectArticle(final long entityId, final Article article);
	public void deleteById(final long entityId);
	public Set<Project> getPaginatedProjectEntries(final int start, final int end);
}
