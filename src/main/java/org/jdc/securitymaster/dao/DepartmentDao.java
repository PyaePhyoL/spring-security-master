package org.jdc.securitymaster.dao;

import org.jdc.securitymaster.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Long> {
}
