package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripFeedback;
@Repository
public interface TripFeedbackRepository extends JpaRepository<TripFeedback, Long> {

}
