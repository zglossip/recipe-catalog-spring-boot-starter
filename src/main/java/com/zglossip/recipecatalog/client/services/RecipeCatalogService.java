package com.zglossip.recipecatalog.client.services;

import com.zglossip.recipecatalog.client.models.Recipe;
import org.springframework.web.client.RestClient;

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

}
