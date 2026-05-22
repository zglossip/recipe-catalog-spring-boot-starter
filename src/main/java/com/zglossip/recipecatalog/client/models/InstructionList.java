package com.zglossip.recipecatalog.client.models;

import java.util.List;
import java.util.Objects;

public record InstructionList(int recipeId, List<String> instructions) {
  public InstructionList {
    Objects.requireNonNull(instructions);
  }
}
