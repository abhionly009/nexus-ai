package com.agh.nexus_ai.service;

import com.agh.nexus_ai.dto.Product;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTools {

    private final ProductCatalogueClient client;

    public ProductTools(ProductCatalogueClient client) {
        this.client = client;
    }

    @Tool(description = "Get list of products")
    public List<Product> getAllProducts() {
        return client.getAllProduct();
    }
}
