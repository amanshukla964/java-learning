package org.example.specification;


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("searchKeyGenerator")
public class SearchCacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        // Extract parameters safely matching your search method signature:
        // (String search, String category, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable)
        String search = params[0] != null ? params[0].toString().trim().toLowerCase() : "";
        String category = params[1] != null ? params[1].toString().trim().toLowerCase() : "";
        String minPrice = params[2] != null ? params[2].toString() : "0";
        String maxPrice = params[3] != null ? params[3].toString() : "max";

        String pageInfo = "default";
        if (params[4] instanceof Pageable pageable) {
            pageInfo = pageable.getPageNumber() + "-" + pageable.getPageSize() + "-" + pageable.getSort().toString();
        }

        // Build a bulletproof unique string key
        return String.format("prod_%s_%s_%s_%s_%s", search, category, minPrice, maxPrice, pageInfo);
    }
}
