package com.seif.shopping.onlineshopping.service.product;

import com.seif.shopping.onlineshopping.requests.ProductAddRequest;
import com.seif.shopping.onlineshopping.entity.Category;
import com.seif.shopping.onlineshopping.entity.Product;
import com.seif.shopping.onlineshopping.exception.ProductNotFoundException;
import com.seif.shopping.onlineshopping.repository.CategoryRepo;
import com.seif.shopping.onlineshopping.repository.ProductRepo;
import com.seif.shopping.onlineshopping.requests.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;


    private Product createProduct(ProductAddRequest product, Category category) {
        return new Product(
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getInventory(),
                product.getDescription(),
                category
        );
    }


    @Override
    public Product addProduct(ProductAddRequest product) {
        //check if the category is found in the database
        //if yes, set it as the new product category
        //if no, the save it as a new category
        //the set as the new product category

        Category category= Optional.ofNullable(categoryRepo.findByName(product.getCategory().getName()))
                .orElseGet(()->{
                    Category newCategory = new Category(product.getCategory().getName());
                    return categoryRepo.save(newCategory);
                });

        product.setCategory(category);
        return productRepo.save(createProduct(product, category));
    }



    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Not Found Product"));
    }

    private Product updateExistingProduct(Product exsistProduct, ProductUpdateRequest newProduct) {
        exsistProduct.setName(newProduct.getName());
        exsistProduct.setBrand(newProduct.getBrand());
        exsistProduct.setPrice(newProduct.getPrice());
        exsistProduct.setInventory(newProduct.getInventory());
        exsistProduct.setDescription(newProduct.getDescription());

        Category category = categoryRepo.findByName(newProduct.getCategory().getName());
        exsistProduct.setCategory(category);
        return exsistProduct;
    }
    @Override
    public Product updateProduct(ProductUpdateRequest product, Long id) {
        return productRepo.findById(id)
                .map(existingProduct->updateExistingProduct(existingProduct,product))
                .map(productRepo::save)
                .orElseThrow(()->new ProductNotFoundException("Not Found Product"));
    }


    @Override
    public void deleteProductById(Long id) {
        productRepo.findById(id).ifPresentOrElse(productRepo::delete,
                                    ()-> { throw new ProductNotFoundException("Not Found Product"); });
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepo.findByCategoryName(categoryName);
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return productRepo.findByBrand(brandName);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String categoryName, String brandName) {
        return productRepo.findByCategoryNameAndBrand(categoryName,brandName);
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepo.findByName(productName);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brandName, String productName) {
        return productRepo.findByBrandAndName(brandName,productName);
    }

    @Override
    public Long countProductByBrandAndName(String brandName, String productName) {
        return productRepo.countByBrandAndName(brandName,productName);
    }
}
