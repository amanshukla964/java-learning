package org.example.response;

import org.example.entities.Product;
import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String category,
        BigDecimal price
) {
    public static ProductResponse from(Product product) {
        // Extract the nested category name safely, handling null checks
        String categoryName = "";
        if (product.getProductCategory() != null && product.getProductCategory().getCategory() != null) {
            categoryName = product.getProductCategory().getCategory().getName();
        }

        return new ProductResponse(
                product.getId(),
                product.getName(),
                categoryName,
                product.getPrice()
        );
    }
}
