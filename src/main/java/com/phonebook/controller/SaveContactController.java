/**
 * @author sarang

 */
package com.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonebook.dto.ContactDto;
import com.phonebook.service.ContactService;

@Controller
public class SaveContactController {
	private static final Logger logger = LoggerFactory.getLogger(SaveContactController.class);
	@Autowired
	ContactService contactService;

	@GetMapping(value = "/")
	public String showForm(Model model) {
		model.addAttribute("contactDto", new ContactDto());
		return "index";
	}

	@PostMapping(value = "/saveContact")
	public String saveOrUpdateContact(@ModelAttribute("contactDto") ContactDto contactDto,
			RedirectAttributes attributes) {
		logger.info("the method is called ....");
		boolean isSaved = contactService.saveOrUpdateContact(contactDto);
		if (isSaved)
			attributes.addFlashAttribute("success", "Contact saved successfully");
		else
			attributes.addFlashAttribute("error", "failed to save contact");
		return "redirect:/";
	}

	@GetMapping(value = "/showAllContacts")
	public String showAllCcntacts(Model model) {
		List<ContactDto> contactList = contactService.getAllContacts();
		model.addAttribute("contactList", contactList);
		return "contactList";
	}
}
