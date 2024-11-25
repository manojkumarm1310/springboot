package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.HealthMetric;
import com.wipro.entity.MetricType;

@Repository
public interface HealthMetricRepository extends JpaRepository<HealthMetric, Long> {
    List<HealthMetric> findByUserId(Long userId);
    List<HealthMetric> findByUserIdAndType(Long userId, MetricType type);
}
