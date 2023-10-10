package edu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
