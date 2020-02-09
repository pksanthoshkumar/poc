package domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String recipeId, recipeName, recipeDescShort, recipeImage, keyWords, relatedRecipes;
}
