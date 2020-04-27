package be.ipam.coronaback;



import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import be.ipam.coronaback.beans.Doctor;
import be.ipam.coronaback.beans.Patient;
import be.ipam.coronaback.beans.Request;
import be.ipam.coronaback.repository.DoctorRepository;
import be.ipam.coronaback.repository.PatientRepository;
import be.ipam.coronaback.repository.RequestRepository;



@Component
public class AppStartRunner implements ApplicationRunner {
    @Autowired
    DoctorRepository docRep;
    @Autowired
    PatientRepository patRep;
    @Autowired
    RequestRepository reqRep;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {

	//Patient p = new Patient("aaa","toto", "toto", "toto@toto.com", "toto");
	//patRep.save(p);
	//Doctor d = new Doctor("daaa","dtoto", "dtoto", "dtoto@toto.com", "dtoto");
	//docRep.save(d);
	//Request r = new Request("raaa", p, d, new Date(), false, false, false, false);
	//reqRep.save(r);
	
	//p.setRequest(r);
	//List<Request> lr = new ArrayList<Request>();
	//lr.add(r);
	//d.setRequests(lr);
	//patRep.save(p);
	//docRep.save(d);

		
	}
  
        
        
   

}