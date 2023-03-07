package com.bikkadit.PhoneBookAppliction.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping(value="/updateContact", consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		boolean updateContact = contactService.updateContact(contact);
		if(updateContact) {
			String msg="contact updated successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			String msg="contact not updated";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/deleteContactById/{Id}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer Id){
		boolean deleteById = contactService.deleteById(Id);
		if(deleteById==true) {
			return new ResponseEntity<String>("contact is deleted successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("contact is not deleted", HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
