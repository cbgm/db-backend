package de.christian.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Model {
	@Id
	@GeneratedValue
	protected Long id;
	
}
