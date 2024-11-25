package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripPlace;

@Repository
public interface TripPlaceRepository extends JpaRepository<TripPlace, Long>{

}
