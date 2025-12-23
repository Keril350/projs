package com.shop.cart.controller;

import com.shop.cart.entity.cart;
import com.shop.cart.repository.CartRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Cart {

    private final CartRepo cartRepo;

    @GetMapping("/api/GC")
    public List<cart> getAll() {
        return cartRepo.findAll();
    }

    @PostMapping("/api/AC")
    public void addCart(@RequestBody cart cart) {
        cartRepo.save(cart);
    }
}
