package com.example.users.users.model;

public enum DocumentType {
    P ("Pasaporte"),
    C ("Cédula de ciudadanía");

    public final String name;

    private DocumentType(String name) {
        this.name = name;
    }
}
