package org.management.web;

import lombok.Data;
import org.management.entities.UserEntity;
import org.management.services.AccountSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private AccountSerive accountSerive;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserForm userForm) {
        return accountSerive.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmPassword());
    }
}
@Data
class  UserForm{
    private String username;
    private String password;
    private String confirmPassword;
}
