package com.seif.shopping.onlineshopping.controller;

import com.seif.shopping.onlineshopping.entity.Product;
import com.seif.shopping.onlineshopping.requests.ProductAddRequest;
import com.seif.shopping.onlineshopping.requests.ProductUpdateRequest;
import com.seif.shopping.onlineshopping.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product/")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public Product addProduct(@RequestBody ProductAddRequest product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getByProductId/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping()
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/getByCategory/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("/getByBrand/{brandName}")
    public List<Product> getProductsByBrand(@PathVariable String brandName) {
        return productService.getProductsByBrand(brandName);
    }

    @GetMapping("/getByProductName/{productName}")
    public List<Product> getProductsByName(@PathVariable String productName) {
        return productService.getProductsByName(productName);
    }

    @GetMapping("/getByCategoryAndBrand")
    public List<Product> getProductsByCategoryAndBrand(@RequestParam String categoryName, @RequestParam String brandName) {
        return productService.getProductsByCategoryAndBrand(categoryName,brandName);
    }

    @GetMapping("/getByCategoryAndProductName")
    public List<Product> getProductsByBrandAndName(@RequestParam String brandName, @RequestParam String productName) {
        return productService.getProductsByBrandAndName(brandName,productName);
    }

    @GetMapping("/getCount")
    public Long getProductCount( @RequestParam String brandName, @RequestParam String productName) {
        return productService.countProductByBrandAndName(brandName,productName);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody ProductUpdateRequest product,@PathVariable Long productId) {
        return productService.updateProduct(product,productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }













}
