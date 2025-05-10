package com.pbl3.ecommerce.service;

import com.pbl3.ecommerce.dto.ProductItemDTO;
import com.pbl3.ecommerce.entity.ProductItem;
import com.pbl3.ecommerce.repository.ProductItemRepository;
import com.pbl3.ecommerce.repository.ProductItemSellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.webauthn.management.PublicKeyCredentialRequestOptionsRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductItemSellService{
    @Autowired
    private ProductItemSellRepository productItemSellRepository;

    public List<ProductItemDTO> ListProductBySellID(Integer clientID)
    {
        List<ProductItem> items = productItemSellRepository.findBySellCategoryIDNative(clientID);

        List<ProductItemDTO> itemDTOList = new ArrayList<>();

        for (ProductItem item : items)
        {
            ProductItemDTO productItemDTO = new ProductItemDTO(item);
            itemDTOList.add(productItemDTO);
        }
        return itemDTOList;
    }
}
