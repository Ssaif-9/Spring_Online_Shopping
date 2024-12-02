package com.seif.shopping.onlineshopping.repository;

import com.seif.shopping.onlineshopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String categoryName);

    List<Product> findByBrand(String brandName);

    List<Product> findByName(String productName);

    List<Product> findByBrandAndName(String brandName, String productName);

    List<Product> findByCategoryNameAndBrand(String categoryName, String brandName);

    Long countByBrandAndName(String brandName, String productName);
}
