package com.recipefinder.recipie;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Recipe {
    private String name;
    private Integer prepTime;
    private DietaryRestrictions dietaryRestrictions;
    private ArrayList<String> ingredients;
    public Difficulty difficulty;

    public Recipe(String name, Difficulty difficulty, Integer prepTime, DietaryRestrictions dietaryRestrictions, ArrayList<String> ingredients) {
        this.name = name;
        this.difficulty = difficulty;
        this.prepTime = prepTime;
        this.dietaryRestrictions = dietaryRestrictions;
        this.ingredients = ingredients;
    }
}
