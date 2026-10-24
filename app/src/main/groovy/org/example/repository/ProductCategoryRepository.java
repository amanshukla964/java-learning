package org.example.repository;

import org.example.entities.Product;
import org.example.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // Used by the Data Seeder to prevent duplicate mapping rows for the same product
    Optional<ProductCategory> findByProduct(Product product);
}
