package de.christian.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import de.christian.api.dao.interfaces.IGuestbookEntryDao;
import de.christian.api.model.GuestbookEntry;


@Repository("guestbookEntryDao")
public class GuestbookEntryDaoImpl extends GeneralDaoImpl< GuestbookEntry, Long> implements IGuestbookEntryDao {

	@SuppressWarnings("unchecked")
	public Set<GuestbookEntry> getEntriesByAuthor(String author) {
		String query = "FROM GuestbookEntry WHERE author LIKE '" + author + "'";
		return new HashSet<GuestbookEntry>(sessionFactory.getCurrentSession().createQuery(query).list());
	}

	@SuppressWarnings("unchecked")
	public Set<GuestbookEntry> getAllGuestbookEntries() {
		String query = "FROM GuestbookEntry g";
		return new HashSet<GuestbookEntry>(sessionFactory.getCurrentSession().createQuery(query).list());
	}

	@SuppressWarnings("unchecked")
	public Set<GuestbookEntry> getPaginatedGuestbookEntries(final int start, final int end) {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM GuestbookEntry g ORDER BY g.guestbookEntryId ASC");
		ArrayList<GuestbookEntry> array = new ArrayList<GuestbookEntry>(q.list());
		ArrayList<GuestbookEntry> temp = new ArrayList<GuestbookEntry>();
		int arrayStart = (array.size() - 1) - start;
		int arrayEnd = (array.size() - 1) - end;
		for (int x = arrayStart; x > arrayEnd; x--) {
			if (x < 0) {
				break;
			}
			temp.add(array.get(x));

		}
		return new HashSet<GuestbookEntry>(temp);
	}
	
	
	@SuppressWarnings("unchecked")
	public void deleteById(final long entityId) {
		GuestbookEntry entry = new GuestbookEntry();
		entry.setGuestbookId(entityId);
		this.sessionFactory.getCurrentSession().delete(entry);
	}

	@Override
	protected Class<GuestbookEntry> getEntityClass() {
		// TODO Auto-generated method stub
		return GuestbookEntry.class;
	}



}
