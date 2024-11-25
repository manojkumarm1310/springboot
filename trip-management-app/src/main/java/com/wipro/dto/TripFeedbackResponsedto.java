package com.wipro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TripFeedbackResponsedto {
	
	public TripFeedbackResponsedto() {
		// TODO Auto-generated constructor stub
	}
	private String feedback;
	private Integer rating;
	private String userName;
	private String packageName;

}
