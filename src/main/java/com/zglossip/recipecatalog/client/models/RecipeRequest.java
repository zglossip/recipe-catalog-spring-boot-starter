package com.zglossip.recipecatalog.client.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

public class RecipeRequest {

  private String name;
  private Collection<String> courseTypes;
  private Collection<String> cuisineTypes;
  private Collection<String> tags;
  private int servingAmount;
  private String servingName;
  private String source;
  private LocalDateTime uploaded;

  public RecipeRequest(String name,
                       Collection<String> courseTypes,
                       Collection<String> cuisineTypes,
                       Collection<String> tags,
                       int servingAmount,
                       String servingName,
                       String source,
                       LocalDateTime uploaded) {
    Objects.requireNonNull(name);
    Objects.requireNonNull(courseTypes);
    Objects.requireNonNull(cuisineTypes);
    Objects.requireNonNull(tags);
    Objects.requireNonNull(servingName);
    this.name = name;
    this.courseTypes = courseTypes;
    this.cuisineTypes = cuisineTypes;
    this.tags = tags;
    this.servingAmount = servingAmount;
    this.servingName = servingName;
    this.source = source;
    this.uploaded = uploaded;
  }

  public String getName() {
    return name;
  }

  public Collection<String> getCourseTypes() {
    return courseTypes;
  }

  public Collection<String> getCuisineTypes() {
    return cuisineTypes;
  }

  public Collection<String> getTags() {
    return tags;
  }

  public int getServingAmount() {
    return servingAmount;
  }

  public String getServingName() {
    return servingName;
  }

  public String getSource() {
    return source;
  }

  public LocalDateTime getUploaded() {
    return uploaded;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    RecipeRequest that = (RecipeRequest) o;
    return servingAmount == that.servingAmount && Objects.equals(name, that.name) && Objects.equals(courseTypes, that.courseTypes) && Objects.equals(cuisineTypes, that.cuisineTypes) && Objects.equals(tags, that.tags) && Objects.equals(servingName, that.servingName) && Objects.equals(source, that.source) && Objects.equals(uploaded, that.uploaded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, courseTypes, cuisineTypes, tags, servingAmount, servingName, source, uploaded);
  }

  @Override
  public String toString() {
    return "RecipeRequest{" +
        "name='" + name + '\'' +
        ", courseTypes=" + courseTypes +
        ", cuisineTypes=" + cuisineTypes +
        ", tags=" + tags +
        ", servingAmount=" + servingAmount +
        ", servingName='" + servingName + '\'' +
        ", source='" + source + '\'' +
        ", uploaded=" + uploaded +
        '}';
  }
}
