package de.christian.api.dao.interfaces;

import java.util.Set;

import de.christian.api.model.GuestbookEntry;


public interface IGuestbookEntryDao extends IGeneralDao<GuestbookEntry, Long> {

	public Set<GuestbookEntry> getEntriesByAuthor(final String author);

	public void deleteById(final long entityId);

	public Set<GuestbookEntry> getAllGuestbookEntries();

	public Set<GuestbookEntry> getPaginatedGuestbookEntries(final int start, final int end);
}
