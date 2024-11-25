package com.wipro.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BusAvailabilityStatus {
	@JsonProperty("UNAVAILABLE")
	UNAVAILABLE,
	@JsonProperty("AVAILABLE")
	AVAILABLE
}
