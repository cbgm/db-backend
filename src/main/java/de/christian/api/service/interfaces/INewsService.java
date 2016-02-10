package de.christian.api.service.interfaces;

import java.util.Set;

import de.christian.api.model.News;
import de.christian.api.model.Tag;


public interface INewsService extends IGeneralService<News, Long> {
	public Set<News> getAllNews();
	
	public Set<News> getNewsByTags(final Set<Tag> tags);
	
	public void deleteById(final long entityId);
	
	public News getByIdOverride(final long entityId);
	
	public Set<News> getPaginatedNewsEntries(final int start, final int end);
	
}
