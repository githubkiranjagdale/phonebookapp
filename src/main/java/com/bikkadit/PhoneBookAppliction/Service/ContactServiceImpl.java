package com.bikkadit.PhoneBookAppliction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.PhoneBookAppliction.Entity.Contact;
import com.bikkadit.PhoneBookAppliction.Repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		if(save!= null) {
			return true;
		}else {
		return false;
		}
	}

}
