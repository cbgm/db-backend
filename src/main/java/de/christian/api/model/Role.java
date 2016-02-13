package de.christian.api.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SuppressWarnings("serial")
@Entity
@Table(name="user_roles")
public class Role implements Model {

	@Id
	@GeneratedValue
	@Column(name="user_role_id")
	private String user_role_id;
	
	@Column(name="role",nullable=false,length=50)
	private String role;

	@ManyToOne
    @JoinColumn(name="username")
    private User user;

	public Role(){
		
	}

	public String getRoleId() {
		return user_role_id;
	}

	public void setRoleId(final String user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
