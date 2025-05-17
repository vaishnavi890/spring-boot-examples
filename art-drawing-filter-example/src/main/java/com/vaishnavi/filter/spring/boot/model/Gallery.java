package com.vaishnavi.filter.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {

    private int id;
    private String name;
    private String location;
    private String contact;

    public Gallery(String name, String location, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
    }
}


