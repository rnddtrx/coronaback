package be.ipam.coronaback.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="request")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Request {
    @Id
    @Column(name="requestid", nullable=false)
	String id;
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientid") 
	Patient patient;  
    @ManyToOne
    @JoinColumn(name="doctorid")
	Doctor doctor;
    @Column(name="requestdate")  
	Date date;
    @Column(name="requestcough")
	boolean cough;
    @Column(name="requestfever")
	boolean fever;
    @Column(name="requestdifficultytobreath")
	boolean difficutyToBreath;
    @Column(name="requestcovidstatus")
	boolean covidStatus;
	  
    
	  
	  public Request() {
		super();
	}
	  
	  
	public Request(String id, Patient patient, Doctor doctor, Date date, boolean cough, boolean fever,
			boolean difficutyToBreath, boolean covidStatus) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.cough = cough;
		this.fever = fever;
		this.difficutyToBreath = difficutyToBreath;
		this.covidStatus = covidStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCough() {
		return cough;
	}
	public void setCough(boolean cough) {
		this.cough = cough;
	}
	public boolean isFever() {
		return fever;
	}
	public void setFever(boolean fever) {
		this.fever = fever;
	}
	public boolean isDifficutyToBreath() {
		return difficutyToBreath;
	}
	public void setDifficutyToBreath(boolean difficutyToBreath) {
		this.difficutyToBreath = difficutyToBreath;
	}
	public boolean isCovidStatus() {
		return covidStatus;
	}
	public void setCovidStatus(boolean covidStatus) {
		this.covidStatus = covidStatus;
	}

}