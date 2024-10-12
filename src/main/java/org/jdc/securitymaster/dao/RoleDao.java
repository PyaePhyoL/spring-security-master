package org.jdc.securitymaster.dao;

import org.jdc.securitymaster.security.ds.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Long> {
}
