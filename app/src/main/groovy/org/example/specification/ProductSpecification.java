package org.example.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.example.entities.Category;
import org.example.entities.Product;
import org.example.entities.ProductCategory;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class ProductSpecification {

    private ProductSpecification() {}

    public static Specification<Product> search(
            String search,
            String category,
            BigDecimal minPrice,
            BigDecimal maxPrice) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. Text Search Filter (Case-insensitive)
            if (search != null && !search.trim().isEmpty()) {
                String pattern = "%" + search.trim().toLowerCase() + "%";
                predicates.add(cb.like(cb.lower(root.get("name")), pattern));
            }

            // 2. Relational Category Filter via the structural Mapping Table
            if (category != null && !category.trim().isEmpty()) {
                // Join Product -> ProductCategory mapping
                Join<Product, ProductCategory> productCategoryJoin = root.join("productCategory");
                // Join ProductCategory -> Category entity
                Join<ProductCategory, Category> categoryJoin = productCategoryJoin.join("category");

                // Perform a case-insensitive check on the category name
                predicates.add(cb.equal(
                        cb.lower(categoryJoin.get("name")),
                        category.trim().toLowerCase()
                ));
            }

            // 3. Price Filter Thresholds
            if (minPrice != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
