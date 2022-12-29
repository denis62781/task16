package com.vyatsu.entities;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasText(final String text) {
        return (r, cq, cb) -> cb.like(cb.lower(r.get("title")), "%"+text+"%");
    }

    public static Specification<Product> minValue(final int min) {
        return (r, cq, cb) -> cb.greaterThanOrEqualTo(r.get("price"), min);
    }

    public static Specification<Product> maxValue(final int max) {
        return (r, cq, cb) -> cb.lessThanOrEqualTo(r.get("price"), max);
    }
}
