package com.pbl3.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.pbl3.ecommerce.entity.Cart;
import com.pbl3.ecommerce.entity.Product;
import com.pbl3.ecommerce.repository.ProductRepository;

@Controller
public class CartController {

  private final Cart cart;
  private final ProductRepository productRepo;

  public CartController(Cart cart, ProductRepository productRepo) {
    this.cart = cart;
    this.productRepo = productRepo;
  }

  @GetMapping("/cart")
  public String viewCart(Model model) {
    model.addAttribute("items", cart.getItems());
    model.addAttribute("total", cart.getTotal());
    return "cart/view";
  }

  @PostMapping("/cart/add")
  public String addToCart(@RequestParam("productId") Long productId) {
    Product p = productRepo.findById(productId)
      .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Product not found"));
    cart.add(p);
    return "redirect:/cart";
  }

  @PostMapping("/cart/remove")
  public String removeFromCart(@RequestParam("productId") Long productId) {
    cart.remove(productId);
    return "redirect:/cart";
  }

  @PostMapping("/cart/checkout")
  public String checkout(Model model) {
    model.addAttribute("items", cart.getItems());
    model.addAttribute("total", cart.getTotal());
    return "checkout/view";
  }
}