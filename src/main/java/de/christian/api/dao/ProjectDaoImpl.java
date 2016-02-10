package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IProjectDao;
import de.christian.api.model.Article;
import de.christian.api.model.News;
import de.christian.api.model.Project;
import de.christian.api.model.Tag;



@Repository("projectDao")
public class ProjectDaoImpl extends GeneralDaoImpl<Project, Long> implements IProjectDao {

	@SuppressWarnings("unchecked")
	public Set<Project> getAllProjects() {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM Project p ORDER BY p.projectId ASC");
		ArrayList<Project> array = new ArrayList<Project>(q.list());

		for (Project p: array) {
			ArrayList<Tag> tags =  new  ArrayList<Tag>(p.getTags());
			ArrayList<Article> articles =  new  ArrayList<Article>(p.getArticles());
			for(Tag t: tags) {
				t.setNews(null);
				t.setProjects(null);
			}
			p.setTags(new HashSet<Tag>(tags));
			p.setArticles(new HashSet<Article>(articles));
		}
		return new HashSet<Project>(array);
	}

	@SuppressWarnings("unchecked")
	public Set<Project> getProjectsByTags(final Set<Tag> tags) {
		String likeBuilder ="";
		Iterator<Tag> iter = tags.iterator();
		while (iter.hasNext()) {
			likeBuilder += " t.name LIKE '" + iter.next().getName() + "'";
			if(iter.hasNext()){
				likeBuilder += " AND";
			}
		}
		
		String query ="SELECT p FROM Project p LEFT JOIN p.tags t WHERE" + likeBuilder;
		return new HashSet<Project>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	@Override
	protected Class<Project> getEntityClass() {
		return Project.class;
	}

	public Project getByIdOverride(long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Project where projectId=:id");
		q.setParameter("id", entityId);
		Project project = (Project) q.uniqueResult();
		ArrayList<Article> articles =  new  ArrayList<Article>(project.getArticles());
		ArrayList<Tag> tags =  new  ArrayList<Tag>(project.getTags());
		project.setTags(new HashSet<Tag>(tags));
		project.setArticles(new HashSet<Article>(articles));
		return project;
	}

	public void deleteProjectArticleById(final long projectId, final long articleId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Project where projectId=:id");
		q.setParameter("id", projectId);
		Project tempProject = (Project) q.uniqueResult();
		ArrayList<Article> articles =  new  ArrayList<Article>(tempProject.getArticles());
		Article tempArticle = null;
		for(Article a : articles) {
			if(articleId == a.getArticleId()) {
				tempArticle = a;
				break;
			}
		}
		tempArticle.setProject(null);
		tempArticle.setTags(null);
		this.sessionFactory.getCurrentSession().delete(tempArticle);
		tempProject.getArticles().remove(tempArticle);
		
	}

	public void addProjectArticle(long entityId, Article article) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Project where projectId=:id");
		q.setParameter("id", entityId);
		Project project = (Project) q.uniqueResult();
		ArrayList<Article> articles =  new  ArrayList<Article>(project.getArticles());
		article.setProject(project);
		articles.add(article);
		project.setArticles(new HashSet<Article>(articles));		
	}

	public void updateById(Project project) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Project where projectId=:id");
		q.setParameter("id", project.getProjectId());
		Project tempProject = (Project) q.uniqueResult();
		tempProject.setDescription(project.getDescription());
		tempProject.setTitle(project.getTitle());
		tempProject.setTags(project.getTags());
	}

	public void deleteById(long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from Project where projectId=:id");
		q.setParameter("id", entityId);
		Project tempProject = (Project) q.uniqueResult();
		ArrayList<Article> articles =  new  ArrayList<Article>(tempProject.getArticles());
		tempProject.setArticles(null);
		tempProject.setTags(null);
		for(Article a : articles) {
			a.setTags(null);
			a.setProject(null);
			this.sessionFactory.getCurrentSession().delete(a);
		}
		
		this.sessionFactory.getCurrentSession().delete(tempProject);
		
	}

	public Set<Project> getPaginatedProjectEntries(int start, int end) {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM Project n ORDER BY n.projectId ASC");
		ArrayList<Project> array = new ArrayList<Project>(q.list());
		ArrayList<Project> temp = new ArrayList<Project>();

		int arrayStart = (array.size() - 1) - start;
		int arrayEnd = (array.size() - 1) - end;

		for (int x = arrayStart; x > arrayEnd; x--) {
			if (x < 0) {
				break;
			}
			ArrayList<Tag> tags =  new  ArrayList<Tag>(array.get(x).getTags());
			array.get(x).setTags(new HashSet<Tag>(tags));

			ArrayList<Article> articles =  new  ArrayList<Article>(array.get(x).getArticles());
			array.get(x).setArticles(new HashSet<Article>(articles));
			temp.add(array.get(x));

		}
		return new HashSet<Project>(temp);
	}

}
