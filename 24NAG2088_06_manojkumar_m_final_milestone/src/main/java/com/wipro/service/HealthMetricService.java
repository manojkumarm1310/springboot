package com.wipro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.HealthMetric;
import com.wipro.entity.MetricType;
import com.wipro.entity.User;
import com.wipro.repository.HealthMetricRepository;
import com.wipro.repository.UserRepository;

@Service
public class HealthMetricService {

    @Autowired
    private HealthMetricRepository healthMetricRepository;

    @Autowired
    private UserRepository userRepository;

    public HealthMetric addMetric(Long userId, HealthMetric healthMetric) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        healthMetric.setTimestamp(LocalDateTime.now());
        healthMetric.setUser(user);
        return healthMetricRepository.save(healthMetric);
    }

    public List<HealthMetric> getMetricsByUser(Long userId) {
        return healthMetricRepository.findByUserId(userId);
    }

    public List<HealthMetric> getMetricsByType(Long userId, MetricType type) {
        return healthMetricRepository.findByUserIdAndType(userId, type);
    }
}
