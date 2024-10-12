package org.jdc.securitymaster.dao;

import org.jdc.securitymaster.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
