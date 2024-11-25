package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.dto.TripPackageDto;
import com.wipro.entity.TripPackage;
import com.wipro.exception.UserException;

@Service
public interface TripPackageService {

	TripPackage createPackage(TripPackage tripPackage);

	List<TripPackage> getAllPackage();

	TripPackage getPackageById(Long packageId);

	TripPackage updatePackage(Long packageId, TripPackage tripPackage);

	TripPackage createPackageDetail(TripPackageDto tripPackagedto) throws UserException;

}
