package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.OrderDto;         
import com.pbl3.ecommerce.dto.OrderItemDto;
import com.pbl3.ecommerce.entity.Order;
import com.pbl3.ecommerce.entity.OrderItem;
import com.pbl3.ecommerce.repository.OrderRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;  
import org.springframework.http.HttpStatus;                   

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    // Hiển thị form tạo đơn
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        return "orders/form";
    }

    // Xử lý form submit
    @PostMapping
    public String createOrder(@ModelAttribute OrderDto dto) {
        Order order = new Order();
        order.setFullName(dto.getFullName());
        order.setAddress(dto.getAddress());
        order.setPhone(dto.getPhone());
        order.setTotalPrice(dto.getCartItems().stream()
            .mapToLong(OrderItemDto::getPrice).sum());

        dto.getCartItems().forEach(itemDto -> {
            OrderItem item = new OrderItem();
            item.setName(itemDto.getName());
            item.setPrice(itemDto.getPrice());
            order.addItem(item);
        });

        orderRepo.save(order);
        return "redirect:/orders/" + order.getId();
    }

    // Hiển thị chi tiết đơn
    @GetMapping("/{id}")
    public String viewOrder(@PathVariable Long id, Model model) {
        Order order = orderRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("order", order);
        return "orders/detail";
    }
}
