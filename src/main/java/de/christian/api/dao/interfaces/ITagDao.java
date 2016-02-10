package de.christian.api.dao.interfaces;

import java.util.Set;


import de.christian.api.model.Tag;


public interface ITagDao extends IGeneralDao<Tag, Long> {
	public Set<Tag> getAllTags();
	
	public void deleteById(final long entityId);
}
