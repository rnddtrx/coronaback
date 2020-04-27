package be.ipam.coronaback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.coronaback.beans.Patient;
import be.ipam.coronaback.repository.PatientRepository;


@RestController
public class PatientController {
	
	//You can use a service
	@Autowired
	PatientRepository patRep;
    @GetMapping(value="/patients", produces = "application/json")
    public List<Patient> students() {
    	List<Patient> patList = (List<Patient>) patRep.findAll();
        return patList;
    }
}
