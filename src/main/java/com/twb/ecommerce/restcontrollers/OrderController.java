package com.twb.ecommerce.restcontrollers;

import com.twb.ecommerce.exceptions.ResourceNotFoundException;
import com.twb.ecommerce.models.Order;
import com.twb.ecommerce.models.Product;
import com.twb.ecommerce.models.User;
import com.twb.ecommerce.repositories.ProductRepository;
import com.twb.ecommerce.repositories.UserRepository;
import com.twb.ecommerce.services.OrderService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }
    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
//        User user = userRepository.findById(order.getUser().getId())
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + order.getUser().getId()));
//        Product product = productRepository.findById(order.getProduct().getId())
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + order.getProduct().getId()));
//        order.setProduct(product);
        return orderService.createOrder(order);
    }
}
