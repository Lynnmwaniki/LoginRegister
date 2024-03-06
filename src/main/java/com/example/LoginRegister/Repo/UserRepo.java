package com.example.LoginRegister.Repo;


import com.example.LoginRegister.appuser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository


public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
