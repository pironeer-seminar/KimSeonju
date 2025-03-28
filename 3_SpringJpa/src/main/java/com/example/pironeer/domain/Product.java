package com.example.pironeer.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    // OrderItem과의 연관관계
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    public List<OrderItem> orderItemList = new ArrayList<>();

    public String name;
    public int price;
    public int stockQuantity ;  // 재고

    protected Product(){}
    public Product(String name, int price, int stockQuantity ){
        this.name = name;
        this.price = price;
        this.stockQuantity  = stockQuantity ;
    }

    public String getName() {
         return name;
    }
    public int getPrice(){
        return price;
    }
    public int getStockQuantity(){
        return stockQuantity ;
    }

    public void removeAmount(int amount){
        if (this.stockQuantity  < amount){
            throw new IllegalStateException();  // throw : 예외를 "던진다" // new IllegalStateException() : 새 예외 객체를 만들어냄
        }
        this.stockQuantity  -= amount;
    }

    public void addAmount(int amount){
        this.stockQuantity  += amount;
    }
}
