package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Events;
@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {
}