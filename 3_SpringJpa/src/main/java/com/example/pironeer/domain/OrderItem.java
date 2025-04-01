package com.example.pironeer.domain;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

@Entity
public class OrderItem {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long id;

        @ManyToOne
        @JoinColumn(name = "order_id")
        public Order order;

        @ManyToOne
        @JoinColumn(name = "product_id")
        public Product product;

        public int quantity;    // 주문 수량
        public int orderPrice; // 상품 가격

        protected OrderItem(){};

        public OrderItem(Product product, int quantity, int order_price){  // 어떤 상품을 주문했지 알아야하므로, Product 받아와야함
                this.product = product;
                this.quantity = quantity;
                this.orderPrice = order_price;
        }

        // 재고 복구
        public void cancel() {
                product.addAmount(quantity);
        }

        // 총 가격
        public int getTotalPrice() {
                return quantity * orderPrice;
        }



}