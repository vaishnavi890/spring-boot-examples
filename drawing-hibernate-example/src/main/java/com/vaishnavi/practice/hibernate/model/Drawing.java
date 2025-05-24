package com.vaishnavi.practice.hibernate.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drawing {
    private int id;
    private String title;
    private String artist;
    private double price;
}


