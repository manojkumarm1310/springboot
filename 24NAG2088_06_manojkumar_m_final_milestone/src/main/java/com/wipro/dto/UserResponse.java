package com.wipro.dto;

import java.util.List;

import com.wipro.entity.HealthMetric;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;
	private String username;
    private String email;
    private String password;
    private String role;
    private String token;
    private List<HealthMetric> healthMetrics;
}
