package org.management.services;

import org.management.entities.RoleEntity;
import org.management.entities.UserEntity;

public interface AccountSerive {
    public UserEntity saveUser(String username, String password, String confirmedPassword);
    public RoleEntity saveRole(RoleEntity role);
    public UserEntity loadUserbyUsername(String username);
    public void addRoleToUser(String username,String roleName);

}
