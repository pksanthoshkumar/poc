package com.recipe.service.repository;

import com.recipe.service.recipedb.model.Recipe;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository <Recipe, Integer> {
    Optional<Recipe> findByRecipeName(String integer);
}
