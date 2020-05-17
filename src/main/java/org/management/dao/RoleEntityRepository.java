package org.management.dao;

import org.management.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
    public RoleEntity findRoleEntityByRoleName(String roleName);
}
