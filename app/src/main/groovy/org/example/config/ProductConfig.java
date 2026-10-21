
package org.example.config;

import org.example.entities.Product;
import org.example.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner createProducts(ProductRepository productRepository) {
        return args -> seedProducts(productRepository);
    }

    @Transactional
    public void seedProducts(ProductRepository repository) {

        createOrUpdateProduct(repository,
                "iPhone 16", "Electronics", "79999.00");

        createOrUpdateProduct(repository,
                "Samsung Galaxy S25", "Electronics", "74999.00");

        createOrUpdateProduct(repository,
                "OnePlus 13", "Electronics", "69999.00");

        createOrUpdateProduct(repository,
                "MacBook Air M4", "Laptops", "99999.00");

        createOrUpdateProduct(repository,
                "Dell Inspiron 15", "Laptops", "54999.00");

        createOrUpdateProduct(repository,
                "Sony WH-1000XM5", "Accessories", "24999.00");

        createOrUpdateProduct(repository,
                "Logitech MX Master 3S", "Accessories", "9999.00");

        createOrUpdateProduct(repository,
                "Nike Air Max", "Footwear", "8999.00");

        createOrUpdateProduct(repository,
                "Adidas Ultraboost", "Footwear", "12999.00");

        createOrUpdateProduct(repository,
                "Apple iPad Air", "Electronics", "59999.00");
    }

    private void createOrUpdateProduct(
            ProductRepository repository,
            String name,
            String category,
            String price
    ) {
        Product product = repository.findByName(name)
                .orElseGet(Product::new);

        product.setName(name);
        product.setCategory(category);
        product.setPrice(new BigDecimal(price));

        repository.save(product);
    }
}
