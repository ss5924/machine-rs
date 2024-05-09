package me.songha.rs.machiners.product;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

//    @Cacheable(value = "PurchaseOrder", key = "#id", cacheManager = "cacheManager")
    public ProductDto getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"))
                .toProductDto();
    }

}
