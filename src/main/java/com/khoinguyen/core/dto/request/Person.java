package com.khoinguyen.core.dto.request;

public record Person(String fullName, String address) {

    public Person() {
        this("defaultValue", "defaultValue");
    }
}

