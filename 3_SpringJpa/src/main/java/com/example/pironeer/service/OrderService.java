package com.example.pironeer.service;

import com.example.pironeer.domain.Order;
import com.example.pironeer.domain.OrderItem;
import com.example.pironeer.domain.Product;
import com.example.pironeer.domain.User;
import com.example.pironeer.dto.OrderRequestItem;
import com.example.pironeer.repository.OrderRepository;
import com.example.pironeer.repository.ProductRepository;
import com.example.pironeer.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional // 주문 도중 에러 발생하면 DB 작업 전부 롤백됨
// OrderRequestItem = 주문할 상품 리스트 (productId, quantity 포함된 DTO)
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductService productService, UserService userService, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    // 주문 생성
    public Long createOrder(Long userId, List<OrderRequestItem>  items) {
        // 1. 유저 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        // 2. 주문 객체 생성
        Order order = new Order(user, "ORDERED", null); // 주문 상태는 ORDERED, 날짜는 Order 생성자에서 자동으로 설정됨

        // 3. 상품 정보와 수량 받아서 OrderItem 생성 + 재고 차감
        for (OrderRequestItem item : items) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

            product.removeAmount(item.getQuantity()); // 주문 수량만큼 재고 차감

            OrderItem orderItem = new OrderItem(product, item.getQuantity(), product.getPrice());
            order.addOrderItem(orderItem); // 주문에 OrderItem 추가
        }
        // 4. 주문 저장
        Order savedOrder = orderRepository.save(order);
        return savedOrder.id;
    }

    // 주문 단건 조회
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다."));
    }

    // 유저별 주문 목록 조화
    public List<Order> findOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // 주문 취소
    public void cancelOrder(Long orderId) {
        Order order = findOrderById(orderId);

        if (order.getStatus().equals("CANCELLED")) {
            throw new IllegalArgumentException("이미 취소된 주문입니다.");
        }
        order.cancel();

    }

}
