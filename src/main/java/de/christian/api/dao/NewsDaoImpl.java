package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.INewsDao;
import de.christian.api.model.News;
import de.christian.api.model.Tag;



@Repository("newsDao")
public class NewsDaoImpl extends GeneralDaoImpl<News, Long> implements INewsDao {

	@SuppressWarnings("unchecked")
	public Set<News> getAllNews() {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM News n ORDER BY n.newsId ASC");
		ArrayList<News> array = new ArrayList<News>(q.list());

		for (News n: array) {
			ArrayList<Tag> tags =  new  ArrayList<Tag>(n.getTags());
			n.setTags(new HashSet<Tag>(tags));
		}
		return new HashSet<News>(array);
	}

	@SuppressWarnings("unchecked")
	public Set<News> getNewsByTags(final Set<Tag> tags) {
		
		
		String likeBuilder ="";
		Iterator<Tag> iter = tags.iterator();
		while (iter.hasNext()) {
			likeBuilder += " t.name LIKE '" + iter.next().getName() + "'";
			if(iter.hasNext()){
				likeBuilder += " AND";
			}
		}
		
		String query ="SELECT n FROM News n LEFT JOIN n.tags t WHERE" + likeBuilder;
		return new HashSet<News>(sessionFactory.getCurrentSession().createQuery(query).list()); 
	}

	//NOTE!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//for loading other objects set the news tags by loading them sepeartly but also set the refernce form tags to new to null, else it will be a persistence set!!!!!!!!!!!!!!!!!
	@SuppressWarnings("unchecked")
	public Set<News> getPaginatedNewsEntries(final int start, final int end) {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM News n ORDER BY n.newsId ASC");
		ArrayList<News> array = new ArrayList<News>(q.list());

		ArrayList<News> temp = new ArrayList<News>();
		int arrayStart = (array.size() - 1) - start;
		int arrayEnd = (array.size() - 1) - end;
		for (int x = arrayStart; x > arrayEnd; x--) {
			if (x < 0) {
				break;
			}
			ArrayList<Tag> tags =  new  ArrayList<Tag>(array.get(x).getTags());
			array.get(x).setTags(new HashSet<Tag>(tags));
			temp.add(array.get(x));

		}
		return new HashSet<News>(temp);
	}

	@SuppressWarnings("unchecked")
	public void deleteById(final long entityId) {
		News entry = new News();
		entry.setNewsId(entityId);
		this.sessionFactory.getCurrentSession().delete(entry);
	}

	@Override
	protected Class<News> getEntityClass() {
		return News.class;
	}
	
	@SuppressWarnings("unchecked")
	public News getByIdOverride(final long entityId) {
		Query q= sessionFactory.getCurrentSession().createQuery("from News where newsId=:id");
		q.setParameter("id", entityId);
		News news = (News) q.uniqueResult();
		ArrayList<Tag> tags =  new  ArrayList<Tag>(news.getTags());
		news.setTags(new HashSet<Tag>(tags));
		return news;
	}

}
