package com.example.pironeer.service;

import com.example.pironeer.domain.Product;
import com.example.pironeer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 등록
    public Long createProduct(String name, int price, int stockQuantity) {
        Product saved = productRepository.save(new Product(name, price, stockQuantity));
        return saved.id; // ✅ ID만 반환
    }

    // 단건 조회
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품를 찾을 수 없습니다.")) ;
    }

    // 목록 조회
    public List<Product> findProductAll() {
        return productRepository.findAll();
    }

    // 재고 차감
    public void decreaseStockQuantity(Long productId, int quantity) {
        Product product = findProductById(productId);
        product.removeAmount(quantity);
    }

    // 재고 복구
    public void increaseStockQuantity(Long productId, int quantity) {
        Product product = findProductById(productId);
        product.addAmount(quantity);
    }

 }
