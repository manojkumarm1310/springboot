package com.telusko.part29springsecex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.part29springsecex.model.UsersValid;

@Repository
public interface UserRepo extends JpaRepository<UsersValid, Integer> {

    UsersValid findByEmail(String email);
}
