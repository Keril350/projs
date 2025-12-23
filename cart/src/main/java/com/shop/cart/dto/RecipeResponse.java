package com.shop.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class RecipeResponse {

    @JsonProperty("recipe_id")
    private Integer recipeId;

    private String name;

    @JsonProperty("required_products")
    private List<Integer> requiredProducts;

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getRequiredProducts() {
        return requiredProducts;
    }

    public void setRequiredProducts(List<Integer> requiredProducts) {
        this.requiredProducts = requiredProducts;
    }
}
