package com.vaishnavi.practice.spring.boot.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Training {

    private int id;
    private String name;
    private int duration;
    private String prerequisite;

    public void setId(int id) {
    }

    public String getPrerequisite() {
        return "";
    }

    public int getId() {
        return 0;
    }

    public void setPrerequisite(String prerequisite) {
    }

    public int getDuration() {
        return 0;
    }

    public void setDuration(int duration) {
    }
}


