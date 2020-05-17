package org.management;

import org.management.entities.RoleEntity;
import org.management.services.AccountSerive;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountSerive accountSerive){
        return args -> {
            accountSerive.saveRole(new RoleEntity(null,"USER"));
            accountSerive.saveRole(new RoleEntity(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un->{
                accountSerive.saveUser(un,"12345","12345");
            });

        };

    }
    @Bean
    BCryptPasswordEncoder getBCP(){
        return new BCryptPasswordEncoder();
    }

}
