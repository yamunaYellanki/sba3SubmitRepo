package com.verizon.adb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.adb.model.Contact;
import com.verizon.adb.model.Customer;
import com.verizon.adb.model.Packages;

@Repository //TO REGISTER THIS IN bean.xml
public interface ContactRepository extends JpaRepository<Packages, String>{//Entity to be persisted, datatype
	

Packages findBycost(int cost);
Packages findByMaxusage(int maxusage);
Packages findByNet(int net);

}