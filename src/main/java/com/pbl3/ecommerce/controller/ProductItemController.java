package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.dto.PushProductItemDTO;
import com.pbl3.ecommerce.entity.Brand;
import com.pbl3.ecommerce.entity.SellCategory;
import com.pbl3.ecommerce.entity.TariffiPackage;
import com.pbl3.ecommerce.service.PushProductItemService;
import com.pbl3.ecommerce.repository.BrandRepository;
import com.pbl3.ecommerce.repository.SellCategoryRepository;
import com.pbl3.ecommerce.repository.TariffiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductItemController {

    @Autowired
    private PushProductItemService pushProductItemService;
    @Autowired
    private BrandRepository brandRepo;
    @Autowired
    private SellCategoryRepository sellCatRepo;
    @Autowired
    private TariffiPackageRepository tariffRepo;

    @GetMapping
    public String showProductList(@RequestParam(name = "sellCategoryId", required = false) Integer sellCategoryId, Model model) {
        // Nếu không truyền sellCategoryId thì không hiển thị gì hoặc hiển thị tất cả (tuỳ ý bạn)
        List<ProductItemDTO> products = (sellCategoryId != null)
            ? pushProductItemService.ListProductBySellID(sellCategoryId)
            : List.of();
        model.addAttribute("products", products);
        return "product_list"; // Tên view Thymeleaf
    }

    /**
     * Hiển thị form tạo/sửa sản phẩm.
     */
    @GetMapping("/push")
    public String showPushForm(Model model, Principal principal) {
        // 1. DTO trống cho form
        model.addAttribute("pushDto", new PushProductItemDTO());

        // 2. Danh sách Brand để select
        List<Brand> brands = brandRepo.findAll();
        model.addAttribute("brands", brands);

        // 3. Danh sách SellCategory để select
        List<SellCategory> categories = sellCatRepo.findAll();
        model.addAttribute("categories", categories);

        // 4. Danh sách TariffiPackage để select
        List<TariffiPackage> tariffs = tariffRepo.findAll();
        model.addAttribute("tariffs", tariffs);

        // 5. clientId (lấy từ login user, giả sử principal.getName() chính là clientId)
        model.addAttribute("clientId", Integer.valueOf(principal.getName()));

        return "push_product";
    }

    // Nếu cần search, bạn cần bổ sung hàm search vào PushProductItemService
}
