package com.wipro.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {
	@JsonProperty("MALE")
	MALE,
	@JsonProperty("FEMALE")
	FEMALE,
	@JsonProperty("TRANSGENDER")
	TRANSGENDER,
	@JsonProperty("OTHER")
	OTHER
}
