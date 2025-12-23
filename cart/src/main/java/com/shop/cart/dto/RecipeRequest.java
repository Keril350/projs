package com.shop.cart.dto;

import java.util.List;

public class RecipeRequest {
    private List<Integer> product_ids;

    public RecipeRequest(List<Integer> product_ids) {
        this.product_ids = product_ids;
    }

    public List<Integer> getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(List<Integer> product_ids) {
        this.product_ids = product_ids;
    }
}
