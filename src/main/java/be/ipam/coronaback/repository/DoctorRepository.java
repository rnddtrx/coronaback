package be.ipam.coronaback.repository;

import org.springframework.data.repository.CrudRepository;

import be.ipam.coronaback.beans.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, String> {

}
