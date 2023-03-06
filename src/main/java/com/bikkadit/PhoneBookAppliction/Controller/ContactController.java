package com.bikkadit.PhoneBookAppliction.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.PhoneBookAppliction.Entity.Contact;
import com.bikkadit.PhoneBookAppliction.Service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping(value="/saveContact",consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		boolean saveContact = contactService.saveContact(contact);
		if(saveContact==true) {
			String msg="contact saved successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			String msg="contact not saved";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/getAllContact")
	public ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> allContact = contactService.getAllContact();
		return new ResponseEntity<List<Contact>>(allContact, HttpStatus.OK);
	}
	
	@GetMapping(value="/getContactById/{Id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer Id){
		Contact findById = contactService.findContactById(Id);
		return new ResponseEntity<Contact>(findById, HttpStatus.OK);
	}
}
