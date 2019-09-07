package com.arthuro.api.security.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.arthuro.api.security.enums.ProfileEnum;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 306411570471828345L;

	private UUID id;
	private String email;
	private String pass;
	private ProfileEnum profile;

	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	@Column(name = "pass", nullable = false)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
