package com.wipro.dto;

import com.wipro.entity.MetricType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHealthMetrics {
	private MetricType type;
    private Double value;
}
