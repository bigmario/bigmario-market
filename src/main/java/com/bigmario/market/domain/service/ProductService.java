package com.bigmario.market.domain.service;

import com.bigmario.market.domain.Product;
import com.bigmario.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProductById(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product saveProduct(Product product){
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct(int productId){
        return getProductById(productId).map(product -> {
            productRepository.deleteProduct(productId);
            return true;
        }).orElse(false);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }
}
