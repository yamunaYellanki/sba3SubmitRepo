package com.verizon.adb.model;


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
@Table(name="Customer")
public class Customer {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long contactId;
	
	@NotEmpty(message="firstName cant be empty")
	@Size(min=5,max=15,message="Give Caps casing within 5 - 15 characters")
	@Column(name="fnm")
	private String firstName;
	
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="date")
	private Date date;
	

	@Column(name="Title")
	@NotNull
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotNull(message="email is required")
	@Email
	@Column(name="mail")
	private String emailId;
	
	@NotEmpty(message="cant be null")
	@Pattern(regexp="\\d{10}", message="you are in India remember")
	@Column(name="mno")
	private String mobileNUmber;
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	
	
	public Customer() {
		
	}
	public Customer(
			@NotEmpty(message = "firstName cant be empty") @Size(min = 5, max = 15, message = "Give Caps casing within 5 - 15 characters") String firstName,
			Date date, @NotNull String title, @NotNull(message = "email is required") @Email String emailId,
			@NotEmpty(message = "cant be null") @Pattern(regexp = "\\d{10}", message = "you are in India remember") String mobileNUmber) {
		super();
		this.firstName = firstName;
		this.date = date;
		this.title = title;
		this.emailId = emailId;
		this.mobileNUmber = mobileNUmber;
	}



}
