package com.recipefinder.recipie;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeService {

    private final List<Recipe> recipes;

    public RecipeService() {
        this.recipes = initializeRecipes();
    }

    private List<Recipe> initializeRecipes() {
        List<Recipe> initializedRecipes = new ArrayList<>();

        // Sample data for demonstration purposes
        initializedRecipes.add(new Recipe("Chicken Parmesan", Difficulty.MEDIUM, 45, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Chicken", "Cheese", "Olive Oil"))));
        initializedRecipes.add(new Recipe("Lentil Soup", Difficulty.EASY, 30, DietaryRestrictions.VEGAN, new ArrayList<>(Arrays.asList("Lentils", "Onions", "Spices"))));
        initializedRecipes.add(new Recipe("Biryani", Difficulty.DIFFICULT, 30, DietaryRestrictions.VEGAN, new ArrayList<>(Arrays.asList("Rice", "Lentils", "Onions", "Spices", "Curry Powder", "Garlic", "Butter"))));
        initializedRecipes.add(new Recipe("Butter Cookies", Difficulty.EASY, 25, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Butter", "Flour", "Sugar", "Salt"))));
        initializedRecipes.add(new Recipe("Fried Plantains", Difficulty.EASY, 20, DietaryRestrictions.VEGAN, new ArrayList<>(Arrays.asList("Olive/Vegetable Oil", "Sugar", "Salt"))));
        initializedRecipes.add(new Recipe("Simple Pancakes", Difficulty.EASY, 20, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Flour", "Eggs", "Milk", "Butter", "Sugar", "Salt"))));
        initializedRecipes.add(new Recipe("Cheese Danish", Difficulty.MEDIUM, 45, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Flour", "Cheese", "Butter", "Sugar", "Eggs", "Milk"))));
        initializedRecipes.add(new Recipe("Garlic Bread Sticks", Difficulty.EASY, 25, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Flour", "Butter", "Bread", "Garlic", "Salt"))));
        initializedRecipes.add(new Recipe("Lemon Butter Cookies", Difficulty.MEDIUM, 30, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Butter", "Flour", "Sugar", "Salt"))));
        initializedRecipes.add(new Recipe("Bacon and Eggs Breakfast", Difficulty.EASY, 15, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Bacon", "Eggs", "Butter"))));
        initializedRecipes.add(new Recipe("Cheese Omelette", Difficulty.EASY, 10, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Eggs", "Cheese", "Butter"))));
        initializedRecipes.add(new Recipe("Chicken Stir-Fry", Difficulty.MEDIUM, 25, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Chicken", "Onions", "Garlic", "Olive/Vegetable Oil", "Soy Sauce", "Spices"))));
        initializedRecipes.add(new Recipe("Lentil Stew", Difficulty.EASY, 30, DietaryRestrictions.VEGAN, new ArrayList<>(Arrays.asList("Lentils", "Onions", "Tomato", "Garlic", "Olive/Vegetable Oil", "Spices"))));
        initializedRecipes.add(new Recipe("Garlic Butter Chicken", Difficulty.MEDIUM, 35, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Chicken", "Butter", "Garlic", "Salt"))));
        initializedRecipes.add(new Recipe("Tomato and Pesto Pasta", Difficulty.EASY, 25, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Pesto Sauce", "Tomato", "Pasta", "Olive/Vegetable Oil"))));
        initializedRecipes.add(new Recipe("Vegan Bean Salad", Difficulty.EASY, 15, DietaryRestrictions.VEGAN, new ArrayList<>(Arrays.asList("Canned Beans", "Onions", "Tomato", "Olive/Vegetable Oil", "Vinegar", "Spices"))));
        initializedRecipes.add(new Recipe("Potato Pancakes", Difficulty.MEDIUM, 30, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Potatoes", "Onions", "Eggs", "Flour", "Salt", "Olive/Vegetable Oil"))));
        initializedRecipes.add(new Recipe("Cheesy Garlic Bread", Difficulty.EASY, 20, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Flour", "Cheese", "Garlic", "Butter", "Salt"))));
        initializedRecipes.add(new Recipe("Chicken Fried Rice", Difficulty.MEDIUM, 30, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Chicken", "Rice", "Eggs", "Onions", "Soy Sauce", "Olive/Vegetable Oil", "Garlic"))));
        initializedRecipes.add(new Recipe("Spicy Lentil Soup", Difficulty.EASY, 30, DietaryRestrictions.VEGAN, new ArrayList<>(Arrays.asList("Lentils", "Onions", "Garlic", "Spices", "Olive/Vegetable Oil"))));
        initializedRecipes.add(new Recipe("Pesto Chicken Sandwich", Difficulty.EASY, 15, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Chicken", "Pesto Sauce", "Cheese", "Bread", "Butter"))));
        initializedRecipes.add(new Recipe("Vegetarian Fried Rice", Difficulty.MEDIUM, 25, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Rice", "Eggs", "Onions", "Tomato", "Soy Sauce", "Olive/Vegetable Oil"))));
        initializedRecipes.add(new Recipe("Garlic Mashed Potatoes", Difficulty.EASY, 20, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Potatoes", "Garlic", "Butter", "Milk", "Salt"))));
        initializedRecipes.add(new Recipe("Butter Chicken", Difficulty.MEDIUM, 40, DietaryRestrictions.NONVEGETARIAN, new ArrayList<>(Arrays.asList("Chicken", "Butter", "Garlic", "Onions", "Tomato", "Spices"))));
        initializedRecipes.add(new Recipe("Hot Cheetos", Difficulty.EASY, 0, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Red 40", "Cheese"))));
        initializedRecipes.add(new Recipe("Samosa Chaat", Difficulty.EASY, 20, DietaryRestrictions.VEGETARIAN, new ArrayList<>(Arrays.asList("Samosa", "Chickpeas"))));


        return initializedRecipes;
    }

    public List<Recipe> findRecipesByIngredients(List<String> ingredients) {
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().containsAll(ingredients)) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }

    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipes);
    }
}

