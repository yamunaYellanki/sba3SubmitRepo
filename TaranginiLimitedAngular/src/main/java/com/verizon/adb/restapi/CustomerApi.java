package com.verizon.adb.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.adb.model.Customer;
import com.verizon.adb.model.Packages;
import com.verizon.adb.service.ContactService;
import com.verizon.adb.service.CustomerService;


@RestController
@CrossOrigin
@RequestMapping("/Customer")
public class CustomerApi {

	@Autowired
	private CustomerService service;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> resp = null;

		
		if (resp == null) {
			Customer c = service.addCustomer(customer);
			if (c == null)
				resp = new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		return resp;
	}
}