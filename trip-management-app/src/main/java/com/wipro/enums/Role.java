package com.wipro.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
	@JsonProperty("ADMIN")
	ADMIN,
	@JsonProperty("USER")
	USER
}
