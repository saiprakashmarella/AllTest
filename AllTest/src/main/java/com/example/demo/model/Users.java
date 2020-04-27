package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name ="Users")
@EntityListeners(AuditingEntityListener.class)
public class Users {
	
	public Users() {
		
	}
	
	@Id
	private long id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users(long id, @NotBlank String username, @NotBlank String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	

}
