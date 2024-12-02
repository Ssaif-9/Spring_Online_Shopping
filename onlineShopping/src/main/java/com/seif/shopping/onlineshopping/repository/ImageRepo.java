package com.seif.shopping.onlineshopping.repository;

import com.seif.shopping.onlineshopping.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
