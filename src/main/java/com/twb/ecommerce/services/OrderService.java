package com.twb.ecommerce.services;

import com.twb.ecommerce.interfaces.CRUDServiceInterface;
import com.twb.ecommerce.models.Order;
import com.twb.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    @Autowired
   private OrderRepository orderRepository;
   public List<Order> findAllOrders() {
       return orderRepository.findAll();
   }
   public Optional<Order> findOrderById(Long id) {
       return orderRepository.findById(id);
   }
   public Order createOrder(Order order){
       return orderRepository.save(order);
   }
   public Order updateOrder(Long id, Order orderDetails) {
       return orderRepository.findById(id).map(order -> {
           order.setQuantity(order.getQuantity());
           order.setUser(order.getUser());
           order.setProduct(order.getProduct());
           return order;
       }).orElseGet(()->{
           orderDetails.setId(id);
           return orderRepository.save(orderDetails);
       });
   }
   public void deleteOrder(Long id) {
       orderRepository.deleteById(id);
   }
}
