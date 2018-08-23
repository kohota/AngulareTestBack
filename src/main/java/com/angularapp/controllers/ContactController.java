package com.angularapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angularapp.dao.ContactRepository;
import com.angularapp.entities.Contact;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value="/Contacts",method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/chercherContactParNom",method=RequestMethod.GET)
	public Page<Contact> chercher(@RequestParam(name="mc",defaultValue="") String motcle,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size){
		return contactRepository.chercher("%"+motcle+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value="/Contact/{id}",method=RequestMethod.GET)
	public Contact get(@PathVariable Long id) {
		
		return contactRepository.getOne(id);
	}
	
	@RequestMapping(value="/Contact/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		
		 contactRepository.deleteById(id);
	}
	
	@RequestMapping(value="/SaveContact",method=RequestMethod.POST)
	public Contact save(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@RequestMapping(value="/Contact/{id}",method=RequestMethod.PUT)
	public Contact update(@PathVariable Long id,@RequestBody Contact contact) {
		contact.setId(id);
		return contactRepository.save(contact);
	}
}
