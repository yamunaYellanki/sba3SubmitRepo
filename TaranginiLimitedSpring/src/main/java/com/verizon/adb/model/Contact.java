package com.verizon.adb.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="Contacts")
public class Contact {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long contactId;
	
	@NotEmpty(message="firstName cant be empty")
	@Size(min=5,max=15,message="Give Caps casing within 5 - 15 characters")
	private String firstName;
	
	
	@DateTimeFormat(iso=ISO.TIME)
	@NotNull(message="Pick a slot")
	@Column(name="timing")
	private Time timing;
	
	@NotNull(message="email is required")
	@Email
	private String emailId;
	
	@NotEmpty(message="cant be null")
	@Pattern(regexp="\\d{10}", message="you are in India remember")
	@Column(name="mno")
	private String mobileNUmber;
	

	
	public Contact( String firstName,  Time timing, String emailId,
			String mobileNUmber) {
		super();
		
		this.firstName = firstName;
		
		this.timing = timing;
		this.emailId = emailId;
		this.mobileNUmber = mobileNUmber;
		
	}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Time getTiming() {
		return timing;
	}
	public void setTiming(Time timing) {
		this.timing = timing;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNUmber() {
		return mobileNUmber;
	}
	public void setMobileNUmber(String mobileNUmber) {
		this.mobileNUmber = mobileNUmber;
	}
	

}
