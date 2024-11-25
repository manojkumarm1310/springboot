package com.wipro.dto;

import java.util.List;

import com.wipro.entity.HealthMetric;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
    private List<HealthMetric> healthMetrics;

}
