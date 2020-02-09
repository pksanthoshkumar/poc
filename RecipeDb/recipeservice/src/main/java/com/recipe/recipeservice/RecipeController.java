package com.recipe.recipeservice;

import com.recipe.recipeservice.repository.RecipeRepository;
import domain.Recipe;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping ("/recipe")
public class RecipeController  {

    @Autowired
    RecipeRepository recipeRepository;

    //http GET http://localhost:8081/recipe/list
    //http :8081/recipe/list

    @GetMapping ("/list")
    public ResponseEntity <Flux <Recipe>>getAllReipe (){
        Flux <Recipe> recipeFlux = recipeRepository.findAll();
        return new ResponseEntity<>(recipeFlux, HttpStatus.OK);
    }

    @GetMapping ("/publisher")
    public Publisher<Recipe> getRecipeAsPublisher () {
        return recipeRepository.findAll();
    }

    @GetMapping ("/flux")
    public Flux <Recipe> getRecipeFlux () {
        return recipeRepository.findAll();
    }
}
