package com.wipro.dto;
public class AuthResponseDto {
    private String accessToken;
    
    public AuthResponseDto() {
    	
    }


	public AuthResponseDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
    
    


}
