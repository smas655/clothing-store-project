package com.orazov.catalogue.service;

import com.orazov.catalogue.entity.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    Product createProduct(String title, String description);

    Optional<Product> findProduct(int productId);

    void updateProduct(Integer id, String title, String description);

    void deleteProduct(Integer id);
}