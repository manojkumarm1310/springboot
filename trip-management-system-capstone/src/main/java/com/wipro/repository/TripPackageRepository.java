package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.TripPackage;

@Repository
public interface TripPackageRepository extends JpaRepository<TripPackage, Long> {

}
