package lk.travel.authservice;

import lk.travel.authservice.entity.Role;
import lk.travel.authservice.entity.Users;
import lk.travel.authservice.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserRepo userRepo;
    @Test
    void saveUser(){
        userRepo.save(Users.builder().userID(6).name("Jhon").email("jhon@gmail.com").pwd("1234").role(Role.MANAGER).build());
    }
}
