package edu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
