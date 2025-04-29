package com.vaishnavi.practice.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ProductUpdate(
        @JsonInclude(JsonInclude.Include.NON_EMPTY) String name,
        @JsonInclude(JsonInclude.Include.NON_DEFAULT) double price,
        @JsonInclude(JsonInclude.Include.NON_DEFAULT) int quantity) {
    return null;
}




