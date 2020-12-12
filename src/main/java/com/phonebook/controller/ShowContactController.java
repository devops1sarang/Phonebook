package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phonebook.dto.ContactDto;
import com.phonebook.service.ContactService;

@Controller
public class ShowContactController {
	@Autowired
	ContactService contactService;

	@GetMapping(value = "/editContact/{id}")
	public String editContact(@PathVariable("id") String id, Model model) {
		ContactDto contactDto = contactService.findContactById(id);
		model.addAttribute("contactDto", contactDto);
		return "index";
	}

	@GetMapping(value = "/deleteContact/{id}")
	public String deleteContact(@PathVariable("id") String id, Model model) {
		contactService.deleteContact(id);
		List<ContactDto> contacts = contactService.getAllContacts();
		model.addAttribute("contactList", contacts);
		return "contactList";
	}
}
