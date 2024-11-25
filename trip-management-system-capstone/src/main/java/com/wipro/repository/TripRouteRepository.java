package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripRoute;

@Repository
public interface TripRouteRepository extends JpaRepository<TripRoute, Long> {

}
