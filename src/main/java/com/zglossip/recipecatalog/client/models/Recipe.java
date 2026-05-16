package com.zglossip.recipecatalog.client.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

public record Recipe(int id,
                     String name,
                     Collection<String> courseTypes,
                     Collection<String> cuisineTypes,
                     Collection<String> tags,
                     int servingAmount,
                     String servingName,
                     String source,
                     LocalDateTime uploaded){
    public Recipe {
        Objects.requireNonNull(name);
        Objects.requireNonNull(courseTypes);
        Objects.requireNonNull(cuisineTypes);
        Objects.requireNonNull(tags);
        Objects.requireNonNull(servingName);
    }
}
