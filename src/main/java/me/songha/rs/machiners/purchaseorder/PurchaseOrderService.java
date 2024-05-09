package me.songha.rs.machiners.purchaseorder;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;

//    @Cacheable(value = "PurchaseOrder", key = "#id", cacheManager = "cacheManager")
    public PurchaseOrderDto getPurchaseOrder(Long id) {
        return purchaseOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"))
                .toPurchaseOrderDto();
    }

}
