package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking,Long>{

}
