package be.ipam.coronaback.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import be.ipam.coronaback.tools.Password;


@Entity
@Table(name="doctor")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Doctor {	
    @Id
    @Column(name="doctorid", nullable=false)
	String id;
    @Column(name="doctorfirstname")  
	String firstName;
    @Column(name="doctorlastname")  
	String lastName;
    @Column(name="doctormail")  
	String mail;
    @Column(name="doctorpw")  
	String pw;
    
    @OneToMany(mappedBy = "doctor") 
	List<Request> requests;
    
    
    
    
	  public Doctor() {
		super();

	}



	public Doctor(String id, String firstName, String lastName, String mail, String pw) {
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
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
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
