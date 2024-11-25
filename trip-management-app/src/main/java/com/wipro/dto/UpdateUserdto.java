package com.wipro.dto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UpdateUserdto {
	private String name;
	private String email;
	private String password;
	private String userLocation;
	private Long mobile;
	
	public UpdateUserdto(){
		
	}
}
