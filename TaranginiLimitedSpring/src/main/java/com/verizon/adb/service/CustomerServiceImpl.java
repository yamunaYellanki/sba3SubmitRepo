package com.verizon.adb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.adb.dao.ContactRepository;
import com.verizon.adb.dao.CustomerRepository;
import com.verizon.adb.dao.CustomerRepository;
import com.verizon.adb.model.Contact;
import com.verizon.adb.model.Customer;
import com.verizon.adb.model.Packages;

@Service 
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository csm;
	

//	@Override
//	public Packages getPackageById(String Title) {
//		Packages packages =null;
////		if(PackagesRepo.existsById(PackagesId)){  // Data base is hit twice while searching and retrieving
////			Packages= PackagesRepo.findById(PackagesId).get();
////		}
//		Optional<Packages> optContact=PackagesRepo.findById(Title);
//		if(optContact.isPresent()){// checking if data is available
//			packages=optContact.get();// retrieve the data using .get
//		}
//		return packages;
//	}
//
//	@Override
//	public List<Packages> getAllPackages() {
//		return PackagesRepo.findAll();
//	}
//
//
//	@Override
//	public Packages findBycost(int cost) {
//		
//		return PackagesRepo.findBycost(cost);
//	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return csm.save(customer);
	}


	@Override
	public List<Customer> getAllCustomers() {
		
		return csm.findAll();
	}
	
	
	
	@Override
	public Customer getCustomerById(int contactId) {
		Customer customer=null;
		
		Optional<Customer>optCust=csm.findById((long) contactId);
		if(optCust.isPresent()){
			customer=optCust.get();
		}
		
		return customer;
	}
	
	@Override
	public boolean deleteCustomer(long contactId) {
		boolean isDeleted=false;
		if(csm.existsById(contactId)){
			csm.deleteById(contactId);
			isDeleted=true;
		}
		return isDeleted;
	}
	

	

//	@Override
//	public Customer addCustomer(Customer contact) {
//		
//		return csm.addCustomer(contact);
//	}



	

//	@Override
//	public Contact addContact(Contact Packages) { // save func will check is data is there(then merge) else persist(add)
//		return PackagesRepo.save(Packages);
//	}
//
//	@Override
//	public Contact updateContact(Contact Packages) {
//		return PackagesRepo.save(Packages);
//	}
//
//	@Override
//	public boolean deleteContact(long PackagesId) {
//		boolean isDeleted=false;
//	
//		if(PackagesRepo.existsById(PackagesId)){
//		
//		PackagesRepo.deleteById(PackagesId);
//		isDeleted=true;}
//		return isDeleted;
//	}
//
//	
//	
//	
//	@Override
//	public boolean existsByMobileNUmber(String mobileNUmber) {
//
//		return PackagesRepo.existsByMobileNUmber(mobileNUmber);
//	}
//
//	
//	@Override
//	public boolean existsByEmailId(String emailId) {
//	
//		return PackagesRepo.existsByEmailId(emailId);
//	}
//
//	@Override
//	public Contact findByMobileNumber(String mobileNUmber) {
//		
//		return PackagesRepo.findByMobileNUmber(mobileNUmber);
//	}
//
//	@Override
//	public Contact findByEmailId(String emailId) {
//		
//		return PackagesRepo.findByEmailId(emailId);
//	}
//
//	@Override
//	public List<Contact> findAllByLastName(String lastName) {
//		
//		return PackagesRepo.findAllByLastName(lastName);
//	}

}
