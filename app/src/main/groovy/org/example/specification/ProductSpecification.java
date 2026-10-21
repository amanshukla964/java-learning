package org.example.specification;

import org.example.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Locale;

public final class ProductSpecification {

    private ProductSpecification() {}

    public static Specification<Product> search(
            String search,
            String category,
            BigDecimal minPrice,
            BigDecimal maxPrice) {

        return (root, query, cb) -> {
            var predicates = cb.conjunction();


            if(search != null && !search.trim().isEmpty() ){
               String pattern = "%"+ search.trim().toLowerCase() + "%";
               predicates = cb.like(root.get("name"), pattern);
            }
            if(category != null && !category.trim().isEmpty()){
                predicates =   cb.and(predicates,
                        cb.equal(root.get("category"),category)
                        );
            }
            if(minPrice != null ){
                predicates =   cb.and(predicates,
                        cb.greaterThanOrEqualTo(root.get("price"),minPrice)
                );
            }
            if(maxPrice != null ){
                predicates =   cb.and(predicates,
                        cb.lessThanOrEqualTo(root.get("price"),maxPrice)
                );
            }

            return predicates;
        };
    }
}
