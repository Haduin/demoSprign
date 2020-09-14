package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
public class Person {



    private final UUID id;

    private final String name;

    private final String email;

    private final String adres;
    
    private final String country;

    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name,String email,String adres,String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adres = adres;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
