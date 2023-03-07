package com.bikkadit.PhoneBookAppliction.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = contactRepo.findAll();
		Stream<Contact> stream = contacts.stream();
		Stream<Contact> filter = stream.filter(contact->contact.getActiveSwitch()=='Y');
		List<Contact> collect = filter.collect(Collectors.toList());
		return collect;
	}
	@Override
	public Contact findContactById(Integer Id) {
		Contact contact = contactRepo.findById(Id).get();
		return contact;
	}
	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		if(save!=null) {
			return true;
		}else {
		return false;
		}
	}
	@Override
	public boolean deleteById(Integer Id) {
		Optional<Contact> contact = contactRepo.findById(Id);
			
		if(contact.isPresent()) {
			Contact contact2 = contact.get();
			contact2.setActiveSwitch('N');
			contactRepo.save(contact2);
			return true;
		}else {
		return false;
		}
	}
	

}
