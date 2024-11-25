package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.TripPackageDto;
import com.wipro.entity.TripPackage;
import com.wipro.exception.UserException;
import com.wipro.service.TripPackageService;


@RestController
@RequestMapping("/api")
public class TripPackageController {
	
	@Autowired
	private TripPackageService tripPackageService;
	
//	@PostMapping("/admin/package/create")
//	public TripPackage createPackage(@RequestBody TripPackage tripPackage) {
//		return tripPackageService.createPackage(tripPackage);
//	}
	
	@GetMapping("/package/getAllPackages")
	public List<TripPackage> getAllPackage() {
		return tripPackageService.getAllPackage();
	}
    
	@GetMapping("/package/getPackageById/{packageId}")
	public TripPackage getMethodName(@PathVariable(value="packageId")Long packageId) {
		return tripPackageService.getPackageById(packageId);
	}
	
	@PutMapping("/package/update/{packageId}")
	public TripPackage updatePackage(@PathVariable(value="packageId")Long packageId,TripPackage tripPackage) {
		return tripPackageService.updatePackage(packageId, tripPackage);
	}
	
	@PostMapping("/admin/package/create")
	public TripPackage createPackage(@RequestBody TripPackageDto tripPackagedto) throws UserException {
		return tripPackageService.createPackageDetail(tripPackagedto);
	}
	
}
