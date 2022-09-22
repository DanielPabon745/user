package com.example.users.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Person {
    @JsonIgnore
    private String id;
    @JsonIgnore
    private DocumentType documentType;

    private String firstName;
    private String secondName;
    private String firstLastname;
    private String secondLastname;
    private String phoneNumber;
    private String address;
    private String city;
}
