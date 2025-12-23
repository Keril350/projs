package com.shop.cart.service;

import com.shop.cart.dto.RecipeRequest;
import com.shop.cart.dto.RecipeResponse;
import com.shop.cart.entity.cart;
import com.shop.cart.repository.CartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final CartRepo cartRepo;
    private final WebClient recipeWebClient;

    public List<RecipeResponse> getAvailableRecipes() {
        // 1. Получаем товары из корзины
        List<Integer> productIds = cartRepo.findAll()
                .stream()
                .map(c -> c.getProduct().getId())
                .toList();

        // 2. Формируем запрос
        RecipeRequest request = new RecipeRequest(productIds);

        // 3. Отправляем в Python
        return recipeWebClient.post()
                .uri("/api/available-recipes")
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(RecipeResponse.class)
                .collectList()
                .block();
    }
}
