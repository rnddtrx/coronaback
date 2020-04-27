package be.ipam.coronaback.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import be.ipam.coronaback.beans.Patient;
import be.ipam.coronaback.repository.DoctorRepository;
import be.ipam.coronaback.repository.PatientRepository;




@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  DoctorRepository doctorRepository;
  @Autowired
  PatientRepository patientRepository;
	
  //static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  //static {
  //  inMemoryUserList.add(new JwtUserDetails(1L, "toto",
  //      "$2a$10$Bi7DWJTLZp4fjT8oT96q0erNCzQD5QtR62uT1v7QFWddmp3c9.g.G", "ADMIN"));
  //}

  @Override
  public UserDetails loadUserByUsername(String patientMail) throws UsernameNotFoundException {
	  
	  Optional<Patient> pat = patientRepository.findByMail(patientMail);
	    
	  Optional<JwtUserDetails> user = Optional.empty();
	  
	  if(pat.isPresent()) {
		  user = Optional.of(new JwtUserDetails(pat.get().getId(),pat.get().getMail(),pat.get().getPw(),"ROLE_PATIENT")); 
	  }
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(user -> user.getUsername().equals(username)).findFirst();

	  if (!user.isPresent()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", patientMail));
	  }

	  return user.get();
  }

}