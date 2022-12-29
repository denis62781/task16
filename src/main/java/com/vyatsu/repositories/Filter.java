package com.vyatsu.repositories;

import lombok.Getter;
import lombok.Setter;

public class Filter {
    @Getter
    @Setter
    private Long minPrice ;
    @Getter
    @Setter
    private Long maxPrice ;
    @Getter
    @Setter
    private String text = "";

    public Filter() {
    }

    public Filter(Long minPrice, Long maxPrice, String text) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.text = text;
    }
}
