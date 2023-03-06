package com.bikkadit.PhoneBookAppliction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.PhoneBookAppliction.Entity.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
