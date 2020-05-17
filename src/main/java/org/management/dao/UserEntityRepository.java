package org.management.dao;

import org.management.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    public UserEntity findUserEntitiesByUsername(String username);
}
