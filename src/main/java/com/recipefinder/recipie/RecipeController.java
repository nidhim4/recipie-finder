package com.recipefinder.recipie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/") // Redirect root URL to title.html
    public String showTitlePage() {
        return "title.html";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @PostMapping("/findRecipes")
    @ResponseBody
    public ResponseEntity<?> findRecipes(@RequestBody Map<String, Object> requestBody) {
        if (requestBody.containsKey("ingredients")) {
            List<String> ingredients = (List<String>) requestBody.get("ingredients");
            if (!ingredients.isEmpty()) {
                List<Recipe> matchingRecipes = recipeService.findRecipesByIngredients(ingredients);
                if (!matchingRecipes.isEmpty()) {
                    return new ResponseEntity<>(matchingRecipes, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("No recipes found matching the provided ingredients.", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("No ingredients provided.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Ingredients not found in request body.", HttpStatus.BAD_REQUEST);
        }
    }
}
