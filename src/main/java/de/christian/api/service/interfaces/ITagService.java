package de.christian.api.service.interfaces;

import java.util.Set;

import de.christian.api.model.Tag;


public interface ITagService extends IGeneralService<Tag, Long> {
	public Set<Tag> getAllTags();

	public void deleteById(final long entityId);
}
