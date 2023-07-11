package com.bigmario.market.domain.repository;

import com.bigmario.market.domain.Product;
import com.bigmario.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product saveProduct(Product product);
    void deleteProduct(int productId);
}
