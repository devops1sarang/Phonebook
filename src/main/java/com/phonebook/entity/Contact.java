package com.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CONTACT_DETAILS")
public class Contact {
	@Id
	@GenericGenerator(name = "gen1", strategy = "uuid")
	@GeneratedValue(generator = "gen1")
	private String id;
	@Column(name = "CONTACT_NAME")
	private String name;
	@Column(name = "CONTACT_EMAIL")
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
