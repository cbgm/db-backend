package de.christian.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="guestbookentry")
public class GuestbookEntry {
	
	@Id
	@Column(name="guestbookEntryId")
	@GeneratedValue
	private Long guestbookEntryId;
	
	@Column(name="author")
	private String author;
	
	@Column(name="content")
	private String content;
	
	@Column(name="date")
	private String date;
	
	public GuestbookEntry(){
		
	}
	
	public GuestbookEntry(final String author, final String content, final String date){
		this.author = author;
		this.content = content;
		this.date = date;
	}

	public Long getGuestbookId() {
		return guestbookEntryId;
	}

	public void setGuestbookId(final Long guestbookEntryId) {
		this.guestbookEntryId = guestbookEntryId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}
	
	public String toString(){
		String temp = 
			"[GuestbookEntry:\n" 
			+ "-author | " + author +"\n"
			+ "-date | " + date.toString() +"\n"
			+ "-content | " + content +"\n"
			+"\n]";
		return temp;
		
	}
}
