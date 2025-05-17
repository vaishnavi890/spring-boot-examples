package com.vaishnavi.filter.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    private int id;
    private String name;
    private String email;
    private String specialty;

    public Artist(String name, String email, String specialty) {
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }
}



