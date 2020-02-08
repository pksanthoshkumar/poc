package com.recipe.service;

import com.recipe.service.recipedb.model.Recipe;
import com.recipe.service.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/recipe")
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping ("/getAll")
    List <Recipe> getAllRecipe (){
        return recipeRepository.findAll();
    }
}
