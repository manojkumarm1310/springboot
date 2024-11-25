package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripStopPoint;

@Repository
public interface TripStopPointRepository extends JpaRepository<TripStopPoint, Long> {

}
