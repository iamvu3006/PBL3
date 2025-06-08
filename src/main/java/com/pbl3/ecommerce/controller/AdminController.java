package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.AbClientDTO;
import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin") // Tất cả API admin đều đi qua đường dẫn này
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Lấy danh sách toàn bộ user
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/clients")
    public ResponseEntity<List<AbClientDTO>> getAllClients() {
        return ResponseEntity.ok(adminService.getAllClients());
    }

    // Thêm mới một user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/clients")
    public ResponseEntity<AbClient> addClient(@RequestBody AbClient client) {
        AbClient savedClient = adminService.addClient(client);
        return ResponseEntity.ok(savedClient);
    }

    // Xóa user theo ID
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @Autowired
    private AdminService productItemService;

    // Lấy danh sách sản phẩm chờ duyệt
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("products/pending")
    public List<ProductItemDTO> getPendingProducts() {
        return productItemService.getProductItemsByStatus(ProductItem.Status.PENDING);
    }

    // Duyệt sản phẩm
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("products/{id}/approve")
    public ResponseEntity<String> approveProduct(@PathVariable Integer id) {
        productItemService.approveProduct(id);
        return ResponseEntity.ok("Sản phẩm đã được duyệt.");
    }

    // Từ chối sản phẩm
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("products/{id}/reject")
    public ResponseEntity<String> rejectProduct(@PathVariable Integer id) {
        productItemService.rejectProduct(id);
        return ResponseEntity.ok("Sản phẩm đã bị từ chối.");
    }
}
