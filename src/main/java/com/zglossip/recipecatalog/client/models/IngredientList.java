package com.zglossip.recipecatalog.client.models;

import java.util.List;
import java.util.Objects;

public record IngredientList(int recipeId, List<Ingredient> ingredients) {
  public IngredientList {
    Objects.requireNonNull(ingredients);
  }
}
