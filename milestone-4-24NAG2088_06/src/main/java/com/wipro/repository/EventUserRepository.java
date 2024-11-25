package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.EventUsers;
@Repository
public interface EventUserRepository extends JpaRepository<EventUsers, Long> {
}