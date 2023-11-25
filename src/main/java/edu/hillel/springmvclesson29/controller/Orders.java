package edu.hillel.springmvclesson29.controller;

import edu.hillel.springmvclesson29.model.Order;
import edu.hillel.springmvclesson29.response.ResponseBodyInterface;
import edu.hillel.springmvclesson29.services.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class Orders {

    private final OrderRepository orderRepository;

    public Orders(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/getOrders")
    public Map<Integer, Order> getOrders() {
        return orderRepository.getOrders();
    }

    @GetMapping("/getOrder")
    public Order getOrder(@RequestParam int id) {
        return orderRepository.getOrder(id);
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order) {
        final ResponseEntity<ResponseBodyInterface> response = orderRepository.addOrder(order);
        return Objects.requireNonNull(response.getBody()).getDetails();
    }

    @DeleteMapping("/removeOrder")
    public String removeOrder(@RequestParam int id) {
        final ResponseEntity<ResponseBodyInterface> response = orderRepository.removeOrder(id);
        return Objects.requireNonNull(response.getBody()).getDetails();
    }

    @DeleteMapping("/deleteOrder")
    public String removeOrder(@RequestBody Order order) {
        final ResponseEntity<ResponseBodyInterface> response = orderRepository.removeOrder(order);
        return Objects.requireNonNull(response.getBody()).getDetails();
    }
}
