// dto : 데이터 전달 객체
// OrderRequestItem (하나의 주문에는 여러 개의 상품을 담을 수 있어 )
// : 유저가 상품을 주문할 때, 어떤 상품을 몇 개 주문할 건지 담아 전달하는 객체

package com.example.pironeer.dto;

import java.security.PublicKey;

public class OrderRequestItem {

    private Long productId;
    private int quantity;

    // 기본 생성자 (필수: Jackson이나 Spring에서 객체 생성 시 사용)
    public OrderRequestItem() {}

    public OrderRequestItem(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;   // 갯수
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
