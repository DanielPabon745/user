package com.example.users.users.util;

import com.example.users.users.model.DocumentType;
import com.example.users.users.model.Person;

public class PersonHelper {

    public static Person createPerson() {
        return Person.builder()
                .documentType(DocumentType.C)
                .id("23445322")
                .firstName("Luis")
                .secondName("Alfonso")
                .firstLastname("Ortega")
                .secondLastname("Suarez")
                .city("Bogota")
                .address("Calle 26 #76-89")
                .phoneNumber("3100000101")
                .build();
    }
}
