package edu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
