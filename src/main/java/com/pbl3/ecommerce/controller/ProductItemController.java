package com.pbl3.ecommerce.controller;

import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.entity.AbClient;
import com.pbl3.ecommerce.entity.Brand;
import com.pbl3.ecommerce.entity.SellCategory;
import com.pbl3.ecommerce.entity.TariffiPackage;
import com.pbl3.ecommerce.service.ProductItemService;
import com.pbl3.ecommerce.repository.AbClientRepository;
import com.pbl3.ecommerce.repository.BrandRepository;
import com.pbl3.ecommerce.repository.SellCategoryRepository;
import com.pbl3.ecommerce.repository.TariffiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;
    @Autowired
    private BrandRepository brandRepo;
    @Autowired
    private SellCategoryRepository sellCatRepo;
    @Autowired
    private TariffiPackageRepository tariffRepo;

    @Autowired
    public ProductItemController(ProductItemService productItemService, BrandRepository brandRepo, SellCategoryRepository sellCatRepo, TariffiPackageRepository tariffRepo) {
        this.productItemService = productItemService;
        this.brandRepo = brandRepo;
        this.sellCatRepo = sellCatRepo;
        this.tariffRepo = tariffRepo;
    }

    @GetMapping
    public String showProductList(@RequestParam(name = "sellCategoryId", required = false) Integer sellCategoryId, Model model) {
        List<ProductItemDTO> products = (sellCategoryId != null)
            ? productItemService.ListProductBySellID(sellCategoryId)
            : List.of();
        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/push_product")
    public String showPushForm(Model model, Principal principal) {
        System.out.println("⚠ Controller showPushForm() được gọi");
        model.addAttribute("pushDto", new ProductItemDTO());

        List<Brand> brands = brandRepo.findAll();
        model.addAttribute("brands", brands);

        List<SellCategory> categories = sellCatRepo.findAll();
        model.addAttribute("categories", categories);

        List<TariffiPackage> tariffs = tariffRepo.findAll();
        model.addAttribute("tariffs", tariffs);

        return "push_product";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createProduct(@RequestBody ProductItemDTO dto) throws Exception {
        try {
            productItemService.createProductItem(dto);
            return "Đăng bán sản phẩm thành công!";
        } catch (Exception e) {
            // Log error
            throw new RuntimeException("Có lỗi xảy ra khi tạo sản phẩm", e);
        }
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", sellCatRepo.findAll());
        model.addAttribute("tariffs", tariffRepo.findAll());
        return "create";
    }
}
