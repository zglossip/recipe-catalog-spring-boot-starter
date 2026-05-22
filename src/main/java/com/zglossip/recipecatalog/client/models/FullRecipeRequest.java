package com.zglossip.recipecatalog.client.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class FullRecipeRequest extends RecipeRequest {

  private List<Ingredient> ingredients;
  private List<String> instructions;

  public FullRecipeRequest(String name,
                           Collection<String> courseTypes,
                           Collection<String> cuisineTypes,
                           Collection<String> tags,
                           int servingAmount,
                           String servingName,
                           String source,
                           LocalDateTime uploaded,
                           List<Ingredient> ingredients,
                           List<String> instructions) {
    super(name, courseTypes, cuisineTypes, tags, servingAmount, servingName, source, uploaded);
    this.ingredients = ingredients;
    this.instructions = instructions;
  }

  public List<String> getInstructions() {
    return instructions;
  }

  public void setInstructions(List<String> instructions) {
    this.instructions = instructions;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    FullRecipeRequest that = (FullRecipeRequest) o;
    return Objects.equals(ingredients, that.ingredients) && Objects.equals(instructions, that.instructions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), ingredients, instructions);
  }

  @Override
  public String toString() {
    return "FullRecipeRequest{" +
        super.toString() +
        ", ingredients=" + ingredients +
        ", instructions=" + instructions +
        '}';
  }
}
