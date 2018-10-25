package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.model.Customer;
import com.verizon.adb.model.Packages;
import com.verizon.adb.model.Packages;

public interface ContactService {
	Packages getPackageById(String Title);
	List<Packages> getAllPackages();
//	Contact addContact(Contact contact);
//	Contact updateContact(Contact contact);
//	boolean deleteContact(long contactId);
//	
//
//	boolean existsByMobileNUmber(String mobileNUmber);
//	boolean existsByEmailId(String emailId);
//	Contact findByMobileNumber(String mobileNUmber);
//	Contact findByEmailId(String emailId);
//	List<Contact> findAllByLastName(String lastName);

	Packages findBycost(int cost);
	Packages findByNet(int net);
	Packages findByMaxUsage(int maxusage);
	
}
