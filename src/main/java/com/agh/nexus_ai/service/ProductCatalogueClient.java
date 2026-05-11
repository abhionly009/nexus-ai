package com.agh.nexus_ai.service;

import com.agh.nexus_ai.dto.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductCatalogueClient {
    private final RestClient restClient;

    public ProductCatalogueClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:8084")
                .build();
    }

    public List<Product> getAllProduct() {

        return restClient.get()
                .uri("/api/product/getAll")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {});
    }
}
