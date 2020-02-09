package com.recipe.recipeservice.repository;

import domain.Recipe;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RecipeRepository extends ReactiveCrudRepository <Recipe, String> {

}
