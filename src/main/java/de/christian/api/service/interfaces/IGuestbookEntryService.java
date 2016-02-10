package de.christian.api.service.interfaces;

import java.util.Set;

import de.christian.api.model.GuestbookEntry;


public interface IGuestbookEntryService extends IGeneralService<GuestbookEntry, Long> {

	public Set<GuestbookEntry> getEntriesByAuthor(final String author);

	public void deleteById(final long entityId);

	public Set<GuestbookEntry> getAllGuestbookEntries();

	public Set<GuestbookEntry> getPaginatedGuestbookEntries(final int start, final int end);
}
