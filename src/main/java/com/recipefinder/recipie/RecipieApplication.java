package com.recipefinder.recipie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/") 
public class RecipieApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipieApplication.class, args);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue
            = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/description/{id}")
    public String getDescription(@PathVariable("id") String name) {
        String description = "Please input the ingredients you would have available. We will return a list of recipes that you can make!";
        String description1 = String.format("Hello %s! - %s", name, description);

        String ready = "Are you ready to eat?";

        return (description1 + "\n" + ready);
    }

}
