package com.bikkadit.PhoneBookAppliction.Service;

import java.util.List;

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
		List<Contact> findAll = contactRepo.findAll();
		return findAll;
	}
	@Override
	public Contact findContactById(Integer Id) {
		Contact contact = contactRepo.findById(Id).get();
		return contact;
	}
	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		if(save==null) {
			return false;
		}else {
		return true;
		}
	}
	@Override
	public boolean deleteById(Integer Id) {
		Contact contact = contactRepo.findById(Id).get();
		if(contact!=null) {
			contactRepo.existsById(Id);
			return true;
		}else {
		return false;
		}
	}
	

}
