package me.songha.rs.machiners.purchaseorder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/purchase-order")
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;

    @GetMapping(value = "/id/{id}")
    public PurchaseOrderDto getPurchaseOrder(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrder(id);
    }

}
