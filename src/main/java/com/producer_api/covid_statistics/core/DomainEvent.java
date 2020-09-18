package com.producer_api.covid_statistics.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS
)
public interface DomainEvent<T> {

    @JsonIgnore
    String getId();

     T apply( T object);

}
