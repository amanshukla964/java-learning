package org.example.controller;




import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.example.response.ProductResponse;
import org.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ProductResponse> search(
            @RequestParam(name = "search", required = false)
            @Size(max = 100) String search,

            @RequestParam(name = "category", required = false)
            @Size(max = 50) String category,

            @RequestParam(name = "minPrice", required = false)
            @DecimalMin("0.00") BigDecimal minPrice,

            @RequestParam(name = "maxPrice", required = false)
            @DecimalMin("0.00") BigDecimal maxPrice,

            @RequestParam(name = "page", defaultValue = "0")
            @Min(0) int page,

            @RequestParam(name = "size", defaultValue = "10")
            @Min(1) int size,

            @RequestParam(name = "sortBy", defaultValue = "name")
            String sortBy,

            @RequestParam(name = "direction", defaultValue = "asc")
            String direction) {

        if (size > 100) {
            throw new IllegalArgumentException(
                    "Page size cannot exceed 100");
        }

        if (minPrice != null && maxPrice != null
                && minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException(
                    "minPrice must not exceed maxPrice");
        }

        if (!sortBy.equals("name")
                && !sortBy.equals("price")
                && !sortBy.equals("id")) {
            throw new IllegalArgumentException(
                    "Unsupported sort field");
        }

        Sort.Direction sortDirection;
        try {
            sortDirection = Sort.Direction.fromString(direction);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                    "Direction must be asc or desc");
        }

        var pageable = PageRequest.of(
                page, size,
                Sort.by(sortDirection, sortBy));

        return service.search(
                ProductService.normalize(search),
                ProductService.normalize(category),
                minPrice, maxPrice, pageable);
    }
}

