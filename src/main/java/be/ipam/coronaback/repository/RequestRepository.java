package be.ipam.coronaback.repository;

import org.springframework.data.repository.CrudRepository;

import be.ipam.coronaback.beans.Request;

public interface RequestRepository extends CrudRepository<Request, String>{

}
