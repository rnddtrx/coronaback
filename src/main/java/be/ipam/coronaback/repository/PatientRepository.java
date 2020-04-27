package be.ipam.coronaback.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import be.ipam.coronaback.beans.Patient;

public interface PatientRepository extends CrudRepository<Patient, String>{

	Optional<Patient> findByMail(String patientMail);

}
