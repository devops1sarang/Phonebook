package com.phonebook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.entity.Contact;

public interface PhoneRepository extends JpaRepository<Contact, Serializable> {

}
