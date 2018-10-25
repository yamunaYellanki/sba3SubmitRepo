package com.verizon.adb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.verizon.adb.model.Customer;


@Repository //TO REGISTER THIS IN bean.xml
public interface CustomerRepository extends JpaRepository<Customer,Long>{//Entity to be persisted, datatype
	

}