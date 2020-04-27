package be.ipam.coronaback.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import be.ipam.coronaback.tools.Password;



@Entity
@Table(name="patient")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Patient {
    @Id
    @Column(name="patientid", nullable=false)
	String id;
    @Column(name="patientfirstname")
	String firstName;
    @Column(name="patientlastname")
	String lastName;
    @Column(name="patientmail")
	String mail;
    @Column(name="patientpw")
	String pw;
    
    @OneToOne(mappedBy = "patient") 
	Request request;
	
    
    
	public Patient() {
		super();

	}

	public Patient(String id, String firstName, String lastName, String mail, String pw) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		setPw(pw);

	}

	public String getId() {
		return id;
	}
	  
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		Password pwo = new Password(pw);
		this.pw = pwo.firstHash();
	}
	
	

}
