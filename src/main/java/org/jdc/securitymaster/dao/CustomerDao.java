package org.jdc.securitymaster.dao;

import org.jdc.securitymaster.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
