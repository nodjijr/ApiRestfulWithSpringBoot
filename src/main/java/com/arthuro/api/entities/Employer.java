package com.arthuro.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.arthuro.api.enums.ProfileEnum;



@Entity
@Table(name = "employer")
public class Employer implements Serializable{

	private static final long serialVersionUID = -9169670240854558399L;


	private UUID id;
	private String name;
	private String email;
	private String pass;
	private String code;
	private BigDecimal hour_value;
	private BigDecimal hour_worked;
	private BigDecimal hour_lunch;
	private ProfileEnum profile;
	private Date date_created;
	private Date date_updated;
	private Company company;
	private List<Register> registers;
	
	public Employer() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email", nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="pass", nullable=false)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	@Column(name="code", nullable=false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="hour_value", nullable=true)
	public BigDecimal getHourValue() {
		return hour_value;
	}

	public void setHourValue(BigDecimal hourValue) {
		this.hour_value = hourValue;
	}

	@Column(name="hour_worked", nullable=true)
	public BigDecimal getHourWorked() {
		return hour_worked;
	}

	public void setHourWorked(BigDecimal hourWorked) {
		this.hour_worked = hourWorked;
	}

	@Column(name="hour_lunch", nullable=true)
	public BigDecimal getHourLunch() {
		return hour_lunch;
	}

	public void setHourLunch(BigDecimal hourLunch) {
		this.hour_lunch = hourLunch;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="profile", nullable=false)
	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	@Column(name="date_created", nullable=false)
	public Date getDateCreated() {
		return date_created;
	}

	public void setDateCreated(Date dateCreated) {
		this.date_created = dateCreated;
	}

	@Column(name="date_updated", nullable=false)
	public Date getDateUpdated() {
		return date_updated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.date_updated = dateUpdated;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(mappedBy="employer", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

	@PreUpdate
	public void preUpdate() {
		date_updated = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date actual = new Date();
		date_created = actual;
		date_updated = actual;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", code=" + code
				+ ", hourValue=" + hour_value + ", hourWorked=" + hour_worked + ", hourLunch=" + hour_lunch + ", profile="
				+ profile + ", dateCreated=" + date_created + ", dateUpdated=" + date_updated + "]";
	}	
	
}
