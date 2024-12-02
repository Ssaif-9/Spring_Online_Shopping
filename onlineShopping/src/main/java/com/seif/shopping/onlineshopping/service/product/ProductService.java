package com.seif.shopping.onlineshopping.service.product;

import com.seif.shopping.onlineshopping.requests.AddProductRequest;
import com.seif.shopping.onlineshopping.entity.Product;
import com.seif.shopping.onlineshopping.requests.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    Product updateProduct(UpdateProductRequest product, Long id);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryName);
    List<Product> getProductsByBrand(String brandName);
    List<Product> getProductsByCategoryAndBrand(String categoryName, String brandName);
    List<Product> getProductsByName(String productName);
    List<Product> getProductsByBrandAndName(String brandName, String productName);
    Long countProductByBrandAndName(String brandName, String productName);
}
