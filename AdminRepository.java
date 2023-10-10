package edu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
