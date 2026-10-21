package org.example.service;



import org.example.entities.Product;
import org.example.repository.ProductRepository;
import org.example.response.ProductResponse;
import org.example.specification.ProductSpecification;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Locale;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Cacheable(
            cacheNames = "productSearch",
            key = "#search + '|' + #category + '|' + " +
                    "#minPrice + '|' + #maxPrice + '|' + " +
                    "#pageable.pageNumber + '|' + " +
                    "#pageable.pageSize + '|' + " +
                    "#pageable.sort.toString()"
    )
    public Page<ProductResponse> search(
            String search,
            String category,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Pageable pageable) {

        var specification = ProductSpecification.search(
                search, category, minPrice, maxPrice);

        return repository.findAll(specification, pageable)
                .map(ProductResponse::from);
    }

    @Transactional
    @CacheEvict(cacheNames = "productSearch", allEntries = true)
    public Product create(Product product) {
        return repository.save(product);
    }

    @Transactional
    @CacheEvict(cacheNames = "productSearch", allEntries = true)
    public Product update(Long id, Product input) {
        Product existing = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Product not found"));

        existing.update(
                input.getName(),
                input.getCategory(),
                input.getPrice());

        return repository.save(existing);
    }

    @Transactional
    @CacheEvict(cacheNames = "productSearch", allEntries = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public static String normalize(String value) {
        return value == null || value.isBlank()
                ? ""
                : value.trim().toLowerCase(Locale.ROOT);
    }
}
