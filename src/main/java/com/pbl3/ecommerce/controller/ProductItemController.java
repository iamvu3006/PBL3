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

//     @GetMapping
//     public String showProductList(@RequestParam(name = "sellCategoryId", required = false) Integer sellCategoryId, Model model) {
//
//         List<ProductItemDTO> products = (sellCategoryId != null)
//                 ? pushProductItemService.ListProductBySellID(sellCategoryId)
//                 : List.of();
//         model.addAttribute("products", products);
//         return "product_list";
//     }

   
     @GetMapping("/push")
     public String showPushForm(Model model, Principal principal) {
       
         model.addAttribute("pushDto", new PushProductItemDTO());

      
         List<Brand> brands = brandRepo.findAll();
         model.addAttribute("brands", brands);

       
         List<SellCategory> categories = sellCatRepo.findAll();
         model.addAttribute("categories", categories);

       
         List<TariffiPackage> tariffs = tariffRepo.findAll();
         model.addAttribute("tariffs", tariffs);

        
         model.addAttribute("clientId", Integer.valueOf(principal.getName()));

         return "push_product";
     }

  
 }