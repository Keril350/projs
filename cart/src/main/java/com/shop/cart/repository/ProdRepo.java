package com.shop.cart.repository;

import com.shop.cart.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepo extends JpaRepository<product, Integer> {

}
