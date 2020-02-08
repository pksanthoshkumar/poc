package com.recipe.service.recipedb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="RECIPE")
public class Recipe {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name="RECIPE_ID")
    private Integer recipeId;

    @Column (name="RECIPE_NAME")
    private String recipeName;

    @Column (name = "RECIPE_DESC_SHORT")
    private String recipeDescShort;

    @Column (name="RECIPE_IMAGE")
    private String recipeImage;

    @Column (name="KEYWORDS")
    private String keyWords;

    @Column (name= "RELATED_RECIPES")
    private List<Integer> relatedRecipes;
}
