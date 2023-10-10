package edu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
