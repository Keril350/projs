package com.shop.cart.entity;

import com.shop.cart.entity.product;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class cart {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private product product;

    private int quantity;
}
