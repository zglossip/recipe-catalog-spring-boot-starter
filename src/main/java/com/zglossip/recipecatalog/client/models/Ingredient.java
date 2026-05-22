package com.zglossip.recipecatalog.client.models;

import java.math.BigDecimal;
import java.util.Objects;

public record Ingredient(String name, BigDecimal quantity, String uom, String notes) {
  public Ingredient {
    Objects.requireNonNull(name);
    Objects.requireNonNull(quantity);
  }
}
