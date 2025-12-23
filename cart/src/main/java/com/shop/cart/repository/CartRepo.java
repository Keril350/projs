package com.shop.cart.repository;

import com.shop.cart.entity.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<cart, Integer> {

}
