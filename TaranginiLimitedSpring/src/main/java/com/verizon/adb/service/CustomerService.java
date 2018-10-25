package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.model.Customer;
import com.verizon.adb.model.Packages;

import com.verizon.adb.model.Packages;

public interface CustomerService {
	
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


	
	Customer addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(int contactId);

	boolean deleteCustomer(long contactId);
	

	
}
