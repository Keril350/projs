package com.shop.cart.controller;

import com.shop.cart.entity.product;
import com.shop.cart.repository.ProdRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Product {

    private final ProdRepo prodRepo;

    @GetMapping("/api/GP")
    public List<product> getAll() {
        return prodRepo.findAll();
    }

    @PostMapping("/api/AP")
    public void addProduct(@RequestBody product product) {
        prodRepo.save(product);
    }
}
