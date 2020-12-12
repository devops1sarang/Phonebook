/**
 * @author Sarang
 */
package com.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.dto.ContactDto;
import com.phonebook.entity.Contact;
import com.phonebook.repository.PhoneRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public boolean saveOrUpdateContact(ContactDto contactDto) {
		Contact contact = new Contact();
		contact.setEmail(contactDto.getEmail());
		contact.setName(contactDto.getName());
		contact.setPhoneNo(contactDto.getPhoneNo());
		if (contactDto.getId() != null) {
			System.out.println(contactDto.getId());
			contact.setId(contactDto.getId());
		}
		contact = phoneRepository.save(contact);
		return contact != null;
	}

	@Override
	public List<ContactDto> getAllContacts() {
		List<Contact> contacts = phoneRepository.findAll();
		List<ContactDto> contactDtos = new ArrayList<>(contacts.size());
		for (Contact contact : contacts) {
			ContactDto contactDto = new ContactDto();
			contactDto.setId(contact.getId());
			contactDto.setName(contact.getName());
			contactDto.setEmail(contact.getEmail());
			contactDto.setPhoneNo(contact.getPhoneNo());
			contactDtos.add(contactDto);
		}
		return contactDtos;
	}

	@Override
	public ContactDto findContactById(String id) {
		Optional<Contact> contact = phoneRepository.findById(id);

		if (contact.isPresent()) {
			Contact ct = contact.get();
			ContactDto dto = new ContactDto();
			dto.setId(ct.getId());
			dto.setName(ct.getName());
			dto.setEmail(ct.getEmail());
			dto.setPhoneNo(ct.getPhoneNo());
			return dto;
		}
		return null;
	}

	@Override
	public boolean deleteContact(String id) {
		try {
			phoneRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("error while deleting record " + e);
			return false;
		}
		return true;
	}

}
