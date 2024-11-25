package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripBus;
@Repository
public interface TripBusRepository extends JpaRepository<TripBus, Long> {

}
