package com.vaishnavi.filter.spring.boot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Artwork {

    private int id;
    private String title;
    private String medium;
    private double price;
    private int artistId;

    public Artwork(String title, String medium, double price, int artistId) {
        this.title = title;
        this.medium = medium;
        this.price = price;
        this.artistId = artistId;
    }
}


