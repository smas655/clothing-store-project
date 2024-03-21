package com.orazov.client;

import com.orazov.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRestClient {

    List<Product> findAllProducts();

    Product createProduct(String title, String description);

    Optional<Product> findProduct(int productId);

    void updateProduct(int productId, String title, String description);

    void deleteProduct(int productId);
}
