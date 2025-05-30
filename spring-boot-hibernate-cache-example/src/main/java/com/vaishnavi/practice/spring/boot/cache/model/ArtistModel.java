package com.vaishnavi.practice.spring.boot.cache.model;



import com.vaishnavi.practice.spring.boot.cache.domain.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistModel {

    private Long id;

    private String name;

    private String city;
}

