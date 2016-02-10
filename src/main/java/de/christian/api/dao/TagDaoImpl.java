package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.ITagDao;
import de.christian.api.model.Tag;




@Repository("tagDao")
public class TagDaoImpl extends GeneralDaoImpl<Tag, Long> implements ITagDao {

	@SuppressWarnings("unchecked")
	public Set<Tag> getAllTags() {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM Tag");
		ArrayList<Tag> array = new ArrayList<Tag>(q.list());
		return new HashSet<Tag>(array);
	}

	@Override
	protected Class<Tag> getEntityClass() {
		return Tag.class;
	}

	public void deleteById(long entityId) {
		Tag entry = new Tag();
		entry.setTagId(entityId);
		this.sessionFactory.getCurrentSession().delete(entry);
		
	}

}
