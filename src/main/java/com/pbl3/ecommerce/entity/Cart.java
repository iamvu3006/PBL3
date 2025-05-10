package com.pbl3.ecommerce.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Cart {
  private final Map<Long,CartItem> items = new LinkedHashMap<>();

  public void add(Product p) {
    items.compute(p.getId(), (k,v) -> {
      if (v == null) {
        return new CartItem(
          p.getId(),
          p.getName(),
          p.getPrice(),
          1
        );
      }
      v.setQuantity(v.getQuantity() + 1);
      return v;
    });
  }

  public void remove(Long productId) {
    items.remove(productId);
}
  public Collection<CartItem> getItems() {
    return items.values();
  }

  public long getTotal() {
    return items.values().stream()
      .mapToLong(i -> i.getPrice() * i.getQuantity())
      .sum();
  }
}
