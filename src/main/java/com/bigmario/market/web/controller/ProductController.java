package com.bigmario.market.web.controller;

import com.bigmario.market.domain.Product;
import com.bigmario.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") int productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable("productId") int productId){
        return productService.deleteProduct(productId);
    }

    @GetMapping("/scarce")
    public Optional<List<Product>> getScarseProducts(int quantity){
        return productService.getScarseProducts(quantity);
    }
}
