package com.bikkadit.PhoneBookAppliction.Service;

import java.util.List;

import com.bikkadit.PhoneBookAppliction.Entity.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);
	
	List<Contact> getAllContact();
	
	Contact findContactById(Integer Id);
	
	boolean updateContact(Contact contact);
	
	boolean deleteById(Integer Id);
}
