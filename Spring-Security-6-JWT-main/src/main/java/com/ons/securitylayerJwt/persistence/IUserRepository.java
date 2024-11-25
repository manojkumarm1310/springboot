package com.ons.securitylayerJwt.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ons.securitylayerJwt.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userId = :userId")  // Use entity name and field names, not '*'
    Optional<User> findByEmail(String email);


}


