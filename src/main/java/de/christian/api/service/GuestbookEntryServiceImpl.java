package de.christian.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.christian.api.dao.interfaces.IGuestbookEntryDao;
import de.christian.api.model.GuestbookEntry;
import de.christian.api.service.interfaces.IGuestbookEntryService;



@Service("guestbookEntryService")
public class GuestbookEntryServiceImpl implements IGuestbookEntryService {
	
	@Autowired
	private IGuestbookEntryDao dao;

	@Transactional
	public void save(final GuestbookEntry entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	@Transactional
	public void update(final GuestbookEntry entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Transactional
	public void delete(final GuestbookEntry entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}

	@Transactional
	public GuestbookEntry getById(final Long entityId) {
		// TODO Auto-generated method stub
		return dao.getById(entityId);
	}

	@Transactional
	public Set<GuestbookEntry> getEntriesByAuthor(final String author) {
		// TODO Auto-generated method stub
		return dao.getEntriesByAuthor(author);
	}

	@Transactional
	public Set<GuestbookEntry> getAllGuestbookEntries() {
		// TODO Auto-generated method stub
		return dao.getAllGuestbookEntries();
	}

	@Transactional
	public Set<GuestbookEntry> getPaginatedGuestbookEntries(final int start, final int end) {
		// TODO Auto-generated method stub
		return dao.getPaginatedGuestbookEntries(start, end);
	}

	@Transactional
	public void deleteById(final long entityId) {
		dao.deleteById(entityId);
		
	}

}
