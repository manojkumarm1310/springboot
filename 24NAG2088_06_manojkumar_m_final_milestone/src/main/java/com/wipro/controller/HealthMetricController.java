package com.wipro.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.CreateHealthMetrics;
import com.wipro.entity.HealthMetric;
import com.wipro.entity.MetricType;
import com.wipro.service.HealthMetricService;

@RestController
@CrossOrigin
@RequestMapping("/api/users/{userId}/metrics")
public class HealthMetricController {

    @Autowired
    private HealthMetricService healthMetricService;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<HealthMetric> addMetric(@PathVariable("userId") Long userId, @RequestBody CreateHealthMetrics healthMetric) {
    	HealthMetric metric = modelMapper.map(healthMetric, HealthMetric.class);
        HealthMetric createdMetric = healthMetricService.addMetric(userId, metric);
        return new ResponseEntity<>(createdMetric, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HealthMetric>> getMetrics(@PathVariable("userId") Long userId) {
        List<HealthMetric> metrics = healthMetricService.getMetricsByUser(userId);
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<HealthMetric>> getMetricsByType(@PathVariable("userId") Long userId, @PathVariable("type") MetricType type) {
        List<HealthMetric> metrics = healthMetricService.getMetricsByType(userId, type);
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }
}
