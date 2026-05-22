package com.zglossip.recipecatalog.client.services;

import com.zglossip.recipecatalog.client.models.*;
import org.jspecify.annotations.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import java.util.List;
import java.util.Map;

public class RecipeCatalogService {

  private final RestClient restClient;

  public RecipeCatalogService(String baseUrl) {
    this.restClient = RestClient.builder()
        .baseUrl(baseUrl)
        .build();
  }

  public Recipe getRecipe(final int id) {
    return restClient.get()
        .uri("/recipe/{id}", id)
        .retrieve()
        .body(Recipe.class);
  }

  public List<Recipe> getRecipes(@NonNull List<String> courses, @NonNull List<String> cuisines, @NonNull List<String> tags, String sort, Boolean reverse, String name) {
    return restClient.get()
        .uri(uriBuilder -> {
          UriBuilder builder = uriBuilder
              .path("/recipe")
              .queryParam("course", courses)
              .queryParam("cuisine", cuisines)
              .queryParam("tag", tags);
          if (sort != null) builder = builder.queryParam("sort", sort);
          if (reverse != null) builder = builder.queryParam("reverse", reverse);
          if (name != null) builder = builder.queryParam("name", name);
          return builder.build();
        })
        .retrieve()
        .body(new ParameterizedTypeReference<>() {
        });
  }

  public int createFullRecipe(final FullRecipeRequest recipeRequest) {
    Map<String, Integer> response = restClient.post().uri("/recipe").body(recipeRequest).retrieve()
        .body(new ParameterizedTypeReference<>() {});
    return response.get("id");
  }

  public void updateRecipe(final int id, final RecipeRequest recipeRequest) {
    restClient.put().uri("/recipe/{id}", id).body(recipeRequest).retrieve().toBodilessEntity();
  }

  public void deleteRecipe(final int id) {
    restClient.delete().uri("/recipe/{id}", id).retrieve().toBodilessEntity();
  }

  public IngredientList getIngredients(final int id) {
    return restClient.get().uri("/recipe/{id}/ingredients", id).retrieve().body(IngredientList.class);
  }

  public void updateIngredients(final int id, final IngredientList ingredientList) {
    restClient.put().uri("/recipe/{id}/ingredients", id).body(ingredientList).retrieve().toBodilessEntity();
  }

  public InstructionList getInstructions(final int id) {
    return restClient.get().uri("/recipe/{id}/instructions", id).retrieve().body(InstructionList.class);
  }

  public void updateInstructions(final int id, final InstructionList instructionList) {
    restClient.put().uri("/recipe/{id}/instructions", id).body(instructionList).retrieve().toBodilessEntity();
  }
}
