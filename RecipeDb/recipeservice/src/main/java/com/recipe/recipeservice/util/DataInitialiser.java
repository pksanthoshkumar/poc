package com.recipe.recipeservice.util;
import com.recipe.recipeservice.repository.RecipeRepository;
import domain.Recipe;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Configuration
@RequiredArgsConstructor
@Log4j2
public class DataInitialiser {

    @Autowired
    RecipeRepository recipeRepository;

    @EventListener (ApplicationReadyEvent.class)
    public void intialiseData () {
        recipeRepository.deleteAll()
                    .thenMany(saveAll())
                        .thenMany(recipeRepository.findAll())
                            .subscribe(re-> log.info(re));
    }

    private final Flux saveAll (){
        System.out.println("Saving All recipes...");
        Recipe r1 = new Recipe("1010", "Spring Rolls", "Spring Rolls", "Spring Rolls URL", "spring rolls", "1002, 1005");
        Recipe r2 = new Recipe("1011", "Spring Rolls xx", "Spring Rolls", "Spring Rolls URL", "spring rolls", "1002, 1005");
        Recipe r3 = new Recipe("1012", "Spring Rolls yy", "Spring Rolls", "Spring Rolls URL", "spring rolls", "1002, 1005");

        var saved = Flux.just (r1, r2, r3)
                .flatMap(re -> this.recipeRepository.save(re));

        return saved;
    }
}
