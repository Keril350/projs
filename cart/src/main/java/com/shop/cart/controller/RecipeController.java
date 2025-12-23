package com.shop.cart.controller;

import com.shop.cart.dto.RecipeResponse;
import com.shop.cart.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/api/available-recipes")
    public List<RecipeResponse> getAvailableRecipes() {
        return recipeService.getAvailableRecipes();
    }
}
