package com.producer_api.covid_statistics.core.display;

import java.util.Objects;
import java.util.UUID;

public class DisplayId {
	private String value;

    public DisplayId() {
        this(UUID.randomUUID().toString());
    }

    public DisplayId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object s) {
        if (this == s) return true;
        if (s == null || getClass() != s.getClass()) return false;
        DisplayId displayId = (DisplayId) s;
        return Objects.equals(value, displayId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SlotId{" +
                "value='" + value + '\'' +
                '}';
    }

	 

}
