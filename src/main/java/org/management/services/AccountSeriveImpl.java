package org.management.services;

import org.management.dao.RoleEntityRepository;
import org.management.dao.UserEntityRepository;
import org.management.entities.RoleEntity;
import org.management.entities.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountSeriveImpl implements AccountSerive {

    private UserEntityRepository userEntityRepository;
    private RoleEntityRepository roleEntityRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public AccountSeriveImpl(UserEntityRepository userEntityRepository, RoleEntityRepository roleEntityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.roleEntityRepository = roleEntityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserEntity saveUser(String username, String password, String confirmedPassword) {

        UserEntity user=userEntityRepository.findUserEntitiesByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw  new RuntimeException("You must to confirm your password");

        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(bCryptPasswordEncoder.encode(password));
        userEntity.setActivated(true);
        userEntityRepository.save(userEntity);

        addRoleToUser(username,"USER");

        return userEntity;
    }

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        return roleEntityRepository.save(role);
    }

    @Override
    public UserEntity loadUserbyUsername(String username) {
        return userEntityRepository.findUserEntitiesByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserEntity user=userEntityRepository.findUserEntitiesByUsername(username);
        RoleEntity role=roleEntityRepository.findRoleEntityByRoleName(roleName);
        user.getRoles().add(role);

    }
}
