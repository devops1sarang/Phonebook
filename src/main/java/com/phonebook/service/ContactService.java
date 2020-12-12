package com.phonebook.service;

import java.util.List;

import com.phonebook.dto.ContactDto;

public interface ContactService {
	public boolean saveOrUpdateContact(ContactDto contactDto);

	public List<ContactDto> getAllContacts();

	public ContactDto findContactById(String id);

	public boolean deleteContact(String id);

}
